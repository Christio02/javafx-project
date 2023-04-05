package util;

/*
 * This is an excpetion class that extends the RuntimeException class
 * Its used to add a custom exception for circumstances when for example a flight is not initialized or does not exist
 */

public class FlightNotFoundException extends RuntimeException {
    /*
     * The constructor which is responsible for using the runtimeexcpetion String errmessage class
     */

    public FlightNotFoundException(String errMessage) {
        super(errMessage);

    }


    
}
