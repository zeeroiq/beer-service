/*
 * Created by zeeroiq on 9/24/20, 1:46 AM
 */

package com.shri.beerservice.service.listeners;

import com.shri.beerservice.config.JmsConfig;
import com.shri.model.events.ValidateOrderRequest;
import com.shri.model.events.ValidateOrderResult;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderValidationListener {

    private final OrderValidator orderValidator;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest orderRequest) {
        Boolean isValid = orderValidator.validateOrder(orderRequest.getBeerOrder());
        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                ValidateOrderResult.builder()
                        .isValid(isValid)
                        .orderId(orderRequest.getBeerOrder().getId())
                        .build()
        );
    }
}
