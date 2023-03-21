package airlinemanager;

public class Flight {
    private String destination;

    private String start;
    private String airline;
    private String time;
    private String flightNumber;

    public Flight(String destination, String start, String time, String flightNumber) {
        this.destination = destination;
        this.start = start;
        this.time = time;
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

    public void setFlightNumber(String flightnumber) {
        if (flightnumber.isEmpty()) {
            throw new IllegalArgumentException("Flightnumber cannot be blank!");
        }
        if (flightnumber.length() > 6) {
            throw new IllegalArgumentException("Cannot have a flightnumber longer than 6!");
        }
        for (int i = 0; i < flightnumber.length(); i++) {
            Character c = flightnumber.charAt(i);
            String firstPart = flightnumber.substring(0, 2);
            String lastPart = flightnumber.substring(2, flightnumber.length());
            for (char d : firstPart.toCharArray()) {
                if (Character.isDigit(d)) {
                    throw new IllegalArgumentException("Cannot have number in first part of flightnumber!");
                }
            }
            if (firstPart.contan)

            for (char e : lastPart.toCharArray()) {
                if (Character.isAlphabetic(e)) {
                    throw new IllegalArgumentException("Last part of flightnumber must be numbers!");
                }
                
            }
        }

        this.flightNumber = flightnumber;
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
        Flight f1 = new Flight("Oslo", "Trondheim", "11.20", "Norwegian");

        System.out.println(f1);

    }
}
