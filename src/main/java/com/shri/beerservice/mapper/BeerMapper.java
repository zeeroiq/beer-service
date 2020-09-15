/*
 * Created by  ZeeroIQ on 9/10/20, 11:44 PM
 */

package com.shri.beerservice.mapper;

import com.shri.beerservice.domain.Beer;
import com.shri.beerservice.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);

}
