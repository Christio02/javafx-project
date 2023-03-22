package airlinemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Flight extends FlightStored implements FlightInterface   {
    private String destination;

    private String start;
    private String airline;
    private String time;
    private String flightNumber;

    public Flight(String destination, String start, String time, String flightNumber) {
        super(destination, start, time);
        
        setFlightNumber(flightNumber);
    }

    public String getDestination() {
        return this.destination;
    }

    public String getStart() {
        return this.start;
    }

    public String getAirline() {
        return this.airline;
    }

    public String getTime() {
        return this.time;
    }

    private String randomFlightnum(String flightNumber) {
        Random random = new Random();
        int lowerbound = 10000;
        int upperbound = 99999;
        int randomInt = random.nextInt(upperbound-lowerbound) + lowerbound; 

        String lastPart = flightNumber.substring(2, flightNumber.length());
        String intToString = Integer.toString(randomInt);

        lastPart = intToString;
        return lastPart;

    }

    @Override
    public void setFlightNumber(String flightnumber) {

        if (flightnumber.isEmpty()) {
            throw new IllegalArgumentException("Flightnumber cannot be blank!");
        }
        if (flightnumber.length() > 7) {
            throw new IllegalArgumentException("Cannot have a flightnumber longer than 6!");
        }
    
        String firstPart = flightnumber.substring(0, 2);
        String lastPart = randomFlightnum(flightnumber);
        for (char d : firstPart.toCharArray()) {
            if (Character.isDigit(d)) {
                throw new IllegalArgumentException("Cannot have number in first part of flightnumber!");
            }
        }
        if (!firstPart.contains("OY")) {
            throw new IllegalArgumentException("First part of flightnumber must contain 'DY'");
        }

        for (char e : lastPart.toCharArray()) {
            if (Character.isAlphabetic(e)) {
                throw new IllegalArgumentException("Last part of flightnumber must be numbers!");
            }
            
        }

        this.flightNumber = firstPart + lastPart;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                "destination='" + destination + '\'' +
                ", start='" + start + '\'' +
                ", airline='" + airline + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


    public static void main(String[] args) {

        Flight f1 = new Flight("Trondheim", "Oslo", "10.30", "OY34562");

        System.out.println(f1);
       


        
    }
}
