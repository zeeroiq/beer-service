/*
 * Created by  ZeeroIQ on 9/15/20, 2:54 AM
 */

package com.shri.beerservice.service;

import java.util.UUID;

public interface InventoryService {
    Integer getInventoryOnHand(UUID uuid);
}
