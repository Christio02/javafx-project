package airlinemanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Flight extends FlightStored {
    private String destination;

    private String start;
    private String time;    

    private FlightStored flightStored;

    public Flight() {
    
        this.destination = super.getDestination();
        this.start = super.getStart();
        this.time = super.getTime();
        
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

    

    @Override
    public String toString() {
        return "Flight [flightStored=" + flightStored + "]";
    }

    public static void main(String[] args) {

        Flight f1 = new Flight();
        System.out.println(f1);

        List<Flight> flights = new ArrayList<>();
       
       


        
    }

    

    

   
}
