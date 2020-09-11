/*
 * Created by  ZeeroIQ on 9/12/20, 1:23 AM
 */

package com.shri.beerservice.service;

import com.shri.beerservice.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID id);
    BeerDto addBeer(BeerDto beerDto);
    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
