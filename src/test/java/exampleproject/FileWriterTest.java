package exampleproject;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import airlinemanager.Flight;
import airlinemanager.WriteBookingToFile;


public class FileWriterTest {


    private WriteBookingToFile writer;


    private Flight flight;


    @BeforeEach
    public void setUp() {
        writer = new WriteBookingToFile();
        flight = new Flight();
    }

    @Test
    @DisplayName("Testing that flight is being correctly written to file")
    public void testCorrectWrittenFlightBookingToFile() {

        File testFile = new File("testFile.txt");

        flight.bookFlight();
        Scanner scanner;

        StringBuilder contentBuilder = new StringBuilder();
        try {
            scanner = new Scanner(testFile);

            
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println("Test file: " + line);
                contentBuilder.append(line).append("\n");
        }

        scanner.close();
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }

        
        String outputContent = contentBuilder.toString();

        String expectedOutput = flight.toStringFormatted();

        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Output content: " + outputContent);

        assertEquals(expectedOutput, outputContent);
        

    }



    
}
