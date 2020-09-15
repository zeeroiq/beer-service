/*
 * Created by  ZeeroIQ on 9/12/20, 1:25 AM
 */

package com.shri.beerservice.service;

import com.shri.beerservice.domain.Beer;
import com.shri.beerservice.exceptions.NotFoundException;
import com.shri.beerservice.mapper.BeerMapper;
import com.shri.beerservice.model.BeerDto;
import com.shri.beerservice.model.BeerPagedList;
import com.shri.beerservice.model.enums.BeerStyleEnum;
import com.shri.beerservice.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID id, Boolean showInventoryOnHand) {
        if (showInventoryOnHand) {
            return beerMapper.beerToBeerDtoWithInventory(beerRepository.findById(id).orElseThrow(NotFoundException::new));
        } else {
            return beerMapper.beerToBeerDto(beerRepository.findById(id).orElseThrow(NotFoundException::new));
        }
    }

    @Override
    public BeerDto addBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc().toString());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {

        BeerPagedList pagedList;
        Page<Beer> beers;

        if (!StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
            beers = beerRepository.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pageRequest);
        } else if (!StringUtils.isEmpty(beerName) && StringUtils.isEmpty((beerStyle))) {
            beers = beerRepository.findAllByBeerName(beerName, pageRequest);
        } else if (StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
            beers = beerRepository.findAllByBeerStyle(beerStyle, pageRequest);
        } else {
            beers = beerRepository.findAll(pageRequest);
        }

        if (showInventoryOnHand) {

            pagedList = new BeerPagedList(beers.getContent()
                    .stream()
                    .map(beerMapper::beerToBeerDtoWithInventory)
                    .collect(Collectors.toList()),
                    PageRequest
                            .of(beers.getPageable().getPageNumber(),
                                    beers.getPageable().getPageSize()),
                    beers.getTotalElements());
        } else {

            pagedList = new BeerPagedList(beers.getContent()
                    .stream()
                    .map(beerMapper::beerToBeerDto)
                    .collect(Collectors.toList()),
                    PageRequest
                            .of(beers.getPageable().getPageNumber(),
                                    beers.getPageable().getPageSize()),
                    beers.getTotalElements());
        }

        return pagedList;
    }
}
