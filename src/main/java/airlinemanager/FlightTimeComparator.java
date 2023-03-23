package airlinemanager;

import java.time.LocalDateTime;
import java.util.Comparator;

public class FlightTimeComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight flight1, Flight flight2) {

        LocalDateTime dateTime1 = LocalDateTime.parse(flight1.getTime());
        LocalDateTime dateTime2 = LocalDateTime.parse(flight2.getTime());

        return dateTime1.compareTo(dateTime2);

      
    }
    
}
