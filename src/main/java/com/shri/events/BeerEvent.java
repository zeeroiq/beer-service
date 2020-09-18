/*
 * Created by zeeroiq on 9/19/20, 1:39 AM
 */

/**
 * Created by zeeroiq on 9/18/20, 10:09 PM
 */

package com.shri.events;

import com.shri.beerservice.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -1928135535925632254L;

    private BeerDto beerDto;
}
