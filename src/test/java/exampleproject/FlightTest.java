package exampleproject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import airlinemanager.Flight;

public class FlightTest {

    Flight flight;

    

    @Test
    @DisplayName("Checking for correct constructor")
    public void TestConstructor() {
        flight = new Flight();

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

        Pattern pattern2 = Pattern.compile("^\\d{2}.\\d{1}0$"); // this pattern cheks if there ate 2 digits, then ':', then 1 digit and then 0
        // e.g. 10:20 is correct, but 10:21, is not correct
        assertTrue(pattern2.matcher(time).matches(), "Time should be in this format!: 'xx:x0'");

        // test if start is not equal tod destination
        assertNotEquals(dest, start, "Start and end should not be the same!");
        
    }

    // set up random flight
    @BeforeEach
    public void setUp() {
        flight = new Flight();
    }

    @Test
    @DisplayName("Testing that all flight times are sorted correctly");
    public void testFlightTimeSort() {

        List<Flight> flights = new ArrayList<>();

        // should use Collections.sort and check that earlier times are before later times

        Collections.sort(flights);


    }

}
