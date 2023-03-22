package airlinemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flight extends FlightStored implements FlightInterface {
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

    @Override
    public String toString() {
        return "Flight" + "\n" +
                "flightNumber:" + flightNumber + "\n" +
                "destination:" + super.destination + "\n" +
                "start:" + super.start + "\n" +
                "airline:" + "Orwegian" + "\n" +
                "Departure:" + super.time + "\n";
    }

    public static void main(String[] args) {

        Flight f1 = new Flight();

        System.out.println(f1);

    }
}
