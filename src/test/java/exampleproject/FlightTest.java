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

        String time = flight.getTime();

        assertNotEquals(flight.getStart(), flight.getDestination(), "Start and destination should not be the same!");
        
        assertEquals("OY", flightNumber.substring(0, 2), "Flightnumber letters should be 'OY'!");
        
        // checks if there are only numbers after 'OY'
        Pattern pattern = Pattern.compile("^OY\\d{4}$"); // using pattern, that implies 4 digits after 'OY'

        assertTrue(pattern.matcher(flightNumber).matches());
              

        // time checker

        Pattern pattern2 = Pattern.compile("")
        
    }

}
