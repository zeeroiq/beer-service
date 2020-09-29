/*
 * Created by zeeroiq on 9/18/20, 10:48 PM
 */

package com.shri.beerservice.service.listeners;

import com.shri.beerservice.config.JmsConfig;
import com.shri.beerservice.domain.Beer;
import com.shri.beerservice.repository.BeerRepository;
import com.shri.model.BeerDto;
import com.shri.model.events.BrewBeerEvent;
import com.shri.model.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();
        Beer one = beerRepository.getOne(beerDto.getId());
        beerDto.setQuantityOnHand(one.getQuantityToBrew());
        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);
        log.debug("<<<<< Brewed beer " + one.getQuantityOnHand() + " Quantity on hand " + beerDto.getQuantityOnHand());
        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
