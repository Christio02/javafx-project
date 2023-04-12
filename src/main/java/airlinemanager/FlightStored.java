package airlinemanager;

import java.util.Random;
/* Description:
 * This is a class that creates objects that stores flightinformation
 * The only calculation it does is by generating random flightnumber, destinations and from fields
 *
 */

public class FlightStored {

    // Fields


    protected String start;
    protected String destination;
    protected String flightNumber;
    protected String time;
    protected String date;

    // Constructor:
    /*
     * Creates flightstored object by using; destination, start, flightnumber, time and date fields
     * Is used by flight object to handle booking etc
     */

    public FlightStored() {
        this.destination = setStartOrDest();
        this.start = setStartOrDest();
        flightNumber = setFlightNumber();
        this.time = generateRandomTime();
        setDate();

    }

    /*
     * Using Java.util.Random
     * Creates a random date string
     * Sets the date
     */

    public void setDate() {
        Random random = new Random();

        int year = random.nextInt(2) + 2023;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(31) +1;

        String monthString = String.format("%02d", month);
        String dayString = String.format("%02d", day);

        this.date = year + "-" + monthString + "-" + dayString;
    }

    /*
     * Using random class, retrieves random location from the String array
     * the two locations should be different, which is logical
     * @return random string location from array
     */

    private String setStartOrDest() {
        Random random = new Random();
        String[] locations = { "Oslo", "Trondheim", "Bergen", "Stavanger", "Kristiansand", "Tromsø",
                "Bodø", "Malaga", "London", "København", "Stockholm", "Paris", "Barcelona"
        };

        String location1, location2;

        location1 = locations[random.nextInt(locations.length)];
        do {
            location2 = locations[random.nextInt(locations.length)];
        } while (location2.equals(location1));

        start = location1;
        destination = location2;

        return location1;

    }

    /*
     * Generates a random time in 24 hour format using random class
     * Is generated between 06.00 and 24.00 hour
     * @return string time
     */

    private String generateRandomTime() {

        Random random = new Random();

        int lowerBoundHour = 5;
        int upperBoundHour = 23;

        int lowerBoundMinutes = 0;
        int upperBoundMinutes = 5;

        int randomTimeHour = random.nextInt(upperBoundHour - lowerBoundHour + 1) + lowerBoundHour;
        int randomTimeMinutes = random.nextInt(upperBoundMinutes - lowerBoundMinutes + 1) * 10 + lowerBoundMinutes;

        String intHour = String.format("%02d", randomTimeHour);
        String intMin = String.format("%02d", randomTimeMinutes);

        String finString = intHour + ":" + intMin;

        return finString;

    }
    /*
     * Getter for return time
     * @return time string
     */

    public String getTime() {
        return this.time;
    }

     /*
     * Getter for returning hours to be used in compareTo method
     * Parses getTime (10:20) -> 10 to int
     * @return integer of hours
     */

    public int getHours() {

        int hours = Integer.parseInt(this.getTime().split(":")[0]);

        return hours;
    }

    /*
     * getter for returning minutes used in compareTo method in flight.java class
     * Parses the minutes by splitting string
     * @return integer of minutes
     */

    public int getMinutes() {

        int minutes = Integer.parseInt(this.getTime().split(":")[1]);

        return minutes;
    }

    /*
     * Private method that generates a random flightnumber in the allowed format
     * Does not need validation, since we are using Junit, and the correct format is generated
     * each time
     * "OY" is the ficive part of the flightnumber
     * @return String of flightnumber
     */

    private String setFlightNumber() {

        Random random = new Random();

        String letterPart = "OY";
        int numberPart = random.nextInt(3000, 6000);

        String flightNumber = letterPart + String.valueOf(numberPart);

        return flightNumber;

    }

    /*
     * Getter for returning start location
     * @return string of a location
     */

    public String getStart() {
        return this.start;
    }
      /*
     * Getter for returning destination location
     * @return string of a location
     */

    public String getDestination() {
        return this.destination;
    }

    /*
     * Getter for returning date for that flight
     * @return string of date format
     */

    public String getDate() {
        return this.date;
    }
    /*
     * To-string method that is used in the app for displaying flight information
     * in an intuitive way
     * @return to-string of flightstored object
     */

    // for app
    @Override
    public String toString() {
       return "Flight: " + flightNumber + "\n" +
            "From: " + start + "\n" +
            "To: " + destination + "\n" +
            "Departure Time: " + getTime() + "\n" +
            "Date: " + getDate();
    }

    /*
     * To string method which is only used for writing to file
     * Is used in WriteBookingToFile.java class
     * Makes it easier to read from file
     */

    // for file writing
    public String toStringFormatted() {
        return "Flight: " + flightNumber + ", From: " + start + ", To: " + destination + ", Departure Time: " + getTime() + ", Date: " + getDate();
    }


    public static void main(String[] args) {

        FlightStored f1 = new FlightStored();

        System.out.println(f1);

    }

}
