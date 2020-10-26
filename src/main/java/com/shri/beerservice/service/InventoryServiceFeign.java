/*
 * Created by zeeroiq on 10/26/20, 6:21 AM
 */

package com.shri.beerservice.service;

import com.shri.model.InventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Profile("local-discovery")
@Service
public class InventoryServiceFeign implements InventoryService{

    private final InventoryServiceFeignClient inventoryServiceFeignClient;

    @Override
    public Integer getInventoryOnHand(UUID beerId) {
        log.info(">>>>> Calling inventory service");

        ResponseEntity<List<InventoryDto>> responseEntity = inventoryServiceFeignClient.getInventoryOnHand(beerId);

        Integer onHand = Objects.requireNonNull(responseEntity.getBody())
                .stream()
                .mapToInt(InventoryDto::getQuantityOnHand)
                .sum();

        log.debug("<<<<< BeerId: " + beerId + " On Hand is: " + onHand);
        return onHand;
    }
}
