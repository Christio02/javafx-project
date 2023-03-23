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

        flightStored = new FlightStored();
    
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

    public String getFlightNumber() {
        return this.flightNumber;
    }

    

    @Override
    public String toString() {
        return "Flight [" + flightStored + "]";
    }

    public static void main(String[] args) {

        Flight f1 = new Flight();
        System.out.println(f1);

        System.out.println(f1.getFlightNumber().substring(2, f1.getFlightNumber().length()));

        for (int i = 0; i < f1.getFlightNumber().substring(2, f1.getFlightNumber().length()).length(); i++) {
            Character c = f1.getFlightNumber().charAt(i);

            if (Character.isDigit(c)) {
                System.out.println("Substring contains only numbers");
            }

        }
       
       


        
    }

    

    

   
}
