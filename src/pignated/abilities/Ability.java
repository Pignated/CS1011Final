/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.abilities;

import pignated.Color;
import pignated.GeneralUse;

import java.io.Serializable;

/**
 * Superclass for abilities
 */
public abstract class Ability implements Serializable {
    /**
     * Method for ability cost
     * @return a string representation of the ability cost
     */
    public String abilityCost(){
        System.out.println("Ability cost generator");
        System.out.println("Does the card tap to use the ability?");
        boolean tapped = GeneralUse.getYN();
        System.out.println("Is there a mana cost?");
        StringBuilder cost = new StringBuilder(Color.getColorCost());
        if(tapped&& !cost.isEmpty()){
            cost.append(", {T}");
        } else if(tapped){
            cost = new StringBuilder("{T}");
        }
        System.out.println("Is there non-mana/tap costs? (y/n)");
        boolean more;
        if (GeneralUse.getYN()) {
            if (!cost.isEmpty()) {
                cost.append(", ");
            }
            cost.append(GeneralUse.getStringWithSpaces("additional cost text"));
            System.out.println("Are there more non-mana/tap costs? (y/n)");
            more = GeneralUse.getYN();
            while (more) {
                if (!cost.isEmpty()) {
                    cost.append(", ");
                }
                cost.append(GeneralUse.getStringWithSpaces("additional cost text"));
                System.out.println("Are there more non-mana/tap costs? (y/n)");
                more = GeneralUse.getYN();
            }
        }
        return cost.toString();
    }


    /**
     * Method for ability text
     * @return a string representation of the ability text
     */
    public abstract String toString();
    /**
     * Method for ability text
     * @return a string representation of the ability text
     */
    public static Ability[] getAbilityArray(){
        System.out.println("How many abilities does the card have?");
        Ability[] abilities = new Ability[GeneralUse.getInt()];
        for (int i = 0; i < abilities.length; i++) {
            System.out.println("Ability " + (i + 1));
            abilities[i] = getAbility();
        }
        return abilities;
    }
    /**
     * Method to create an ability
     * @return a string representation of the ability text
     */
    public static Ability getAbility(){
        System.out.println("Is the ability a keyword? (y/n)");
        if(GeneralUse.getYN()){
            System.out.println("Does the keyword have a cost? (y/n)");
            if(GeneralUse.getYN()){
                return new KeywordCost();
            } else {
                return new Keyword();
            }
        } else {
            System.out.println("Is the ability activated? (y/n)");
            if(GeneralUse.getYN()){
                return new ActivatedAbility();
            } else {
                return new TriggeredStaticAbility();
            }
        }
    }
}
