/*
 * Created by  ZeeroIQ on 9/15/20, 2:55 AM
 */

package com.shri.beerservice.service;

import com.shri.model.InventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Profile("!local-discovery")
@ConfigurationProperties(prefix = "com.zeeroiq", ignoreUnknownFields = true)
@Service
public class InventoryServiceRestTemplateImpl implements InventoryService {

    public static final String INVENTORY_PATH = "/api/v1/beer/{beerId}/inventory";
    private final RestTemplate restTemplate;

    private String inventoryServiceHost;

    public InventoryServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder,
                                            @Value("${com.zeeroiq.inventory-user}") String inventoryUser,
                                            @Value("${com.zeeroiq.inventory-password}") String inventoryPassword) {
        this.restTemplate = restTemplateBuilder
                .basicAuthentication(inventoryUser, inventoryPassword)
                .build();
    }

    public void setInventoryServiceHost(String inventoryServiceHost) {
        this.inventoryServiceHost = inventoryServiceHost;
    }

    @Override
    public Integer getInventoryOnHand(UUID beerId) {
        log.info(">>>>> Calling inventory service");

        ResponseEntity<List<InventoryDto>> responseEntity = restTemplate.exchange(inventoryServiceHost + INVENTORY_PATH,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }, (Object)beerId);

        Integer onHand = Objects.requireNonNull(responseEntity.getBody())
                .stream()
                .mapToInt(InventoryDto::getQuantityOnHand)
                .sum();

        return onHand;
    }

//    @Bean
//    RestTemplate getRestTemplate() {
//        RestTemplate restTemplate = new RestTemplateBuilder().build();
//        return restTemplate;
//    }
}
