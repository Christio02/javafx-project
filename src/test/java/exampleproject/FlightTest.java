package exampleproject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import airlinemanager.Flight;
import airlinemanager.FlightStored;

public class FlightTest {

  

    @Test
    @DisplayName("Checking for correct constructor")
    public void TestConstructor() {
        Flight flight = new Flight();

        String flightNumber = flight.getFlightNumber();

        String dest = flight.getDestination();
        String start = flight.getStart();

        String time = flight.getTime();

        assertNotEquals(flight.getStart(), flight.getDestination(), "Start and destination should not be the same!");
        
        assertEquals("OY", flightNumber.substring(0, 2), "Flightnumber letters should be 'OY'!");
        
        // checks if there are only numbers after 'OY'
        Pattern pattern = Pattern.compile("^OY\\d{4}$"); // using pattern, that implies 4 digits after 'OY'

        assertTrue(pattern.matcher(flightNumber).matches(), "FlightNumber should only contain numbers after 'OY'!");
              

        // time checker

        Pattern pattern2 = Pattern.compile("^\\d{2}:\\d{1}0$"); // this pattern cheks if there ate 2 digits, then ':', then 1 digit and then 0
        // e.g. 10:20 is correct, but 10:21, is not correct
        assertTrue(pattern2.matcher(time).matches(), "Time should be in this format!: 'xx:x0'");

        // test if start is not equal tod destination
        assertNotEquals(dest, start, "Start and end should not be the same!");
        
    }

}
