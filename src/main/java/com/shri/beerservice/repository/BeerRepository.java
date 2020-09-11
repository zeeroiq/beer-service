/*******************************************************************************
 * Created by  ZeeroIQ on 9/7/20, 2:12 AM
 ******************************************************************************/

package com.shri.beerservice.repository;

import com.shri.beerservice.domain.Beer;
import com.shri.beerservice.model.BeerDto;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
