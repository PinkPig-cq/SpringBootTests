package com.hpeu.rabbitmq.configure;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigure {

    /**org.springframework.amqp.support.converter.MessageConverter
     * 创建一个Josn序列化器
     * 默认是使用JDK的序列化
     * 是考一个问题  为什么要用Json呢？  被拦截了可读不就凉了么？  前台需要可读数据  不可能用JDK来反序列化吧
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
