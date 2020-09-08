/*
 * Created by  ZeeroIQ on 9/7/20, 2:20 AM
 */

package com.shri.beerservice.controller;

import com.shri.beerservice.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@NotNull @PathVariable("beerId") UUID beerId) {
        // todo
        return new ResponseEntity<>(BeerDto.builder().id(beerId).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        // todo
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@NotNull @PathVariable("beerId") UUID beerId) {
        // todo
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
