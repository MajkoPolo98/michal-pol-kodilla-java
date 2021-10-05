package flights;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private HashSet<Flight> flights = new HashSet<>();



    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public List<Flight> getArrivalCities(AvailableDestinations from){
        return flights.stream().filter(e -> e.getFrom() == from).collect(Collectors.toList());
    }

    public List<Flight> getDepartureCities(AvailableDestinations to){
        return flights.stream().filter(e -> e.getTo() == to).collect(Collectors.toList());
    }

    public List<List<Flight>> searchForFlight(AvailableDestinations from, AvailableDestinations to){
        List<List<Flight>> availableFlights = new LinkedList<>();
        availableFlights.add(flights.stream().filter(e -> e.getFrom() == from &&
                e.getTo()==to).collect(Collectors.toList()));

        List<Flight> allFlightsFrom = getArrivalCities(from);
        List<Flight> allFlightsTo = getDepartureCities(to);

        for(Flight flightFrom: allFlightsFrom) {
            for (Flight flightTo : allFlightsTo) {
                if (flightFrom.getTo() == flightTo.getFrom()) {
                    List<Flight> flightOption = new LinkedList<>();
                    flightOption.add(flightFrom);
                    flightOption.add(flightTo);
                    availableFlights.add(flightOption);
                }
            }
        }


        return availableFlights;
    }

    public void printList(List<List<Flight>> availableFlights){
        int j = 1;
        for(List<Flight> flightPair: availableFlights){
            int i = 1;
            System.out.println();
            for(Flight flight: flightPair){
                if (i==1){
                    System.out.println("Option " + j);
                    j++;
                }
                System.out.println("Flight " + i + ": " + flight.getFrom() + "-" + flight.getTo());
                i++;
            }
        }
    }
}
