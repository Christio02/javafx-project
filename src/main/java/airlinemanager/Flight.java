package airlinemanager;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Flight extends FlightStored implements Comparable<Flight> {
    private String destination;

    private String start;
    
    private String time;

    private int seats;

    private FlightStored flightStored;

    private List<Flight> booking = new ArrayList<>();

    public Flight() {
        flightStored = new FlightStored();
        
        this.destination = super.getDestination();
        this.start = super.getStart();
        this.time = super.generateRandomTime();

    }

    public String getDestination() {
        return this.destination;
    }

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
    public int compareTo(Flight otherFlight) {

        if (this.getHours() > otherFlight.getHours()) {
            return 1;
        } else if (this.getHours() < otherFlight.getHours()) {
            return -1;
        }

        else if (this.getHours() == otherFlight.getHours()) {
            if (this.getMinutes() > otherFlight.getMinutes()) {
                return 1;
            } else {
                return -1;
            }

        }

        return 1;

    }

    public void bookFlight(Flight name) {
        this.booking.add(name);
    }

    @Override
    public String toString() {
        return flightStored.toString();

    }

    public static void main(String[] args) {

        Flight f1 = new Flight();
        Flight f2 = new Flight();
        Flight f3 = new Flight();
        Flight f4 = new Flight();
        Flight f5 = new Flight();

        List<Flight> flights = new ArrayList<>();

        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        flights.add(f5);

        System.out.println(flights);

        System.out.println('\n');
        Collections.sort(flights);

        System.out.println(flights);

    }

}
