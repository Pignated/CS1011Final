/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.cards;

import pignated.GeneralUse;
import java.io.Serializable;

/**
 * Superclass for all cards
 */
public abstract class Card implements Serializable {

    /**
     * Utility to get the subtypes of a card
     * @return an array of subtypes
     */
    public static String[] getPowTough(){
        System.out.println("What is the power/toughness? (integer, X, or *)");
        String[] powTough = new String[2];
        boolean valid = false;
        while(!valid){
            powTough[0] = GeneralUse.getStringWithSpaces("power");
            if(powTough[0].matches("[0-9]+")||powTough[0].equals("X")||powTough[0].equals("*")){
                powTough[0] = powTough[0].equals("x") ? "X" : powTough[0];
                valid = true;
            } else {
                System.out.println("Invalid power. Enter an integer, X, or *");
            }
        }
        valid = false;
        while(!valid){
            powTough[1] = GeneralUse.getStringWithSpaces("toughness");
            if(powTough[1].matches("[0-9]+")||powTough[1].equals("X")||powTough[1].equals("*")){
                powTough[1] = powTough[1].equals("x") ? "X" : powTough[1];
                valid = true;
            } else {
                System.out.println("Invalid toughness. Enter an integer, X, or *");
            }
        }
        return powTough;
    }
    /**
     * ToString method for all cards
     * @return a string representation of the card
     */
    public abstract String toString();
    /**
     * Method to get the name of the card
     * @return the name of the card
     */
    public abstract String getName();

}
