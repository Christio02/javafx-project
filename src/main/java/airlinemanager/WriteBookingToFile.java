package airlinemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

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
       

    }

   




    public static void main(String[] args) {

        WriteBookingToFile fileWrite = new WriteBookingToFile();

        // System.out.println(fileWrite.getList());

        fileWrite.readFromFile("testFile.txt");
    

    
    }
    
}
