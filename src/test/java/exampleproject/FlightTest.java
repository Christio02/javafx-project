package exampleproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import airlinemanager.Flight;

public class FlightTest {
  

    @Test
    @DisplayName("Checking for correct constructor")
    public void TestConstructor() {
        Flight flight = new Flight("Oslo", "Trondheim", "SAS", "13.10", "SK2939");

        

    }

}
