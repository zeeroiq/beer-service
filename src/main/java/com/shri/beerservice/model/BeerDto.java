package com.shri.beerservice.model;

import com.shri.beerservice.model.enums.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerDto implements Serializable {

    private static final UUID uuid = UUID.randomUUID();

    private UUID id;
    private Integer version;
    private OffsetDateTime createTime;
    private OffsetDateTime lastModifiedTime;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private long upc;
    private BigDecimal price;
    private Integer quantityOnHand;

}
