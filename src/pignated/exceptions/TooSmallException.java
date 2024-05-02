/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.exceptions;
/**
 * Exception for when a value is too small
 */
public class TooSmallException extends Exception {
    /**
     * Constructor for the exception
     * @param minValue the minimum value
     */
    public TooSmallException(int minValue){
        super("The value must be greater than or equal to " + minValue + "!");
    }
}
