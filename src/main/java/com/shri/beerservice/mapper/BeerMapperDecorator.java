/*
 * Created by  ZeeroIQ on 9/15/20, 3:45 AM
 */

package com.shri.beerservice.mapper;

import com.shri.beerservice.domain.Beer;
import com.shri.beerservice.service.InventoryService;
import com.shri.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

//@Qualifier("delegate")
public abstract class BeerMapperDecorator implements BeerMapper {

    private InventoryService inventoryService;
    private BeerMapper beerMapper;

    @Autowired
    public void setBeerInventoryService(InventoryService beerInventoryService) {
        this.inventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.beerMapper = mapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        return beerMapper.beerToBeerDto(beer);
    }


    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        BeerDto beerDto = beerMapper.beerToBeerDto(beer);
        beerDto.setQuantityOnHand(inventoryService.getInventoryOnHand(beer.getId()));
        return beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return beerMapper.beerDtoToBeer(beerDto);
    }
}
