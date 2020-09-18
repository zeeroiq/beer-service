/*
 *  Created by zeeroiq on 9/18/20, 10:11 PM
 */

package com.shri.beerservice.events;

import com.shri.beerservice.model.BeerDto;

public class BrewBeerEvent extends BeerEvent{

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
