/*******************************************************************************
 * Created by  ZeeroIQ on 9/7/20, 2:12 AM
 ******************************************************************************/

package com.shri.beerservice.service;

import com.shri.beerservice.model.BeerDto;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPagedList extends PageImpl<BeerDto> {

    public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(List<BeerDto> content) {
        super(content);
    }
}
