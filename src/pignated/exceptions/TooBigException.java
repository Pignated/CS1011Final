/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.exceptions;
/**
 * Exception for when a value is too big
 */
public class TooBigException extends Exception {
    /**
     * Constructor for the exception
     * @param maxValue the maximum value
     */
    public TooBigException(int maxValue){
        super("The value must be less than or equal to " + maxValue + "!");
    }
}
