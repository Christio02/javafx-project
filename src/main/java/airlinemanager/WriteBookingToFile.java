package airlinemanager;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* 
 * This class provides functionality for reading and writing flight bookings to and from text files.
 * Bookings can be added to a list using the addFlight method, and then written to a file using the writeToFile method.
 * The readFromFile method can be used to read bookings from a file and return them as a string.
*/

public class WriteBookingToFile {

    // Fields

    /**
     * This field is setting a protected List, for use in the flight.java class, by adding the booking to this list
     */

    protected List<Flight> flightsToDownload;

    // Constructor

    /**
     * Initializes a new WriteBookingToFile object with an empty list of flights to download.
     */

    public WriteBookingToFile() {
        this.flightsToDownload = new ArrayList<>();
    }

    /**
     * This method is responsible for adding the flight object to the list, 
     * it is called in a bookFlight method in the flight.java class
     * @param Flight object from flight.java class
     */

    public void addFlight(Flight flight) {
        this.flightsToDownload.add(flight);
    }

    /**
     * This method is responsible for removing a booking (i.e. canceling the booking)
     * It is called in a separate method in the flight.java class
     * @param Flight object to be removed
     */

    public void removeFlight(Flight flight) {
        int index = this.flightsToDownload.indexOf(flight);
        this.flightsToDownload.remove(index);
    }

    /*
     * A method that returns the current list of flights for download to list
     * @return List of flight objects
     */

    public List<Flight> getFlightsToDownload() {
        return this.flightsToDownload;
    }

    /**
     * This methdod writes bookings to a textfile using a specified file name 
     * It will then create a txt file with the name, and then write the flight object
     * in the list to a toString representation. This representation is a special case, 
     * for making it easier to read the content from the file and then display it in the application.
     * @param String with the specified filename
     */

    public void writeToFile(String filename){

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename);
            
            for (FlightStored flight1 : flightsToDownload) {
                writer.println(flight1.toStringFormatted());
                writer.println("---------------------");
            }

            writer.flush();
            writer.close();
            
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }     
    }

   /*
    * This method is used for reading a booking which is stored on a file, it uses the specified filename 
    * and then utilizes bufferedreader and filereader classes for reading from the file.
    * It also uses Stringbuilder to build the content from the file to a string format
    *@param specified filename in string format
    *@return returns a flight object in string format to be used in application
    */

    public String readFromFile(String filename) {
        
        File file = new File(filename);

        BufferedReader reader;
        FileReader fileReader;

        String line;
        StringBuilder builder = new StringBuilder();

        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);

            while ((line = reader.readLine()) != null) {
                if (line.contains("-----")) {
                    continue;
                }
                builder.append(line).append("\n");
            }

            reader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String flight = builder.toString().trim();

        System.out.println(flight);
        return flight;
       

    }

   



    public static void main(String[] args) {

        WriteBookingToFile fileWrite = new WriteBookingToFile();

        // System.out.println(fileWrite.getList());

        fileWrite.readFromFile("booking.txt");
    

    
    }
    
}
