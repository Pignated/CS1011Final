/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.cards;

import pignated.abilities.Ability;

/**
 * Class for instant cards
 */
public class InstantSorcery extends Card {
    private final String name;
    private final String subtype;
    private final String cost;
    private final Ability[] abilities;
    private final boolean isInstant;
    private final boolean isLegendary;
    private final boolean isSnow;
    /**
     * Constructor for instant cards
     */
    public InstantSorcery(){
        name = pignated.GeneralUse.getStringWithSpaces("the card's name");
        System.out.println("Is the card an instant? (y/n)");
        isInstant = pignated.GeneralUse.getYN();
        subtype = pignated.GeneralUse.getStringWithSpaces("the card's subtype " +
                "(Press Enter if none)");
        System.out.println("Is the card legendary? (y/n)");
        isLegendary = pignated.GeneralUse.getYN();
        System.out.println("Is the card snow? (y/n)");
        isSnow = pignated.GeneralUse.getYN();
        cost = pignated.Color.getColorCost();
        abilities = pignated.abilities.Ability.getAbilityArray();
    }
    @Override
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        StringBuilder abilityString = new StringBuilder();
        for (Ability ability: abilities) {
            abilityString.append(ability.toString()).append("\n");
        }
        cardString.append(name).append(" ").append(cost)
                .append("\n").append(isLegendary ? "Legendary " : "")
                .append(isSnow ? "Snow " : "").append(isInstant ? "Instant " : "Sorcery")
                .append(subtype.isEmpty() ? "":" — ").append(subtype).append("\n")
                .append(abilityString);
        return cardString.toString();
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof InstantSorcery && ((Card) obj).getName().equals(this.getName());
    }
}
