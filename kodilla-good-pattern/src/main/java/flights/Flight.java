package flights;

import java.time.LocalDate;

public class Flight {
    private AvailableDestinations from;
    private AvailableDestinations to;
    private LocalDate departureTime;
    private LocalDate arrivalTime;

    public Flight(AvailableDestinations from, AvailableDestinations to) {
        this.from = from;
        this.to = to;
    }

    public AvailableDestinations getFrom() {
        return from;
    }

    public AvailableDestinations getTo() {
        return to;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (from != flight.from) return false;
        return to == flight.to;
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }
}
