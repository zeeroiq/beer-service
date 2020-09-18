/*
 * Created by zeeroiq on 9/18/20, 10:13 PM
 */

package com.shri.beerservice.events;

import com.shri.beerservice.model.BeerDto;

public class NewInventoryEvent extends BeerEvent{
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
