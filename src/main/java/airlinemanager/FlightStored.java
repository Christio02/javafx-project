package airlinemanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class flightStored implements Comparable<flightStored> {

    protected String start;
    protected String destination;
    protected String flightNumber;
    protected String time;
    protected boolean booked;

    public flightStored() {
        this.destination = setStartOrDest();
        this.start = setStartOrDest();
        flightNumber = setFlightNumber();
        time = this.generateRandomTime();
        this.booked = false;

    }

    public String setStartOrDest() {
        Random random = new Random();
        String[] locations = { "Oslo", "Trondheim", "Bergen", "Stavanger", "Kristiansand", "Tromsø",
                "Bodø", "Malaga", "London", "København", "Stockholm", "Paris", "Barcelona"
        };

        int index; // initzialize index

        do {
            index = random.nextInt(locations.length); // do, set index to a random index in the array

        } while (locations[index].equals(destination)); // continues until unique dest and start is selected

        String location = locations[index];

        return location;

    }

    public String getTime() {
        return this.time;
    }

    public int getHours() {

        int hours = Integer.parseInt(this.getTime().split(":")[0]);

        return hours;
    }

    public int getMinutes() {

        int minutes = Integer.parseInt(this.getTime().split(":")[1]);

        return minutes;
    }

    @Override
    public int compareTo(flightStored otherFlight) {

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

    public String generateRandomTime() {

        Random random = new Random();

        int lowerBoundHour = 5;
        int upperBoundHour = 23;

        int lowerBoundMinutes = 0;
        int upperBoundMinutes = 5;

        int randomTimeHour = random.nextInt(upperBoundHour - lowerBoundHour + 1) + lowerBoundHour;
        int randomTimeMinutes = random.nextInt(upperBoundMinutes - lowerBoundMinutes + 1) * 10 + lowerBoundMinutes;

        String intHour = String.format("%02d", randomTimeHour);
        String intMin = String.format("%02d", randomTimeMinutes);

        String finString = intHour + ":" + intMin;

        return finString;

    }

    private String setFlightNumber() {

        Random random = new Random();

        String letterPart = "OY";
        int numberPart = random.nextInt(3000, 6000);

        String flightNumber = letterPart + String.valueOf(numberPart);

        return flightNumber;

    }

    public String getStart() {
        return this.start;
    }

    public String getDestination() {
        return this.destination;
    }

    @Override
    public String toString() {
        return "FlightStored [Departure= " + this.time + " start=" + start + ", destination=" + destination
                + ", flightNumber="
                + flightNumber;
    }

    public static void main(String[] args) {

        flightStored f1 = new flightStored();
        flightStored f2 = new flightStored();
        flightStored f3 = new flightStored();
        flightStored f4 = new flightStored();
        flightStored f5 = new flightStored();

        List<flightStored> flights = new ArrayList<>();

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
