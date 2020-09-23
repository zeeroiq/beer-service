/*
 * Created by zeeroiq on 9/24/20, 1:47 AM
 */

package com.shri.beerservice.service.listeners;

import com.shri.beerservice.repository.BeerRepository;
import com.shri.model.BeerOrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderValidator {

    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrderDto) {
        AtomicInteger beerNotFound = new AtomicInteger();
        beerOrderDto.getBeerOrderLines()
                .forEach(orderLine -> {
                    if (beerRepository.findByUpc(orderLine.getUpc()) == null) {
                        beerNotFound.incrementAndGet();
                    }
                });

        return beerNotFound.get() == 0;
    }
}
