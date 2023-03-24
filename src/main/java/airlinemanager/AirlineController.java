package airlinemanager;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AirlineController {

    flights flight;

    @FXML
    Button flightView;
    @FXML
    ListView<flights> listOfFlights;

    @FXML
    public void initialize() {
        List<flights> flights = new ArrayList<>();

        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());

        // sorts time based on earliest to late
        Collections.sort(flights);
        listOfFlights.getItems().addAll(flights);

    }

    @FXML
    public void showFlights() {

    }

}
