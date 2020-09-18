/**
 * Created by zeeroiq on 9/18/20, 10:09 PM
 */

package com.shri.beerservice.events;

import com.shri.beerservice.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -1928135535925632254L;

    private final BeerDto beerDto;
}
