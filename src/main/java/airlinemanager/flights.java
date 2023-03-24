package airlinemanager;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class flights extends flightStored {
    private String destination;
    private String start;
    private int seats;
    private ArrayList<flightStored> flights;

    public flights() {

        this.flights = new ArrayList<>();
        this.destination = super.getDestination();
        this.start = super.getStart();

    }

    public String getDestination() {
        return this.destination;
    }

    public void bookFlight(flightStored flight) {
        flight.booked = true;
    }

    public void unBookFlight(flightStored flight) {
        flight.booked = false;
    };

    public int getSeats() {
        return this.seats;
    }

    public String getStart() {
        return this.start;
    }

    public String getTime() {
        return this.time;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    @Override
    public String toString() {
        return "Flight [" + flightStored + "]";

    }

    public static void main(String[] args) {

    }

}
