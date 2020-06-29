package com.showLee.entity;

import java.io.Serializable;

public class RabbitConfig<T> implements Serializable {

    private String exchange;

    private String routingKey;

    private String messageId;

    private T obj;

    public static Builder create (){
        return new Builder();
    }

    public static class Builder{

         String exchange;

         String routingKey;

         String messageId;

         Object obj;

        public Builder setExchange(String exchange) {
            this.exchange = exchange;
            return this;
        }

        public Builder setRoutingKey(String routingKey) {
            this.routingKey = routingKey;
            return this;
        }

        public Builder setMessageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setObj(Object obj) {
            this.obj = obj;
            return this;
        }

        public RabbitConfig build (){
            RabbitConfig config = new RabbitConfig();
            config.setExchange(exchange);
            config.setMessageId(messageId);
            config.setRoutingKey(routingKey);
            config.setObj(obj);
            return config;
        }
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "RabbitConfig{" +
                "exchange='" + exchange + '\'' +
                ", routingKey='" + routingKey + '\'' +
                ", messageId='" + messageId + '\'' +
                ", obj=" + obj +
                '}';
    }
}
