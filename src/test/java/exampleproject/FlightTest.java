package exampleproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import airlinemanager.Flight;

public class FlightTest {
  

    @Test
    @DisplayName("Checking for correct constructor")
    public void TestConstructor() {
        Flight flight = new Flight();
        assertNotEquals(flight.getStart(), flight.getDestination(), "Start and destination should not be the same!");



    }

}
