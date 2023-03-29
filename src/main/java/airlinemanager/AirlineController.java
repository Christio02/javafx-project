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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AirlineController {

    Flight flight;
    // WriteBookingToFile file;

    @FXML Button flightView;
    @FXML ListView<Flight> listOfFlights;


    @FXML
    public void initialize() {
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
        // this.file.addFlight(chosen);

        // this.file.writeToFile("testbooking1.txt");

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
                downloadAlert.setHeaderText("Download flight");
                downloadAlert.setContentText("Do you want to download the booking?");

                ButtonType downloadButton = new ButtonType("Download");
                ButtonType noDownloadButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
                downloadAlert.getButtonTypes().setAll(downloadButton, noDownloadButton);

                Optional<ButtonType> result2 = downloadAlert.showAndWait();

                if (result2.isPresent() && result2.get() == downloadButton) {
                    WriteBookingToFile file = new WriteBookingToFile();
                    file.addFlight(chosen);
                    file.writeToFile("booking.txt");

                }
            }
        }

    }
}



