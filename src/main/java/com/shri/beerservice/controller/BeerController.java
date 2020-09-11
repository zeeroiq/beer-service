/*
 * Created by  ZeeroIQ on 9/7/20, 2:20 AM
 */

package com.shri.beerservice.controller;

import com.shri.beerservice.model.BeerDto;
import com.shri.beerservice.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@NotNull @PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity(beerService.addBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@NotNull @PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDto beerDto) {
        return new ResponseEntity(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}
