package util;

import java.util.ArrayList;
import java.util.List;

import airlinemanager.Flight;

public class GetFlightObjectFromList {
    private Flight flight;

    private List<Flight> list2;

    public GetFlightObjectFromList(List<Flight> listofFlights) {
        this.list2 = listofFlights;
    }


    public Flight flightFromList() {
        if (this.list2.isEmpty()) {
            throw new FlightNotFoundException("Could not find flight from list!");
        }



        Flight flightFound = list2.get(0);
        return flightFound;



    }



    public static void main(String[] args) {
        List<Flight> list = new ArrayList<>();

        


        list.add(new Flight());
        GetFlightObjectFromList list2 = new GetFlightObjectFromList(list);

        System.out.println(list2.flightFromList());

        


    }

    



    
}
