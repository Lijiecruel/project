package com.showLee.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.showLee.RabbitMqConstants;
import com.showLee.entity.RabbitConfig;
import com.showLee.entity.User;
import com.showLee.server.ProducerService;
import com.showLee.utils.RabbitMqUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
public  class UserProducer {

    @Resource
    private ProducerService producerService;

    @Test
    public void send () throws JsonProcessingException {
        User user = new User();
        user.setId("21342334");
        user.setUsername("guest");
        user.setPassword("guest");
        RabbitConfig config = RabbitConfig.create().setExchange(RabbitMqConstants.USER_EXCHANGE)
                .setMessageId(RabbitMqUtils.getMessagerId())
                .setObj(user)
                .setRoutingKey(RabbitMqConstants.USER_ROUTING_KEY)
                .build();
        producerService.sender(config);
   }

}
