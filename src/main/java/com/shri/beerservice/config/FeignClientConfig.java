/*
 * Created by zeeroiq on 11/6/20, 3:15 AM
 */

package com.shri.beerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthenticationInterceptor basicAuthenticationInterceptor(@Value("${com.zeeroiq.inventory-user}") String inventoryUser,
                                                                         @Value("${com.zeeroiq.inventory-password}") String inventoryPassword){
        return new BasicAuthenticationInterceptor(inventoryUser, inventoryPassword);
    }
}
