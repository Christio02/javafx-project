package airlinemanager;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AirlineController {

    private Flight flight;
    private WriteBookingToFile file;

    private boolean isBooked = false;

    @FXML
    private Button flightView;
    @FXML
    private ListView<Flight> listOfFlights;
    @FXML
    private Button getBooking;
    @FXML
    private Label readFileContent;

    @FXML
    public void initialize() {
        getBooking.setVisible(false);
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());

        // sorts time based on earliest to late

        Collections.sort(flights);

        listOfFlights.getItems().addAll(flights);
    
    

    }

    @FXML
    public void bookFlight() {
        List<Flight> chosen = listOfFlights.getSelectionModel().getSelectedItems(); // gets selected flight
        

        if (chosen.isEmpty()) {
            // Show error message if no flight is selected
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("No flight selected");
            errorAlert.setContentText("Please select a flight before booking.");
            errorAlert.showAndWait();

        } else {
            // Show confirmation dialog with flight information
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setHeaderText("Book Flight");
            confirmationAlert.setContentText("Are you sure you want to book the following flight(s)?\n\n" + chosen.toString());
            
            // Create buttons for the dialog
            ButtonType confirmButton = new ButtonType("Confirm");
            ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
            confirmationAlert.getButtonTypes().setAll(confirmButton, cancelButton);

            
            
            // Handle button actions
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == confirmButton) {
                
                Alert downloadAlert = new Alert(AlertType.CONFIRMATION);
                // need to somehow extract flight object from "chosen" list
                // this.flight.bookFlight();
                // System.out.println(flight);
                downloadAlert.setHeaderText("Download flight");
                downloadAlert.setContentText("Do you want to download the booking?");

                ButtonType downloadButton = new ButtonType("Download")  ;
                ButtonType noDownloadButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
                downloadAlert.getButtonTypes().setAll(downloadButton, noDownloadButton);

                Optional<ButtonType> result2 = downloadAlert.showAndWait();

                if (result2.isPresent() && result2.get() == downloadButton) {
                    file = new WriteBookingToFile();
                    // need to call bookFlight method or something
                    file.addFlight(chosen);
                    file.writeToFile("booking.txt");
                    getBooking.setVisible(true);
                    isBooked = true;
                    listOfFlights.getItems().removeAll(chosen);

                }
            }
        }

    }


    @FXML
    public void getBooking() {
        if (isBooked = true) {
            String flight = this.file.readFromFile("booking.txt");
            readFileContent.setText(flight);
            getBooking.setVisible(false);

            
        }
    }
}



