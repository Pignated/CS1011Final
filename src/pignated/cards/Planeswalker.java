/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.cards;

import pignated.Color;
import pignated.GeneralUse;
import pignated.abilities.Ability;
/**
 * Class for Planeswalker cards
 */
public class Planeswalker extends Card {
    private final String name;
    private final int loyalty;
    private final String subtypes;
    private final String cost;
    private final Ability[] abilities;
    private final boolean isLegendary;

    /**
     * Constructor for Planeswalker cards
     */
    public Planeswalker(){
        name = pignated.GeneralUse.getStringWithSpaces("the Planeswalker's name");
        cost = Color.getColorCost();
        System.out.println("Is the Planeswalker legendary? (y/n)");
        isLegendary = pignated.GeneralUse.getYN();
        subtypes = GeneralUse.getStringWithSpaces("the Planeswalker's subtypes");
        abilities = pignated.abilities.PlaneswalkerAbility.getPlaneswalkerAbilityArray();
        System.out.println("Enter Planeswalker's starting loyalty: ");
        loyalty = pignated.GeneralUse.getInt(0);


    }
    @Override
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        StringBuilder abilityString = new StringBuilder();
        for (Ability ability: abilities) {
            abilityString.append(ability.toString()).append("\n");
        }
        cardString.append(name).append(" ").append(cost).append("\n")
                .append(isLegendary ? "Legendary " : "")
                .append("Planeswalker")
                .append(subtypes.isEmpty() ? "":" — ")
                .append(subtypes).append("\n")
                .append(abilityString).append("Loyalty: ").append(loyalty);
        return cardString.toString();
    }
    public String getName(){
        return name;
    }
}
