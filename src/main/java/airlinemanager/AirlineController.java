package airlinemanager;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import util.FlightAlreadyBookedException;
import util.FlightNotFoundException;
import util.GetFlightObjectFromList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * AirlineController is a JavaFX controller class responsible for handling user
 * interactions
 * with the airline booking application. It manages the booking process,
 * including selecting
 * flights and confirming bookings.
 *
 * The class contains methods for handling button clicks and updating the UI
 * components
 * such as the ListView of available flights and the booking confirmation
 * dialogs.
 *
 * The main methods in this class are:
 * - bookFlight(): Handles the flight booking process, including user
 * confirmation and displaying on the "your bookings" textField.
 * - download(): handles the downloading of the flight information.
 * - getBooking(): Displays the booking information for the user after a
 * successful booking.
 * - initialize(): Initializes the UI components and sets up the initial state
 * of the application.
 * -reset(): resets the listOfFlights view to have all the previous flights before filter on location was applied. 
 */

public class AirlineController {

    private Flight flight;

    
    List<Flight> flights = new ArrayList<>();
    List<Flight> filteredFlights = new ArrayList<>();

    private WriteBookingToFile fileBooking;

    @FXML
    private Button flightView;
    @FXML
    private ListView<Flight> listOfFlights;
    @FXML
    private Button getBooking;
    @FXML
    private TextArea readFileContent;
    @FXML
    private Button cancelBooking;
    @FXML 
    private Button bookBTN;
    @FXML
    private TextField searchbar;
    @FXML
    private Button searchbutton;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView<Flight> bookedFlights;

    @FXML
    public void initialize() {
        this.fileBooking = new WriteBookingToFile();
        getBooking.setVisible(false);
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());

        // sorts time based on earliest to late

        Collections.sort(flights);

