package airlinemanager;

import static org.junit.jupiter.api.Assertions.*;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import airlinemanager.Flight;
import airlinemanager.FlightStored;
import util.FlightAlreadyBookedException;

public class FlightTest {

    private Flight flight;
    private WriteBookingToFile fileList;

    // set up random flight
    @BeforeEach
    public void setUp() {
        flight = new Flight();
        fileList = new WriteBookingToFile();
    }


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

        Pattern pattern2 = Pattern.compile("^\\d{2}.\\d{1}0$"); // this pattern cheks if there aree 2 digits, then ':',
                                                                // then 1 digit and then 0
        // e.g. 10:20 is correct, but 10:21, is not correct
        assertTrue(pattern2.matcher(time).matches(), "Time should be in this format!: 'xx:x0'");

        // test if start is not equal tod destination
        assertNotEquals(dest, start, "Start and end should not be the same!");

    }

    

    @Test
    @DisplayName("Test that all flight times are sorted correctly")
    public void testFlightTimeSort() {

        List<Flight> flights = new ArrayList<>(); // original list
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());

        // should use Collections.sort and check that earlier times are before later
        // times
        Collections.sort(flights);

        Flight prev = null; // keeps track of previous flights in list, is null because there are no
                            // previous flights for 1.st iteration
        for (Flight flight : flights) {
            if (prev != null) { // if flights not null

                if (flight.getHours() == prev.getHours()) { // if hours time is the same
                    assertTrue(flight.getMinutes() >= prev.getMinutes()); // then check minutes
                }
                // check if this flight hours is larger than previous flight
                assertTrue(flight.getHours() >= prev.getHours(),
                        "Flights are not sorted correctly, should be sorted in ascending order!");
            }
            prev = flight; // so that after each iteration, prev is set to that flight
        }
    }

    @Test
    @DisplayName("Testing that the flight is being correcly added to writer list, during booking")
    public void testBookFlightMethodAddsFLight() {

        List<Flight> tempList = new ArrayList<>();
        tempList.add(flight);
        flight.bookFlight(fileList);

        assertEquals(tempList.get(0), fileList.getFlightsToDownload().get(0));

        assertDoesNotThrow(() -> flight.bookFlight(fileList), "The method should not throw when only one instance of flight is added to the booking!");

            
        assertThrows(FlightAlreadyBookedException.class, () -> flight.bookFlight(fileList), "The method should throw this exception when duplicate booking is detected!");
    }
        

    @Test
    @DisplayName("Testing that the flight booking is correctly removed from the writers list")
    public void testFlightIsCorreclyRemoved() {
        List<Flight> tempList = new ArrayList<>();
        flight.bookFlight(fileList);
        flight.removeBooking(fileList);
        assertEquals(tempList.isEmpty(), fileList.getFlightsToDownload().isEmpty());

    }

    
}
