/*
 * Created by  ZeeroIQ on 9/12/20, 1:21 AM
 */

/*******************************************************************************
 * Created by  ZeeroIQ on 9/7/20, 2:12 AM
 ******************************************************************************/

package com.shri.beerservice.repository;

import com.shri.beerservice.model.BeerDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerRepository extends PageImpl<BeerDto> {

    public BeerRepository(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerRepository(List<BeerDto> content) {
        super(content);
    }
}
