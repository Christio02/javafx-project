package airlinemanager;

// import statements
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import airlinemanager.FlightStored;
import util.FlightAlreadyBookedException;
import util.FlightNotFoundException;

/* Description:
 * This class extends the FlightStored class and is responsible for performing different calculations on flight data.
 * It does not actually create the flight information itself, but inherits it from the FlightStored class.
 * Futhermore, it implements the interface Comparable<T> for sorting the flight data, using the time fields in the objects
 */


public class Flight extends FlightStored implements Comparable<Flight> {

    // Fields 

    /*
     * used for booking and writing to file
     */

    private WriteBookingToFile file; 

    private int seats;

    
    // Constructor:

     /*
        * initializes a new Flight object, which is inherited from the super class
        * Also creates a file object, for being used in other methods
    */ 

    public Flight() { 
        this.file = new WriteBookingToFile();
        this.destination = super.getDestination();
        this.start = super.getStart();
        this.time = super.generateRandomTime();
    }

    /*
     * This constructor is used in GetFlightFromList class, for retrieving flight object from list
    */
    // public Flight(String flightnum, String dest, String from, String time) {
    //     super.flightNumber = flightnum;
    //     super.destination = dest;
    //     super.start = from;
    //     super.time = time;
    // }

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
     * @return toString of flight object used for file writing/reading
     */
    public String toStringFile() {
        return super.toStringFormatted();
    }

    /*
     * CompareTo method implemented from Comparable<T> interface
     * It compares the current flight object with another flight object bases on departure times
     * Sorts from low to high
     * Uses hours first, and if hour is the same, it will use minutes and apply the same logic
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
     * Void method that booksFlight by storing it in a list
     * first checks if user is booking the same flight again
     * Then if that is true, it uses WriteBookingToFile class (file object) to add it to 
     * file object's list, then it can be written to file
     * @throws FlightAlreadyBookedException if this.flight is already booked
     */

    
    public void bookFlight() {
        if (!checkDuplicateBooking(this)) {
            throw new FlightAlreadyBookedException("Cannot book the same flight again!");
        }
        this.file.addFlight(this); // adds this flight to file class's list
    }


    /*
     * Void method that writes this flight object to file
     * First checks if the file object has the flight stored
     * then it writes to a defaulet "booking.txt" file
     * @throws FlightNotFoundException if this.flight booking does not exist yet
     */


    public void writeFlightToFile() {
        if (checkDuplicateBooking(this)) {
            throw new FlightNotFoundException("Flight not found, maybe its not been booked yet?");
        }
        this.file.writeToFile("booking.txt"); 
    }

    /*
     * Boolean method that checks if this flight is the same flight booked before
     * @return false if this.file list contains the same flight
     * @return true if this is not the case
     */

    private boolean checkDuplicateBooking(Flight bookedFlight) {
        if (this.file.flightsToDownload.contains(bookedFlight)) {
            return false;
        }

        return true;
    }

    /*
     * Getter for returning a flight in a list, for use in booking, since file object only takes in lists
     * @return a n arraylist of this flight
     */

    private List<Flight> getFlightsList() {
        List<Flight> flights = new ArrayList<>();
        flights.add(this);
        return flights;
    }

    /*
     * Tostring method that is called from the FlightStored class
     * Used for representing flight objects in app
     * @return toString of flight object
     */

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
    }

}
