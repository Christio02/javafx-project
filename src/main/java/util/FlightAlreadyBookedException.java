package util;

/**
 * This is an excpetion class that extends the RuntimeException class
 * Its used to add a custom exception for circumstances when a flight is already booked, to prevent user
 * from booking the same flight twice
 */

public class FlightAlreadyBookedException extends RuntimeException {
    

    /**
     * The constructor which is responsible for using the runtimeexcpetion String errmessage class
     */
    public FlightAlreadyBookedException(String errMessage) {
        super(errMessage);
    }
}
