/*******************************************************************************
 * Created by  ZeeroIQ on 9/7/20, 2:12 AM
 ******************************************************************************/

package com.shri.beerservice.repository;

import com.shri.beerservice.domain.Beer;
import com.shri.model.enums.BeerStyleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

    Page<Beer> findAllByBeerName(String beerName, PageRequest pageRequest);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, PageRequest pageRequest);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    Beer getBeerByUpc(String upc);
}
