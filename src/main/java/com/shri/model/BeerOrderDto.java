/*
 * Created by zeeroiq on 9/23/20, 12:42 AM
 */

package com.shri.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerOrderDto extends BaseItem implements Serializable {

    private static final long serialVersionUID = -8810162970401171318L;
    private UUID customerId;
    private String customerReference;
    private CustomerDto customerDto;
    private List<BeerOrderLineDto> beerOrderLines;
    private String orderStatus;
    private String orderStatusCallbackUrl;
}
