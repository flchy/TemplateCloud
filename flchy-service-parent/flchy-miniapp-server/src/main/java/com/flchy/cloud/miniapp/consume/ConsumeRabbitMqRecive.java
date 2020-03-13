package com.flchy.cloud.miniapp.consume;

import com.alibaba.fastjson.JSON;
import com.flchy.cloud.miniapp.service.IWechatUserService;
import com.flchy.cloud.miniapp.vo.MiniappSessionVo;
import com.flchy.cloud.mq.MQMiniAppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author nieqs
 * @date 2019/12/5
 * @description 消费消息队列
 */
@Component
@Slf4j
public class ConsumeRabbitMqRecive {
    @Resource
    IWechatUserService iWechatUserService;

    /**
     * 序列化微信用户信息
     *
     * @param sessionVo
     */
    @RabbitListener(queues = MQMiniAppConstants.UPDATE_MINIAPP_USER)
    public void updateMiniappUser(MiniappSessionVo sessionVo) {
        log.info("---------序列化微信用户信息 start----------");
        log.info(JSON.toJSONString(sessionVo));
        try {
            iWechatUserService.editMiniAppUser(sessionVo);
        } catch (Exception e) {
            log.error("序列化微信用户信息失败:{}", e.getMessage());
            e.printStackTrace();
        }
        log.info("---------序列化微信用户信息 end----------");
    }


}
