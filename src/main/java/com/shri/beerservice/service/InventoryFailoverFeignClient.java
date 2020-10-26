/*
 * Created by zeeroiq on 10/27/20, 2:00 AM
 */

package com.shri.beerservice.service;

import com.shri.model.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "inventory-failover")
public interface InventoryFailoverFeignClient {

    @GetMapping("/inventory-failover")
    ResponseEntity<List<InventoryDto>> getInventoryOnHand();
}
