package airlinemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Flight extends FlightStored {
    private String destination;

    private String start;
    private String time;    

    private int seats;

    private FlightStored flightStored;

    public Flight() {

        flightStored = new FlightStored();
    
        this.destination = super.getDestination();
        this.start = super.getStart();
        this.time = super.getTime();
        
    }

    public Flight(String dest, String start, String time) {
        this.destination = dest;
        this.start = start;
        this.time = time;
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
    public String toString() {
        return "Flight [" + flightStored + "]";
    }

    public static void main(String[] args) {

        Flight f1 = new Flight();

        List<Flight> flights = new ArrayList<>();


        flights.add(f1); flights.add(new Flight()); flights.add(new Flight()); flights.add(new Flight());
        System.out.println(flights);

        System.out.println("\n\n");
        Collections.sort(flights, new FlightTimeComparator());

        System.out.println(flights);



       System.out.println("Sorted list: \n\n");

       flights.stream().map(s -> s.getTime()).forEach(System.out::println);

       
       


        
    }

    
    

    

   
}
