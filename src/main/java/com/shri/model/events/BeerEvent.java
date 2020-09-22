/*
 * Created by zeeroiq on 9/19/20, 1:39 AM
 */

/**
 * Created by zeeroiq on 9/18/20, 10:09 PM
 */

package com.shri.model.events;

import com.shri.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = -1928135535925632254L;

    private BeerDto beerDto;
}
