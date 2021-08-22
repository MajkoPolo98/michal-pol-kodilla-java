package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class World {
    private final List<Continent> world = new ArrayList<>();

    public void addContinent(Continent... continents) {
        for(Continent continent: continents)
        world.add(continent);
    }

    public void removeContinent(Continent continent) {
        world.remove(continent);
    }

    public BigDecimal getPeopleQuantity(){
        return world.stream().flatMap(continent -> continent.getCountries().stream())
                .map(Country::getpeopleQuantity).reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

}
