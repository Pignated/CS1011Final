/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.abilities;
import pignated.GeneralUse;
import java.util.Scanner;
/**
 * Class for planeswalker abilities
 */
public class PlaneswalkerAbility extends Ability {
    private static final Scanner SCANNER = new Scanner(System.in);
    private String cost;
    private final String text;
    /**
     * Constructor for planeswalker abilities
     */
    public PlaneswalkerAbility(){

        text = GeneralUse.getStringWithSpaces("the ability's text");
        System.out.println("Enter Loyalty value");
        cost = String.valueOf(GeneralUse.getInt());
        System.out.println("Negative or positive loyalty? (+/-)");
        cost = plusMinus() + cost;
    }
    /**
     * Get whether the ability adds or removes loyalty
     * @return + or - depending on what the user inputs
     */
    public static String plusMinus(){
        String yN;
        while(true){
            yN = SCANNER.nextLine();
            if(yN.equalsIgnoreCase("+")||yN.equalsIgnoreCase("-")){
                return yN.equalsIgnoreCase("+") ? "+" : "-";
            } else {
                System.out.println("Invalid response: Enter Y for yes or N for no: ");
            }


        }
    }
    /**
     * Get an ability array for planeswalker
     * @return the abilities user entered
     */
    public static Ability[] getPlaneswalkerAbilityArray(){
        System.out.println("How many abilities does the Planeswalker have?");
        int numAbilities = GeneralUse.getInt();
        Ability[] abilities = new Ability[numAbilities];
        for (int i = 0; i < numAbilities; i++) {
            System.out.println("Ability " + (i + 1));
            System.out.println("Is the ability a loyalty ability? (y/n)");
            abilities[i] = GeneralUse.getYN() ?
                    new PlaneswalkerAbility()
                    : getAbility();
        }
        return abilities;
    }
    @Override
    public String toString() {
        return cost += ": " + text;
    }
}
