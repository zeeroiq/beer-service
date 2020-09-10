/*
 * Created by  ZeeroIQ on 9/11/20, 12:01 AM
 */

package com.shri.beerservice.domain;

import com.shri.beerservice.model.enums.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {


    private UUID id;
    private Integer version;
    private OffsetDateTime createdOn;
    private OffsetDateTime lastModifiedOn;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long utc;
    private BigDecimal price;
    private Integer quantityOnHand;
}
