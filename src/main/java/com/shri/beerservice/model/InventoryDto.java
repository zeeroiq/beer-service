/*
 * Created by  ZeeroIQ on 9/15/20, 3:11 AM
 */

package com.shri.beerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDto {

    private UUID id;
    private OffsetDateTime createdOn;
    private OffsetDateTime modifiedOn;
    private UUID beerId;
    private Integer quantityOnHand;

}
