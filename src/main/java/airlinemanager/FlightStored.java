package airlinemanager;

import java.util.Random;

public class FlightStored {

    protected String start;
    protected String destination;
    protected String flightNumber;
    protected String time;

    public FlightStored() {
        this.destination = setStartOrDest();
        this.start = setStartOrDest();
        flightNumber = setFlightNumber();
        this.time = generateRandomTime();

    }

    private String setStartOrDest() {
        Random random = new Random();
        String[] locations = { "Oslo", "Trondheim", "Bergen", "Stavanger", "Kristiansand", "Tromsø",
                "Bodø", "Malaga", "London", "København", "Stockholm", "Paris", "Barcelona"
        };

        String location1, location2;

        location1 = locations[random.nextInt(locations.length)];
        do {
            location2 = locations[random.nextInt(locations.length)];
        } while (location2.equals(location1));

        start = location1;
        destination = location2;

        return location1;

    }

    protected String generateRandomTime() {

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

    public String getTime() {
        return this.time;
    }

     /*
     * Getter for returning hours to be used in compareTo method
     * Parses getTime (10:20) -> 10 to int
     * @return integer of hours
     */

    public int getHours() {

        int hours = Integer.parseInt(this.getTime().split(":")[0]);

        return hours;
    }

    public int getMinutes() {

        int minutes = Integer.parseInt(this.getTime().split(":")[1]);

        return minutes;
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

    // for app
    @Override
    public String toString() {
       return "Flight: " + flightNumber + "\n" +
            "From: " + start + "\n" +
            "To: " + destination + "\n" +
            "Departure Time: " + getTime();
    }

    // for file writing
    public String toStringFormatted() {
        return "Flight: " + flightNumber + ", From: " + start + ", To: " + destination + ", Departure Time: " + getTime();
    }


    public static void main(String[] args) {

        FlightStored f1 = new FlightStored();

        System.out.println(f1);

    }

}
