package airlinemanager;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class FlightTimeComparator implements Comparator<Flight> {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH.mm"); // specifies custom format for parsing the time string

    @Override
    public int compare(Flight flight1, Flight flight2) {

        LocalTime time1 = LocalTime.parse(flight1.getTime(), TIME_FORMATTER); // formats each getTime
        LocalTime time2 = LocalTime.parse(flight2.getTime(), TIME_FORMATTER);

        return time1.compareTo(time2); // compares

      
    }
    
}
