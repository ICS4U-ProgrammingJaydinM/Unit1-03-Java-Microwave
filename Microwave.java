/**
 * This program tells the user the amount of energy 
 * based on the mass they input
 * @author Jaydin Madore
 * @version 1.0
 * @since 2023-02-26
 */

// imports
import java.util.Scanner;

public final class Microwave {
    public static int[] timeConversion(double totalTimeSeconds) {
        int totalTimeMinutes = (int)(totalTimeSeconds / 60);
        double remainingSeconds = totalTimeSeconds % 60.0;
        int totalTimeMinutesInt = (int) totalTimeMinutes;
        System.out.println("Total time: " + totalTimeMinutes + " minutes and " + remainingSeconds + " seconds.");
        // Returning an array with minutes and remaining seconds
        return new int[]{totalTimeMinutesInt, (int) remainingSeconds};
    } 
    public static void main(String[] args) {
        // constants 
        final int SubTimer = 1;
        final int PizzaTimer = 45;
        final int SoupTimer = 105;
        double totalTimeSeconds = 0;
        try {
            // starts the scanner.
            Scanner userInput = new Scanner(System.in);
            // ask the user to input what they are heating up.
            System.out.println("What are you heating up Sub, Pizza, or Soup");
            String itemType = userInput.next();
            // asks the user how many they are heating up.
            System.out.println("How many " + itemType + "s are you heating up (3 max)");
            int numItem = userInput.nextInt();
            if (1 <= numItem && numItem <= 3) {
                switch (itemType) {
                    case "Sub":
                        totalTimeSeconds = (double)(SubTimer * (1 + ((numItem -1) /2.0)));
                        break;
                    case "Pizza":
                        totalTimeSeconds = (double)(PizzaTimer * (1 + ((numItem -1) /2.0)));
                        break;
                    case "Soup":
                        totalTimeSeconds = (double)(SoupTimer * (1 + ((numItem -1) /2.0)));
                        break;
                }
                timeConversion((double) totalTimeSeconds);
            } else {
                System.out.println("Please enter a valid number of items (1 to 3).");
            }
        } catch (Exception e) {
            // error checks for letters.
            System.out.println("You can not enter letters " + e.getMessage());
            
        }
    }
}
