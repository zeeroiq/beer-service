/*
<<<<<<< HEAD:src/main/java/com/shri/model/InventoryDto.java
 * Created by zeeroiq on 9/23/20, 12:40 AM
=======
 * Created by zeeroiq on 9/19/20, 3:15 AM
>>>>>>> 6ebe9aa1787ba621fcb6e1f71e75f0d20a751182:src/main/java/com/shri/beerservice/model/InventoryDto.java
 */

/*
 * Created by  ZeeroIQ on 9/15/20, 3:11 AM
 */

package com.shri.model;

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
