/*
 * Created by  ZeeroIQ on 9/15/20, 11:22 PM
 */

package com.shri.beerservice.bootstrap;

import com.shri.beerservice.domain.Beer;
import com.shri.beerservice.repository.BeerRepository;
import com.shri.model.enums.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class BeerLoader implements CommandLineRunner {
    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
//    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
//    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
//    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0) {
            loadBeers();
        }
    }

    private void loadBeers() {
        beerRepository.save(Beer.builder()
//                .id(BEER_1_UUID)
                .beerName("CORONA")
                .beerStyle(BeerStyleEnum.ALE)
                .quantityToBrew(200)
                .quantityOnHand(20)
                .upc(BEER_1_UPC)
                .price(new BigDecimal("120.00"))
                .build());
        beerRepository.save(Beer.builder()
//                .id(BEER_2_UUID)
                .beerName("BIRA")
                .beerStyle(BeerStyleEnum.LAGER)
                .quantityToBrew(100)
                .quantityOnHand(25)
                .upc(BEER_2_UPC)
                .price(new BigDecimal("130.00"))
                .build());
        beerRepository.save(Beer.builder()
//                .id(BEER_3_UUID)
                .beerName("TUBORG")
                .beerStyle(BeerStyleEnum.MALT)
                .quantityToBrew(10)
                .quantityOnHand(20)
                .upc(BEER_3_UPC)
                .price(new BigDecimal("190.00"))
                .build());

        log.debug(">>>>> Number of beers in inventory: " + beerRepository.count());
    }
}
