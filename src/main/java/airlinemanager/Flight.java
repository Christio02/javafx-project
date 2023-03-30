package airlinemanager;

// import statements
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* Description:
 * This class extends the FlightStored class and is responsible for performing different calculations on flight data.
 * It does not actually create the flight information itself, but inherits it from the FlightStored class.
 * Futhermore, it implements the interface Comparable<T> for sorting the flight data, using the time fields in the objects
 */


public class Flight extends FlightStored implements Comparable<Flight> {

    // Fields 

    private WriteBookingToFile file; // used for booking and writing to file

    private Flight flight; 

    private int seats;

    
    // Constructors: 

    

    public Flight() { 
        /*
        * initializes a new Flight object, which is inherited from the super class
        * Also creates a file object, for being used in other methods
         */ 
        
        this.file = new WriteBookingToFile();
        
        this.destination = super.getDestination();
        this.start = super.getStart();
        this.time = super.generateRandomTime();

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



    public String toStringFile() {
        return super.toStringFormatted();
    }

    @Override
    public int compareTo(Flight otherFlight) {

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

    public int getHours() {

        int hours = Integer.parseInt(this.getTime().split(":")[0]);

        return hours;
    }

    
    public void bookFlight() {
        if (!checkDuplicateBooking(this)) {
            throw new IllegalStateException("Cannot book the same flight again!");
        }
        this.file.addFlight(this.getFlights()); // adds this flight to file class's list
    }

    public void writeFlightToFile() {
        if (this.file.flightsToDownload.contains(this.flight)) {
            this.file.writeToFile("testFile.txt");
        }
       
    }

    private boolean checkDuplicateBooking(Flight flight) {
        if (this.equals(flight)) {
            return false;
        }

        return true;
    }

    private List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(this);
        return flights;
    }

    @Override
    public String toString() {
        return super.toString();

    }

    public static void main(String[] args) {

        WriteBookingToFile file = new WriteBookingToFile();

        Flight f1 = new Flight();
        Flight f2 = new Flight();
        Flight f3 = new Flight();
        Flight f4 = new Flight();
        Flight f5 = new Flight();

        List<Flight> flights = new ArrayList<>();

        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        flights.add(f5);

        

        
        System.out.println(f1.checkDuplicateBooking(f5));


    }

}
