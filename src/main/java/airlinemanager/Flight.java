package airlinemanager;



public class Flight extends FlightStored {
    private String destination;

    private String start;
    private String time;    

    private int seats;

    private FlightStored flightStored;

    public Flight() {

        flightStored = new FlightStored();
    
        this.destination = super.getDestination();
        this.start = super.getStart();
        this.time = super.getTime();
        
    }

    public String getDestination() {
        return this.destination;
    }

    public int getSeats() {
        return this.seats;
    }

    public String getStart() {
        return this.start;
    }

    public String getTime() {
        return this.time;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    

    @Override
    public String toString() {
        return "Flight [" + flightStored + "]";
    }

    public static void main(String[] args) {

        Flight f1 = new Flight();
        System.out.println(f1);

       
       


        
    }

    

    

   
}
