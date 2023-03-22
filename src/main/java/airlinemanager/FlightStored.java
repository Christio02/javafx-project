package airlinemanager;

import java.util.Random;

public class FlightStored {

    protected String destination;
    protected String start;
    protected String time;

    public FlightStored(String destination, String start, String time) {
        this.destination = setStartOrDest();
        this.start = setStartOrDest();

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

        int lowerbound = 0;
        int upperbound = 2459;

        int randomTime = random.nextInt(upperbound - lowerbound + 1) + lowerbound;

        String intTimeToString = String.format("%04d", randomTime);

        return intTimeToString;
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
