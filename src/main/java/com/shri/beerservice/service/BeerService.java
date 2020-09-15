/*
 * Created by  ZeeroIQ on 9/12/20, 1:23 AM
 */

package com.shri.beerservice.service;

import com.shri.beerservice.model.BeerDto;
import com.shri.beerservice.model.BeerPagedList;
import com.shri.beerservice.model.enums.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID id, Boolean showInventoryOnHand);
    BeerDto addBeer(BeerDto beerDto);
    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum styleEnum, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc);
}
