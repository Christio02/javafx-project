package airlinemanager;

// import statments
import util.FlightAlreadyBookedException;
import util.FlightNotFoundException;

/** Description:
 * This class extends the FlightStored class and is responsible for performing different calculations on flight data.
 * It does not actually create the flight information itself, but inherits it from the FlightStored class.
 * Futhermore, it implements the interface Comparable<T> for sorting the flight data, using the time fields in the objects
 */

public class Flight extends FlightStored implements Comparable<Flight> {

    // Fields

    /**
     * A boolean field responsible for throwing exceptions when needed
     * Protected because it needs to be accessed from controller
     */

    protected boolean isBooked;

    // Constructor:

    /**
     * initializes a new Flight object, which is inherited from the super class
     */

    public Flight() {
        this.destination = super.getDestination();
        this.start = super.getStart();
        this.time = super.getTime();
        isBooked = false;
      
    }

    /*
     * For jUNit testing
     */

    public Flight(String destination, String start, String time, String flightNumber, String date) {
        this.destination = destination;
        this.start = start;
        this.time = time;
        this.flightNumber = flightNumber;
        this.date = date;
    }

    /**
     * This methods is a getter for destination
     */

    public String getDestination() {
        return this.destination;
    }

    /**
     * Getter for start location
     */

    public String getStart() {
        return this.start;
    }

    /**
     * Getter for time
     */

    public String getTime() {
        return this.time;
    }

    /**
     * Getter for flightnumber
     */

    public String getFlightNumber() {
        return this.flightNumber;
    }

    /**
     * This is a toString method for file usage
     * It makes it easier to read from file
     * It uses the FlightStored toStringFormatted() method
     * 
     * @return toString of flight object used for file writing/reading
     */
    public String toStringFile() {
        return super.toStringFormatted();
    }

    /**
     * CompareTo method implemented from Comparable<T> interface
     * It compares the current flight object with another flight object bases on
     * departure times
     * Sorts from low to high
     * Uses hours first, and if hour is the same, it will use minutes and apply the
     * same logic
     * 
     * @param otherflight: other flight object that THIS will be compared to
     * 
     * @return 1: if this flight dep time is larger than otherFlight
     * 
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

    /**
     * Void method that booksFlight by storing it in a list
     * first checks if user is booking the same flight again
     * Then if that is false, it uses WriteBookingToFile class (file object) to add
     * it to
     * file object's list, then it can be written to file
     * @param tempFile file object from the WriteBookingToFile class
     * @throws FlightAlreadyBookedException if this.flight is already booked
     */

    public void bookFlight(WriteBookingToFile tempFile) {
        if (this.isBooked == true) {
            throw new FlightAlreadyBookedException("Cannot book the same flight again!");
        }
        tempFile.addFlight(this); // adds this flight to file class's list
        isBooked = true;
    }

    /**
     * This void method is called from the removebooking button, and removes
     * the flight object from the file's list
     * Essentially calls the file class' removeFlight method
     * @param tempFile file object from the WriteBookingToFile class
     * @throws FlightNotFoundException if the flight this method is called upon, is not in the list (E.g. not booked)
     */

    public void removeBooking(WriteBookingToFile tempFile) {
        if (!tempFile.flightsToDownload.contains(this)) {
            throw new FlightNotFoundException("There is no flight to cancel!");
        }

        tempFile.removeFlight(this);
        isBooked = false;
    }

    /**
     * Void method that writes this flight object to file
     * First checks if the file object has the flight stored
     * then it writes to a default "booking.txt" file, using the file object method
     * @param tempFile file object from the WriteBookingToFile class
     * @throws FlightNotFoundException if this.flight booking does not exist yet
     */


    public void writeFlightToFile(WriteBookingToFile tempFile) {
        // this.tempFlight = new GetFlightObjectFromList(this.file.getFlightsToDownload());
        if (this.isBooked == false) {
            throw new FlightNotFoundException("Flight found, maybe its not been booked yet?");
        }
        tempFile.writeToFile("booking.txt");

         
    }


    /**
     * This boolean method checks if the flight is booked
     * It does this by making sure that the file class' list is empty
     * @return true if empty
     * @return false otherwise
     */

    // private boolean checkIfBooked() {
    //     if (this.file.flightsToDownload.isEmpty()) {
    //         return true;
    //     }
    //     return false;
    // }

    
    /**
     * Tostring method that is called from the FlightStored class
     * Used for representing flight objects in app
     * 
     * @return toString of flight object
     */

    @Override
    public String toString() {
        return super.toString();

    }

    public static void main(String[] args) {

        WriteBookingToFile file = new WriteBookingToFile();

        Flight f1 = new Flight(); Flight f2 = new Flight(); Flight f3 = new Flight();
        f1.bookFlight(file); f2.bookFlight(file); f3.bookFlight(file);
        System.out.println(file.getFlightsToDownload());

        

        

    }

}
