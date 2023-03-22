package airlinemanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Flight extends FlightStored implements Comparable<Flight> {
    private String destination;

    private String start;
    private String time;
    private String flightNumber;

    public Flight(String destination, String start, String time, String flightNumber) {
        super(destination, start, time, flightNumber);
    }

    public String getDestination() {
        return this.destination;
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

    private int timeStringToInt() {
        int time = Integer.parseInt(this.time);
        return time;
    }
    

    @Override
    public int compareTo(Flight arg0) {
        if (this.timeStringToInt() > arg0.timeStringToInt()) {
            return 1;

        } else if (this.timeStringToInt() < arg0.timeStringToInt()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        List<Flight> flights = new ArrayList<>();
       
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));
        flights.add(new Flight(null, null, null, "OY"));

        for (Flight flight : flights) {
            flight.timeStringToInt();
            
        }

        System.out.println(flights);
        Collections.sort(flights);

        // System.out.println(flights);
       


        
    }

    

    

   
}
