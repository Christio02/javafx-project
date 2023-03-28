package airlinemanager;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class FlightTimeComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight f1, Flight f2) {
        LocalTime time1 = LocalTime.parse(f1.getTime(), DateTimeFormatter.ofPattern("HH.mm"));
        LocalTime time2 = LocalTime.parse(f2.getTime(), DateTimeFormatter.ofPattern("HH.mm"));
        return time1.compareTo(time2);
    }
    
}
