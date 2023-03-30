package util;

public class FlightAlreadyBookedException extends RuntimeException {
    

    public FlightAlreadyBookedException(String errMessage) {
        super(errMessage);
    }
}
