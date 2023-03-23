package airlinemanager;

import java.util.Random;

public class FlightStored {

    protected String start;
    protected String destination;
    protected String time;
    protected String flightNumber;

    public FlightStored() {
        this.destination = setStartOrDest();
        this.start = setStartOrDest();
        flightNumber = setFlightNumber();
        setTime();

    }

    public String setStartOrDest() {
        Random random = new Random();
        String[] locations = { "Oslo", "Trondheim", "Bergen", "Stavanger", "Kristiansand", "Tromsø",
                "Bodø", "Malaga", "London", "København", "Stockholm", "Paris", "Barcelona"
        };

        int index;
        
        do {
            index = random.nextInt(locations.length);

        } while (locations[index].equals(destination));

        String location = locations[index];

        return location;

    }

    public void setTime() {
        this.time = generateRandomTime();
    
    }

    private String generateRandomTime() {

        Random random = new Random();

        int lowerBoundHour = 0;
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
        return "FlightStored [start=" + start + ", destination=" + destination + ", time=" + time + ", flightNumber="
                + flightNumber + "]";
    }

    public static void main(String[] args) {

        FlightStored f1 = new FlightStored();

        System.out.println(f1);

    }

}