        listOfFlights.getItems().addAll(flights);
        getBooking.setVisible(false);
        

    }

    @FXML
    public void bookFlight() {
        try {
            List<Flight> chosen = listOfFlights.getSelectionModel().getSelectedItems(); // gets selected flight
            GetFlightObjectFromList listTemp = new GetFlightObjectFromList(chosen);
            Flight tempFlight = listTemp.flightFromList();

            if (tempFlight.isBooked == true) {
                throw new FlightAlreadyBookedException("Cannot book the same flight again!");
            }
           
    
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
                confirmationAlert
                        .setContentText("Are you sure you want to book the following flight(s)?\n\n" + chosen.toString());
    
                // Create buttons for the dialog
                ButtonType confirmButton = new ButtonType("Confirm");
                ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
                confirmationAlert.getButtonTypes().setAll(confirmButton, cancelButton);
    
                // Handle button actions
                Optional<ButtonType> result = confirmationAlert.showAndWait(); // waits for user to click either buttons before resuming code
                if (result.isPresent() && result.get() == confirmButton) {
    
                    
    
                    tempFlight.bookFlight(this.fileBooking);
            
                    bookedFlights.getItems().add(tempFlight);
    
                    System.out.println("File list: " + this.fileBooking.flightsToDownload);
    
                }
            }
            
        } catch (FlightAlreadyBookedException e) {
            Alert duplicateBooking = new Alert(AlertType.ERROR);
            duplicateBooking.setHeaderText("Duplicate Booking detected!");
            duplicateBooking.setContentText("You cannot book the same flight twice!");
            duplicateBooking.showAndWait();
        }
       

    }

    @FXML
    public void searchForFlight() {
        try {
            if (searchbar.getText() == "") {
                throw new FlightNotFoundException("Cannot search for empty flight!");
            }
            String search = searchbar.getText();
            List<Flight> flights = listOfFlights.getItems();
            List<Flight> filteredFlights = new ArrayList<>();
    
            for (Flight flight : flights) {
                if (!(search.equals(flight.getDestination()) || search.equals(flight.getStart()))) {
                    filteredFlights.add(flight);
    
                }
            }
    
            System.out.println(filteredFlights);
            this.filteredFlights = filteredFlights;
            listOfFlights.getItems().removeAll(filteredFlights);
            searchbar.clear();
            
        } catch (FlightNotFoundException e) {
            Alert noFlightSearch = new Alert(AlertType.ERROR);
            noFlightSearch.setHeaderText("You cannot leave the searchbar empty!");
            noFlightSearch.setContentText("You must input text for destination before searching!");
            noFlightSearch.showAndWait();
        }
     
      
    }

    @FXML
    public void reset() {
        List<Flight> flights = this.filteredFlights;

        listOfFlights.getItems().addAll(flights);
    }

    /**
     * This FXML method is used when the user clicks the download button
     * The logic here is that a pop up appears to make sure the user acutally wants to download the flight
     * When the user clicks the confirm button, the method calss the 
     */

    @FXML
    public void download() {
        
        try {

            if (bookedFlights.getItems() == null) {
                throw new FlightNotFoundException("You have not yet booked fligh! Can therefore not download!");
            }
            GetFlightObjectFromList listTemp = new GetFlightObjectFromList(this.fileBooking.getFlightsToDownload());
            System.out.println(listTemp);

            Flight tempFlight = listTemp.flightFromList();

            System.out.println("\n");

            Alert downloadAlert = new Alert(AlertType.CONFIRMATION);
            downloadAlert.setHeaderText("Download flight");
            downloadAlert.setContentText("Do you want to download the booking?");

            ButtonType downloadButton = new ButtonType("Download");
            ButtonType noDownloadButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
            downloadAlert.getButtonTypes().setAll(noDownloadButton, downloadButton);

            Optional<ButtonType> result2 = downloadAlert.showAndWait();

            if (result2.isPresent() && result2.get() == downloadButton) {
                
            System.out.println("File list: " + this.fileBooking.getFlightsToDownload());
            tempFlight.writeFlightToFile(fileBooking);
            getBooking.setVisible(true);

            }  

        } catch (FlightNotFoundException e) {
            Alert noFlight = new Alert(AlertType.ERROR);
            noFlight.setHeaderText("No flight booked!");
            noFlight.setContentText("There is no flight booked, you cannot download a booking that does not exist!");
            noFlight.showAndWait();
    }

        
    }


    @FXML
    public void getBooking() {
            String flight = this.fileBooking.readFromFile("booking.txt");
            readFileContent.setText(flight);
            getBooking.setVisible(false);
    }

    /**
     * 
     * This method is used to remove a booked flight from the booking list.
     * 
     * It first displays a confirmation dialog box to make sure that the user wants
     * to cancel the flight.
     * 
     * If the user clicks "Cancel booking", the flight is removed from the booking
     * list.
     * 
     * If the flight is not found, an error message is displayed.
     * 
     * @throws FlightNotFoundException if the flight is not found in the booking
     * list.
     */
    @FXML
    public void removeBooking() {
        
        try {
            List<Flight> bookings = bookedFlights.getSelectionModel().getSelectedItems();
            GetFlightObjectFromList listTemp = new GetFlightObjectFromList(this.fileBooking.getFlightsToDownload());
            Flight tempFlight = listTemp.flightFromList();

            if (tempFlight.isBooked == false) {
                throw new FlightNotFoundException("Cannot remove booking, because flight has not yet been booked!");
            }
            
            if (bookings.isEmpty()) {
                // Show error message if no flight is selected
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("No flight selected");
                errorAlert.setContentText("Please select a flight before cancelling!.");
                errorAlert.showAndWait();
            } else {
                Alert confirmRemoval = new Alert(AlertType.CONFIRMATION);
                confirmRemoval.setHeaderText("Cancel booking");
                confirmRemoval.setContentText("Are you sure you want to cancel the flight?");
    
                ButtonType confirmCancelBooking = new ButtonType("Cancel booking");
                ButtonType cancelCancelBooking = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
                confirmRemoval.getButtonTypes().setAll(confirmCancelBooking, cancelCancelBooking);
    
                Optional<ButtonType> result = confirmRemoval.showAndWait();

                if (result.isPresent() && result.get() == confirmCancelBooking) {
                    for (Flight flightToRemove : bookings) {
                        flightToRemove.removeBooking(fileBooking);
                        // controllerIsBooked = false;
                        System.out.println(fileBooking.getFlightsToDownload());
                        Collections.sort(listOfFlights.getItems());
    
                    }
                    bookedFlights.getItems().removeAll(bookings); // Use removeAll() to remove all selected items
    
                }

            }
           

        } catch (FlightNotFoundException e) {
            Alert cannotCancelError = new Alert(AlertType.ERROR);
            cannotCancelError.setHeaderText("Error cancelling booking!");
            cannotCancelError.setContentText("Unable to cancel booking. The flight could not be found.");
            cannotCancelError.showAndWait();
        }
    }

}
