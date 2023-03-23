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
    private String flightNumber;

    public Flight() {
        super();

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

    public String setFlightNumber() {

        Random random = new Random();

        String letterPart = "OY";
        int numberPart = random.nextInt(3000, 6000);

        String flightNumber = letterPart + String.valueOf(numberPart);

        return flightNumber;

    }
    
    public static void main(String[] args) {

        List<Flight> flights = new ArrayList<>();
       

        // System.out.println(flights);
       


        
    }

    

    

   
}
