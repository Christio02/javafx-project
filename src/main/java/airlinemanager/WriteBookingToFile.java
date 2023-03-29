package airlinemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteBookingToFile {

    private Flight flight;

    private List<Flight> flightsToDownload = new ArrayList<>();

    public void addFlight(List<Flight> flights) {
        this.flightsToDownload.addAll(flights);
    }

    public void writeToFile(String filename){//, List<Flight> flightsList) {

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

   

    public void readFromFile(String filename) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filename));

            // this.flightsToDownload = new ArrayList<>();


            while(scanner.hasNextLine()) {
            
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

       

    }

    // public List<Flight> getList() {
    //     return this.flightsToDownload;
    // }





    public static void main(String[] args) {

        List<Flight> testList = new ArrayList<>();

        WriteBookingToFile fileWrite = new WriteBookingToFile();

        Flight flight = new Flight();

        testList.add(flight);

        System.out.println(flight);

        fileWrite.writeToFile("testing-read.txt");

        // System.out.println(fileWrite.getList());

        fileWrite.readFromFile("testing-read.txt");
    

    
    }
    
}
