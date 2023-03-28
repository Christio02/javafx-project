package airlinemanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AirlineController {

    Flight flight;
    WriteBookingToFile file;

    @FXML
    Button flightView;
    @FXML
    ListView<Flight> listOfFlights;

    @FXML
    public void initialize() {

        this.file = new WriteBookingToFile();
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());

        // sorts time based on earliest to late

        Collections.sort(flights);

        listOfFlights.getItems().addAll(flights);

        // makes sure that user

    }

    @FXML
    public void bookFlight() {
        List<Flight> chosen = listOfFlights.getSelectionModel().getSelectedItems(); // gets selected flight
        this.file.addFlight(chosen);

        this.file.writeToFile("testbooking1.txt");

    }

}
