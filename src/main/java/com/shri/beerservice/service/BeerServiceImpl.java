/*
 * Created by  ZeeroIQ on 9/12/20, 1:25 AM
 */

package com.shri.beerservice.service;

import com.shri.beerservice.domain.Beer;
import com.shri.beerservice.exceptions.NotFoundException;
import com.shri.beerservice.mapper.BeerMapper;
import com.shri.beerservice.model.BeerDto;
import com.shri.beerservice.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID id) {
        return beerMapper.beerToBeerDto(beerRepository.findById(id).orElseThrow(NotFoundException::new));
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
        beer.setUtc(beerDto.getUtc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
