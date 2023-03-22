package airlinemanager;

import java.util.Random;

public class FlightStored {

    protected String start;
    protected String destination;
    protected String time;
    protected String flightNumber;

    public FlightStored(String start, String destination, String time, String flightNumber) {
        this.start = setStartOrDest();
        this.destination = setStartOrDest();
        this.setTime();
        this.setFlightNumber(flightNumber);
        
    }


    public String setStartOrDest() {
        Random random = new Random();
        String[] locations = { "Oslo", "Trondheim", "Bergen", "Stavanger", "Kristiansand", "Tromsø",
        "Bodø", "Malaga", "London", "København", "Stockholm", "Paris", "Barcelona"
        };

        int index = random.nextInt(locations.length);
        String location = locations[index];

        return location;
    }

    public void setTime() {
        this.time = generateRandomTime();
    
    }

    private String generateRandomTime() {

        Random random = new Random();

        int lowerBoundHour = 0;
        int upperBoundHour= 23;

        int lowerBoundMinutes = 0;
        int upperBoundMinutes = 5;

        int randomTimeHour = random.nextInt(upperBoundHour - lowerBoundHour + 1) + lowerBoundHour;
        int randomTimeMinutes = random.nextInt(upperBoundMinutes - lowerBoundMinutes + 1) * 10 + lowerBoundMinutes;

        String intHour = String.format("%02d", randomTimeHour);
        String intMin = String.format("%02d", randomTimeMinutes);

        String finString = intHour + ":" + intMin;

        return finString;

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

    public String getTime() {
        return this.time;
    }
    public String getStart() {
        return this.start;
    }
    public String getDestination() {
        return this.destination;
    }


    @Override
    public String toString() {
        return "{" +
            " destination='" + getDestination() + "'" +
            ", start='" + getStart() + "'" +
            ", time='" + getTime() + "'" +
            "}";
    }


    public static void main(String[] args) {

        FlightStored f1 = new FlightStored(null, null, null);

        System.out.println(f1);
        
    }

    

    
}
