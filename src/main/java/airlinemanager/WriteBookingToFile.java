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
            writer.println("Flight Number,From,To,Departure Time");
    
            for (Flight flight : flightsToDownload) {
                String[] fields = {
                    flight.getFlightNumber(),
                    flight.getStart(),
                    flight.getDestination(),
                    flight.getTime()
                };
                writer.println(String.join(",", fields));
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

            this.flightsToDownload = new ArrayList<>();

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
    
                String [] lineInfo = line.split(", ");
    
                String flightNum = lineInfo[0].substring(8);
                String from = lineInfo[1].substring(6);
                String to = lineInfo[2].substring(4);
                String departureTime = lineInfo[3].substring(16);
    
                Flight flight = new Flight(flightNum, from, to, departureTime);
                this.flightsToDownload.add(flight);
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

        fileWrite.writeToFile("testing-read.txt");

        // System.out.println(fileWrite.getList());

        fileWrite.readFromFile("testing-read.txt");
    

    
    }
    
}
