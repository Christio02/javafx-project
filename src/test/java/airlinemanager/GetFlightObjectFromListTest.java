package airlinemanager;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.FlightNotFoundException;
import util.GetFlightObjectFromList;

public class GetFlightObjectFromListTest {

    private Flight flight;

    private List<Flight> list, list2;

    @BeforeEach
    public void setUp() {
        flight = new Flight();
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list.add(flight);
        
    }

    @Test
    @DisplayName("Testing constructor that list is correct")
    public void testConstructor() {

        GetFlightObjectFromList object = new GetFlightObjectFromList(list);

        assertEquals(list, object.getList());

    }

    @Test
    @DisplayName("Testing that the flightFromList method works as expected")
    public void testFlightFromList() {
        GetFlightObjectFromList object2 = new GetFlightObjectFromList(list2);
        GetFlightObjectFromList object3 = new GetFlightObjectFromList(list);
        
        assertThrows(FlightNotFoundException.class,
        () -> object2.flightFromList(), "FlightNotFoundExcpetion expected when list is empty!");

        assertEquals(this.flight, object3.flightFromList(), "Wrong flight returned or flight returned is not the correct object!");
        
    }
    
}
