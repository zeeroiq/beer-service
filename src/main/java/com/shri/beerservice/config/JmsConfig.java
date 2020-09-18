package com.shri.beerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {
    public static final String BREWING_REQUEST_QUEUE = "brewing-request";
    public static final String NEW_INVENTORY_QUEUE = "new-inventory";

    // serialize message content to json using TextMessage
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTargetType(MessageType.TEXT);
        messageConverter.setTypeIdPropertyName("_type");
        return messageConverter;
    }
}
