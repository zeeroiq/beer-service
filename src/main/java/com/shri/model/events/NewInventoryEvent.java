/*
 * Created by zeeroiq on 9/19/20, 1:39 AM
 */

/*
 * Created by zeeroiq on 9/18/20, 10:13 PM
 */

package com.shri.model.events;

import com.shri.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
