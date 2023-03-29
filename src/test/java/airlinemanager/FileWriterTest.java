package airlinemanager;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        BufferedReader reader;
        FileReader fileR;

        String line;
        StringBuilder contentBuilder = new StringBuilder();
        try {
            fileR = new FileReader(testFile);
            reader = new BufferedReader(fileR);
            try {
                while ((line = reader.readLine()) != null) {
                    if (line.contains("-----")) {
                        continue; // skip this line
                    }
                    contentBuilder.append(line).append("\n");
                }

                reader.close();
                fileR.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }

        
        String outputContent = contentBuilder.toString().trim();

        String expectedOutput = flight.toStringFormatted();

        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Output content: " + outputContent);

        assertEquals(expectedOutput, outputContent);
        

    }



    
}
