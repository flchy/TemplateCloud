package com.flchy.cloud.miniapp.wechat.miniapp.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.alibaba.fastjson.JSON;
import com.flchy.cloud.enums.BaseEWarning;
import com.flchy.cloud.exception.BusinessException;
import com.flchy.cloud.miniapp.service.IWechatUserService;
import com.flchy.cloud.miniapp.vo.MiniappSessionVo;
import com.flchy.cloud.miniapp.vo.WechatLoginVo;
import com.flchy.cloud.miniapp.wechat.miniapp.config.WxMaConfiguration;
import com.flchy.cloud.mq.MQMiniAppConstants;
import com.flchy.cloud.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@RestController
@RequestMapping("/wxminapp/user/{appid}")
@Api(tags = "微信小程序用户接口")
public class WxMiniappMaUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    IWechatUserService iWechatUserService;
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 登陆接口
     */
    @PostMapping("/login")
    @ApiOperation(value = "登陆接口")
    public ResponseResult<MiniappSessionVo> login(@PathVariable @ApiParam(name = "appid", value = "小程序appId", required = true) String appid, @RequestBody @Valid WechatLoginVo vo) {
        if (StringUtils.isBlank(vo.getCode())) {
            logger.info("code不能为空");
            throw new BusinessException(BaseEWarning.ErrorParams, "code不能为空");
        }
        logger.info("登录请求：code:{} ,json：{} ", JSON.toJSONString(vo));
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(vo.getCode());
            logger.info("session:{}", JSON.toJSONString(session));
            // 用户信息校验
            if (!wxService.getUserService().checkUserInfo(session.getSessionKey(), vo.getRawData(), vo.getSignature())) {
                throw new BusinessException("用户检查失败");
            }
            WxMaUserInfo userInfo = wxService.getUserService().getUserInfo(session.getSessionKey(), vo.getEncryptedData(), vo.getIv());
            logger.info("user:{}", JSON.toJSONString(userInfo));
            MiniappSessionVo sessionVo = new MiniappSessionVo();
            BeanUtils.copyProperties(userInfo, sessionVo);
            sessionVo.setAppId(appid);
            sessionVo.setSessionKey(session.getSessionKey());
            amqpTemplate.convertAndSend(MQMiniAppConstants.MINIAPP_TOPIC_EXCHANGE, MQMiniAppConstants.MINIAPP_TOPIC_EXCHANGE, sessionVo);
            return new ResponseResult<>(sessionVo);
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            return new ResponseResult(BaseEWarning.Unknown, e.getMessage());
        }
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @PostMapping("/phone")
    @ApiOperation(value = "获取用户绑定手机号信息")
    public ResponseResult<String> phone(@PathVariable String appid, String sessionKey, String signature,
                        String rawData, String encryptedData, String iv) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);

        // 用户信息校验
        if (!wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return new ResponseResult<>(BaseEWarning.SYSTEM_BUSY);
        }
        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);
        return new ResponseResult<>(JSON.toJSONString(phoneNoInfo));
    }

}
