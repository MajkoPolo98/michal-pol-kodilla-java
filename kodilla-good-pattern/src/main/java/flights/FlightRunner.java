package flights;

import java.util.List;

public class FlightRunner {
    public static void main (String args[]){
        Flight flight1 = new Flight(AvailableDestinations.Wroclaw, AvailableDestinations.Warszawa);
        Flight flight2 = new Flight(AvailableDestinations.Wroclaw, AvailableDestinations.Berlin);
        Flight flight3 = new Flight(AvailableDestinations.Warszawa, AvailableDestinations.Berlin);
        Flight flight4 = new Flight(AvailableDestinations.Wroclaw, AvailableDestinations.Monachium);
        Flight flight5 = new Flight(AvailableDestinations.Krakow, AvailableDestinations.Berlin);
        Flight flight6 = new Flight(AvailableDestinations.Wroclaw, AvailableDestinations.Praga);

        FlightService flightService = new FlightService();

        flightService.addFlight(flight1);
        flightService.addFlight(flight2);
        flightService.addFlight(flight3);
        flightService.addFlight(flight4);
        flightService.addFlight(flight5);
        flightService.addFlight(flight6);

        List<List<Flight>> flightList = flightService.searchForFlight(AvailableDestinations.Wroclaw, AvailableDestinations.Berlin);
        flightService.printList(flightList);

    }
}
