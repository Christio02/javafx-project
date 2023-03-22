package airlinemanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Flight extends FlightStored {
    // private String destination;

    // private String start;
    // private String time;
    // private String flightNumber;

    private FlightStored flightStored;

    public Flight() {
        flightStored = new FlightStored();
        this.flightNumber = setFlightNumber();
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

        List<Flight> flights = new ArrayList<>();
       
       


        
    }

    

    

   
}
