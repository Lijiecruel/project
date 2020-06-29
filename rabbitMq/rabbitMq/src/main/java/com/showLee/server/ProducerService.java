package com.showLee.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.showLee.entity.RabbitConfig;

public interface ProducerService {

    void sender (RabbitConfig rabbitConfig) throws JsonProcessingException;

}
