package util;

import java.util.ArrayList;
import java.util.List;

import airlinemanager.Flight;

/*
 * This class is responsible for retrieving a flight object from a list of flight objects.
 * The class has a constructor that takes a list of flight objects as a parameter and a method 
 * that returns the flight object from the list. 
 */

public class GetFlightObjectFromList {
    // Fields
    private Flight flight;

    private List<Flight> list2; // list
    // Constructor:

    /*
     * Constructs a new instance of the GetFlightObjectFromList class with the specified 
     * list of flight objects.
     * 
     * @param listofFlights a list of flight objects from which to retrieve a flight
     */

    public GetFlightObjectFromList(List<Flight> listofFlights) {
        this.list2 = listofFlights;
    }

    /*
     * This method returns a flight object from the list set in the constructor
     * It first checks if the list is empty, if its not it will use list.get(0) method, there will always be only one flight 
     * object in the list, hence (0).
     * @return Flight object from the list
     * @throws FlightNotFoundException if the list is empty
     */
    public Flight flightFromList() {
        if (this.list2.isEmpty()) {
            throw new FlightNotFoundException("Could not find flight from list!");
        }
        Flight flightFound = list2.get(0);
        return flightFound;
    }

    /*
     * Returns a string representation of the flight object from the list.
     * 
     * @return a formatted string representation of the flight object from the list
     */

    @Override
    public String toString() {
        return this.list2.get(0).toStringFormatted();
    }

    /*
     * This is a getter for the list, used in the Junit test
     * @return list of flight object
     */
    public List<Flight> getList() {
        return this.list2;
    }



    public static void main(String[] args) {
        List<Flight> list = new ArrayList<>();

        


        list.add(new Flight());
        GetFlightObjectFromList list2 = new GetFlightObjectFromList(list);

        System.out.println(list2);

        


    }

    



    
}
