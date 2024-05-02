/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated;

import pignated.exceptions.TooBigException;
import pignated.exceptions.TooSmallException;

import java.io.Serializable;

/**
 * Class for general use methods
 */
public class GeneralUse implements Serializable {
    private static final java.util.Scanner SCANNER = new java.util.Scanner(System.in);
    /**
     * Get a Y or N string from the user
     * @return true if the user entered Y, false if the user entered N
     */
    public static boolean getYN(){
        String yN;
        while(true){
            yN = SCANNER.nextLine();
            if(yN.equalsIgnoreCase("Y")||yN.equalsIgnoreCase("N")){
                return yN.equalsIgnoreCase("Y");
            } else {
                System.out.println("Invalid response: Enter Y for yes or N for no: ");
            }


        }
    }
    /**
     * Get an integer from the user
     * @param request what to ask the user for
     * @return the integer the user entered
     */
    public static String getStringWithSpaces(String request) {
        if(request.isEmpty()){
            return SCANNER.nextLine();
        }
        System.out.println("Enter " + request + ": ");
        return SCANNER.nextLine();
    }
    /**
     * Get an integer from the user
     * @param min the minimum value the user can enter
     * @return the integer the user entered
     */
    public static int getInt(int min){
        while (true) {
            try {
                int input = Integer.parseInt(SCANNER.nextLine());
                if (input < min) {
                    throw new TooSmallException(min);
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Enter a number");
            } catch (TooSmallException e) {
                System.out.println("Invalid input: Enter a number greater than " + min);
            }
        }
    }
    /**
     * Get an integer from the user
     * @param min the minimum value the user can enter
     * @param max the maximum value the user can enter
     * @return the integer the user entered
     */
    public static int getInt(int min, int max){
        while (true) {
            try {
                int input = Integer.parseInt(SCANNER.nextLine());
                if (input < min) {
                    throw new TooSmallException(min);
                } else if (input > max) {
                    throw new TooBigException(max);
                }

                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Enter a number");
            } catch (TooSmallException e) {
                System.out.println("Invalid input: Enter a number greater than " + min);
            } catch (TooBigException e) {
                System.out.println("Invalid input: Enter a number less than " + max);
            }
        }
    }
    /**
     * Get an integer from the user
     * @return the integer the user entered
     */
    public static int getInt() {
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Enter a number");
            }
        }
    }
}
