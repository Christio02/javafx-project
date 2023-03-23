package exampleproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import airlinemanager.Flight;
import airlinemanager.FlightStored;

public class FlightTest {
  

    @Test
    @DisplayName("Checking for correct constructor")
    public void TestConstructor() {
        Flight flight = new Flight();
        assertNotEquals(flight.getStart(), flight.getDestination(), "Start and destination should not be the same!");
        
        assertEquals("OY", flight.getFlightNumber().substring(0, 2), "Flightnumber letters should be 'OY'!");
        
        



    }

}
