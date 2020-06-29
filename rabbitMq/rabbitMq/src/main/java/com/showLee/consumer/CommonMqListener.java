package com.showLee.consumer;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.showLee.RabbitMqConstants;
import com.showLee.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommonMqListener {

    private static final Logger log= LoggerFactory.getLogger(CommonMqListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitMqConstants.USER_QUEUE)
    public void onUserMessage (@Payload byte[] message) throws IOException {
        User user =  objectMapper.readValue(message, User.class);
        log.info("监听消费用户日志 监听到消息： {} ", JSONObject.toJSONString(user));
    }
}
