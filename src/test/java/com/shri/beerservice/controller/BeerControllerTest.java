/*
 * Created by  ZeeroIQ on 9/7/20, 2:34 AM
 */

package com.shri.beerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shri.beerservice.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(beerDtoToJson))
                .andExpect(status().isCreated());

    }

    @Test
    void updateBeerById() throws Exception {
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}