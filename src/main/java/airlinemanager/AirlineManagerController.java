package airlinemanager;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AirlineManagerController {

    @FXML
    Button flightView;
    @FXML
    ListView<flights> showFlights;

    @FXML
    public void initialize() {
        List<flights> flights = new ArrayList<>();
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());
        flights.add(new flights());

    }

}
