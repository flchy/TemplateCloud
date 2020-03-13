package com.flchy.cloud.miniapp.config;

import com.flchy.cloud.mq.MQMiniAppConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nieqs
 * @date 2019/12/5
 * @description 消息队列
 */
@Configuration
public class RabbitConfig {

    /**
     * 定义个topic交换器
     *
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new TopicExchange(MQMiniAppConstants.MINIAPP_TOPIC_EXCHANGE);
    }

    /**
     * 序列化微信用户信息
     * @return
     */
    @Bean
    public Queue updateMiniappUser() {
        return new Queue(MQMiniAppConstants.UPDATE_MINIAPP_USER, Boolean.TRUE);
    }

    /**
     * 序列化微信用户信息 绑定交换机
     * @return
     */
    @Bean
    public Binding bindingEditMiniAppUserExchangeWith() {
        return BindingBuilder.bind(updateMiniappUser()).to(topicExchange()).with(MQMiniAppConstants.UPDATE_MINIAPP_USER);
    }




}
