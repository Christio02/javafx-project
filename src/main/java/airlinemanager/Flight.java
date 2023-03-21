package airlinemanager;

public class Flight {
    private String destination;

    private String start;
    private String airline;
    private String time;
    private String flightNumber;

    public Flight(String destination, String start, String airline, String time, String flightNumber) {
        this.destination = destination;
        this.start = start;
        this.airline = airline;
        this.time = time;
        this.flightNumber = flightNumber;
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
        for (int i = 0; i < flightnumber.length(); i++) {
            Character c = flightnumber.charAt(i);
            String firstPart = flightnumber.substring(0, 4);
        }
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
        Flight f1 = new Flight("Oslo", "Trondheim", "SAS", "11.20", "SK23891");

        System.out.println(f1);


    }
}
