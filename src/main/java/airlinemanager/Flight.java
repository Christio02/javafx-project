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

    /*
     * This methods is a getter for destination
     */

    public String getDestination() {
        return this.destination;
    }

    /*
     * Getter for seats
     */

    public int getSeats() {
        return this.seats;
    }

    /*
     * Getter for start location
    */

    public String getStart() {
        return this.start;
    }

    /*
     * Getter for time
     */

    public String getTime() {
        return this.time;
    }

    /*
     * Getter for flightnumber
     */

    public String getFlightNumber() {
        return this.flightNumber;
    }

    /*
     * This is a toString method for file usage
     * It makes it easier to read from file
     * It uses the FlightStored toStringFormatted() method
     */
    public String toStringFile() {
        return super.toStringFormatted();
    }

    /*
     * CompareTo method implemented from Comparable<T> interface
     * It compares the current flight object with another flight object bases on departure times
     * Sorts from low to high
     * @param otherflight: other flight object that THIS will be compared to
     * @return 1: if this flight dep time is larger than otherFlight
     * @return -1: if this flight dep time is lower than otherFlight
     */

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

    /*
     * Getter for returning hours to be used in compareTo method
     * Parses getTime (10:20) -> 10 to int
     * @return integer of hours
     */

    public int getHours() {

        int hours = Integer.parseInt(this.getTime().split(":")[0]);

        return hours;
    }


    /*
     * Void method that booksFlight by storing it in a list
     * first checks if user is booking the same flight again
     * Then if that is true, it uses WriteBookingToFile class (file object) to add it to 
     * file object's list, then it can be written to file
     * @throws IllegalStateException if this.flight is already booked
     */

    
    public void bookFlight() {
        if (!checkDuplicateBooking(this)) {
            throw new IllegalStateException("Cannot book the same flight again!");
        }
        this.file.addFlight(this.getFlights()); // adds this flight to file class's list
    }


    /*
     * Void method that writes this flight object to file
     * First checks if the file object has the flight stored
     * then it writes to a defaulet "booking.txt" file
     * @throws IllegalStateException if this.flight booking does not exist yet
     */


    public void writeFlightToFile() {
        if (checkDuplicateBooking(this)) {
            throw new IllegalStateException("The booking you're trying to download does not exist!");
        }
        this.file.writeToFile("booking.txt"); 
    }

    /*
     * Boolean method that checks if this flight is the same flight booked before
     * @return false if this 
     */

    private boolean checkDuplicateBooking(Flight bookedFlight) {
        if (this.file.flightsToDownload.contains(bookedFlight)) {
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

        f1.bookFlight();
        f1.writeFlightToFile();

    }

}
