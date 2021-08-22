package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;

public class Continent {
    private final Set<Country> continentCountries = new HashSet<>();

    public void addCountry(Country country) {
        continentCountries.add(country);
    }

    public void removeCountry(Country country) {
        continentCountries.remove(country);
    }

    public Set<Country> getCountries() {
        return continentCountries;
    }
}
