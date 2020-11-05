/*
 * Created by  ZeeroIQ on 9/15/20, 2:54 AM
 */

package com.shri.beerservice.service;

import com.shri.beerservice.config.FeignClientConfig;
import com.shri.model.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "inventory-service", fallback = InventoryServiceFeignClientFailover.class, configuration = FeignClientConfig.class)
public interface InventoryServiceFeignClient {

    @GetMapping(InventoryServiceRestTemplateImpl.INVENTORY_PATH)
    ResponseEntity<List<InventoryDto>> getInventoryOnHand(@PathVariable UUID beerId);
}
