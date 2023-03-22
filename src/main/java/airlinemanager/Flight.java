package airlinemanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Flight extends FlightStored implements Iterable<Flight> {
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

    public static void main(String[] args) {

        Flight f1 = new Flight(null, null, null, "OY");

        System.out.println(f1);
       


        
    }

    @Override
    public Iterator<Flight> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
