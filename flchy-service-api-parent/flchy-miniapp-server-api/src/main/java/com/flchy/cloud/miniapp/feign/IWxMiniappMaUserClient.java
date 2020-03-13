package com.flchy.cloud.miniapp.feign;

import com.flchy.cloud.context.BaseModuleConstant;
import com.flchy.cloud.miniapp.feign.impl.IWxMiniappMaUserFallback;
import com.flchy.cloud.miniapp.vo.MiniappSessionVo;
import com.flchy.cloud.miniapp.vo.WechatLoginVo;
import com.flchy.cloud.response.ResponseResult;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@FeignClient(name = BaseModuleConstant.SAFETY_MINIAPP_SERVER, fallbackFactory = IWxMiniappMaUserFallback.class)
public interface IWxMiniappMaUserClient {
    /**
     * 小程序登陆接口
     */
    @PostMapping("/wxminapp/user/{appid}/login")
    ResponseResult<MiniappSessionVo> login(@PathVariable @ApiParam(name = "appid", value = "小程序appId", required = true) String appid, @RequestBody @Valid WechatLoginVo vo);

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
//    @PostMapping("/wxminapp/user/{appid}/phone")
//    ResponseResult<String> phone(@PathVariable String appid, String sessionKey, String signature, String rawData, String encryptedData, String iv);

}
