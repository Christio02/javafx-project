package airlinemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WriteBookingToFile {

    private Flight flight;

    private List<Flight> flightsToDownload = new ArrayList<>();

    public void addFlight(List<Flight> flights) {
        this.flightsToDownload.addAll(flights);
    }

    public void writeToFile(String filename) {

        
        try {
            PrintWriter writer = new PrintWriter(filename);
            
            for (Flight flight : flightsToDownload) {
                writer.println(flight);
                writer.println("---------------------");
            }

            writer.flush();
            writer.close();
            
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }     
    }

    // public void readFromFile(String filename) {
    //     Scanner scanner = new Scanner(new File(filename));

    //     this.flightsToDownload = new ArrayList<>();

    //     while(scanner.hasNextLine()) {
    //         String line = scanner.nextLine();
    //         String [] lineInfo = line.split(",");
    //     }

    // }

    public List<Flight> getList() {
        return this.flightsToDownload;
    }



    public static void main(String[] args) {

        WriteBookingToFile fileWrite = new WriteBookingToFile();

        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        Flight flight3 = new Flight();

        System.out.println(fileWrite.getList());

        System.out.println(System.getProperty("user.dir"));
    

    
    }
    
}
