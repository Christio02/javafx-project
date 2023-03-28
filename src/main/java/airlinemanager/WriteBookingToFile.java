package airlinemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
                writer.println(flight.toStringFormatted());
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

            this.flightsToDownload = new ArrayList<>();

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String [] lineInfo = line.split("\\s+");

                // String flightNum = lineInfo[1];
                // String from = lineInfo[3];
                // String to = lineInfo[5];
                // String departureTime = lineInfo[8] + " " + lineInfo[9];
                // String dest = fileInfo.get(3); String time = fileInfo.get(4);


                // System.out.println(flightNum);
                // Flight flight = new Flight(flight1);

                

                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

       

    }

    public List<Flight> getList() {
        return this.flightsToDownload;
    }





    public static void main(String[] args) {

        List<Flight> testList = new ArrayList<>();

        WriteBookingToFile fileWrite = new WriteBookingToFile();

        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        Flight flight3 = new Flight();

        testList.add(flight1); 
        

        fileWrite.addFlight(testList);

        System.out.println(testList.size());

        fileWrite.writeToFile("testing-read.txt");

        // System.out.println(fileWrite.getList());

        fileWrite.readFromFile("testing-read.txt");
    

    
    }
    
}
