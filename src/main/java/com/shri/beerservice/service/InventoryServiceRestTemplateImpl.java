/*
 * Created by  ZeeroIQ on 9/15/20, 2:55 AM
 */

package com.shri.beerservice.service;

import com.shri.beerservice.model.InventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@ConfigurationProperties(prefix = "com.zeeroiq", ignoreUnknownFields = false)
@RequiredArgsConstructor
@Service
public class InventoryServiceRestTemplateImpl implements InventoryService {

    private final String INVENTORY_PATH = "/api/v1/beer/{beerid}/inventory";
    private final RestTemplate restTemplate;

    private String inventoryServiceHostName;

    public void setInventoryServiceHostName(String inventoryServiceHostName) {
        this.inventoryServiceHostName = inventoryServiceHostName;
    }

    @Override
    public Integer getInventoryOnHand(UUID beerId) {
        log.info(">>>>> Calling inventory service");

        ResponseEntity<List<InventoryDto>> responseEntity = restTemplate.exchange(inventoryServiceHostName + INVENTORY_PATH,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<InventoryDto>>() {
                }, beerId);

        Integer onHand = Objects.requireNonNull(responseEntity.getBody())
                .stream()
                .mapToInt(InventoryDto::getQuantityOnHand)
                .sum();

        return onHand;
    }

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().build();
    }
}
