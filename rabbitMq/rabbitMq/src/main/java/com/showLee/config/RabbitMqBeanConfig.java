package com.showLee.config;


import com.showLee.RabbitMqConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AutoConfigureAfter(RabbitMqConfig.class)
public class RabbitMqBeanConfig {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqBeanConfig.class);

    //队列绑定
    @Bean(name = "user-queue")
    public Queue userQueue (){
        //不需要事务同步，一般都不开启
        return new Queue(RabbitMqConstants.USER_QUEUE,false);
    }

    //交换机
    @Bean
    public DirectExchange userExchange (){
        return new DirectExchange(RabbitMqConstants.USER_EXCHANGE,true,false);
    }

    //队列和交换机绑定
    @Bean
    public Binding userBinding (){
        return BindingBuilder.bind(userQueue()).to(userExchange()).with(RabbitMqConstants.USER_ROUTING_KEY);
    }


}


