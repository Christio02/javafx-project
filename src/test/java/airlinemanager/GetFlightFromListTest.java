package airlinemanager;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.GetFlightObjectFromList;

public class GetFlightFromListTest {

    private Flight flight, flight2;

    private List<Flight> list;

    @BeforeEach
    public void setUp() {
        flight = new Flight();
        flight2 = new Flight();
        list = new ArrayList<>();
        list.add(flight);
        
    }

    @Test
    @DisplayName("Testing constructor that list is correct")
    public void testConstructor() {

        GetFlightObjectFromList object = new GetFlightObjectFromList(list);

        assertEquals(list, object.getList());

    }
    
}
