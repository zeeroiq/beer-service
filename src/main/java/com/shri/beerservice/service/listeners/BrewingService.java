/*
 * Created by zeeroiq on 9/19/20, 2:34 AM
 */

/*
 * Created by zeeroiq on 9/18/20, 10:22 PM
 */

package com.shri.beerservice.service.listeners;

import com.shri.beerservice.config.JmsConfig;
import com.shri.beerservice.domain.Beer;
import com.shri.beerservice.service.InventoryService;
import com.shri.model.events.BrewBeerEvent;
import com.shri.beerservice.mapper.BeerMapper;
import com.shri.beerservice.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BrewingService {

    private final BeerRepository beerRepository;
    private final InventoryService inventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Transactional
    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer onHand = inventoryService.getInventoryOnHand(beer.getId());
            log.debug(">>>>> Checking Inventory for: " + beer.getBeerName() + " / " + beer.getId());
            log.debug(">>>>> Min quantity on hand : " + beer.getQuantityOnHand());
            log.debug(">>>>> Inventory is : " + onHand);

            if (beer.getQuantityOnHand() >= onHand) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
