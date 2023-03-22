package airlinemanager;

import java.util.Random;

public class FlightStored {

    protected String destination;
    protected String start;
    protected String time;

    public FlightStored() {
        this.destination = setStartOrDest();
        start = setStartOrDest();

        this.time = setTime();

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

    public String setTime() {
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

        FlightStored f1 = new FlightStored();

        System.out.println(f1);

    }

}
