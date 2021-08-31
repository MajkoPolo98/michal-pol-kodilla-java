package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;


public class FlightCentre {
    public static Boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> availableFlights = new HashMap<>();
        availableFlights.put("Wrocław", true);
        availableFlights.put("Paryż", true);
        availableFlights.put("Praga", false);

        Boolean isAvailable = availableFlights.get(flight.getArrivalAirport());

        //Optional<Boolean> optionalFlight = Optional.ofNullable(isAvailable);
        if (isAvailable != null) {
            return isAvailable;
        } else {
            throw new RouteNotFoundException();
        }
    }
}
