/*
 * Created by zeeroiq on 9/19/20, 1:39 AM
 */

/*
 *  Created by zeeroiq on 9/18/20, 10:11 PM
 */

package com.shri.model.events;

import com.shri.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent{

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }

}
