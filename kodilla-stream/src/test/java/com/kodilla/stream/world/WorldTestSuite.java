package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {

        //Given
        Continent asia = new Continent();
        asia.addCountry(new Country("Indonesia", new BigDecimal("245452739")));
        asia.addCountry(new Country("China", new BigDecimal("1314480000")));
        asia.addCountry(new Country("India", new BigDecimal("1095351995")));


        Continent europe = new Continent();
        europe.addCountry(new Country("Germany", new BigDecimal("82422299")));
        europe.addCountry(new Country("France", new BigDecimal("62752136")));
        europe.addCountry(new Country("United Kingdom", new BigDecimal("60609153")));

        Continent africa = new Continent();
        africa.addCountry( new Country("Nigeria", new BigDecimal("131859731")));
        africa.addCountry(new Country("Ethiopia", new BigDecimal("131859731")));

        World continents = new World();
        continents.addContinent(asia, africa,europe);

        //When
        BigDecimal peopleAmount = continents.getPeopleQuantity();

        //Then
        assertEquals(new BigDecimal("3124787784"), peopleAmount);
    }

}
