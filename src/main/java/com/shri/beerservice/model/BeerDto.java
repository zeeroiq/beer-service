package com.shri.beerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
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


    @Null
    private UUID id;
    @Null
    private Integer version;
    @Null
    private OffsetDateTime createdOn;
    @Null
    private OffsetDateTime lastModifiedOn;
    @NotBlank
    private String beerName;
    @NotNull
    private String beerStyle;
    @Positive
    @NotNull
    private Long utc;
    @Positive
    @NotNull
    private BigDecimal price;
    private Integer quantityOnHand;

}
