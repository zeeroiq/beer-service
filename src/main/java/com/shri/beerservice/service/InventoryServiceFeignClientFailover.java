/*
 * Created by zeeroiq on 10/27/20, 2:04 AM
 */

package com.shri.beerservice.service;

import com.shri.model.InventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class InventoryServiceFeignClientFailover implements InventoryServiceFeignClient {

    private final InventoryFailoverFeignClient failoverFeignClient;
    @Override
    public ResponseEntity<List<InventoryDto>> getInventoryOnHand(UUID beerId) {
        return failoverFeignClient.getInventoryOnHand();
    }
}
