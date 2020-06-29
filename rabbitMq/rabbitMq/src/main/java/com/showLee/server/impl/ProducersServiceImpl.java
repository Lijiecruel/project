package com.showLee.server.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.showLee.entity.RabbitConfig;
import com.showLee.server.ProducerService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ProducersServiceImpl implements ProducerService {


    @Resource
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;



    @Override
    public void sender(RabbitConfig rabbitConfig) throws JsonProcessingException {
        rabbitTemplate.setExchange(rabbitConfig.getExchange());
        rabbitTemplate.setRoutingKey(rabbitConfig.getRoutingKey());
        Message message= MessageBuilder.withBody(objectMapper.writeValueAsBytes(rabbitConfig.getObj())).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
        rabbitTemplate.convertAndSend(message);
    }
}
