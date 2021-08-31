package com.kodilla.exception.main;

import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightCentre;
import com.kodilla.exception.test.RouteNotFoundException;


public class ExceptionModuleReader {

    public static void main(String[] args) {
        Flight lot1 = new Flight("Warszawa", "Wrocław");
        Flight lot2 = new Flight("Warszawa", "Paryżs");
        try {
            System.out.println(FlightCentre.findFlight(lot2));
        } catch (RouteNotFoundException e) {
            System.out.println("Nie znaleziono lotu");
        }
    }
}