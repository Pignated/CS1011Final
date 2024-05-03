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
 * Class for land cards
 */
public class Land extends Card {
    private final String name;
    private final String subtypes;
    private final Ability[] abilities;
    private final boolean isLegendary;
    private final boolean isSnow;
    private final boolean isArtifact;
    private final boolean isEnchantment;
    /**
     * Constructor for land cards
     */
    public Land(){
        System.out.println("Is the land legendary? (y/n)");
        isLegendary = pignated.GeneralUse.getYN();
        System.out.println("Is the land snow? (y/n)");
        isSnow = pignated.GeneralUse.getYN();
        System.out.println("Is the land an artifact? (y/n)");
        isArtifact = pignated.GeneralUse.getYN();
        System.out.println("Is the land an enchantment? (y/n)");
        isEnchantment = pignated.GeneralUse.getYN();
        name = pignated.GeneralUse.getStringWithSpaces("the land's name");
        subtypes = pignated.GeneralUse.getStringWithSpaces("the land's subtypes");
        abilities = pignated.abilities.Ability.getAbilityArray();
    }
    @Override
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        StringBuilder abilityString = new StringBuilder();
        for (Ability ability: abilities) {
            abilityString.append(ability.toString()).append("\n");
        }
        cardString.append(name).append("\n").append(isLegendary ? "Legendary " : "")
                .append(isSnow ? "Snow " : "").append(isEnchantment ? "Enchantment " : "")
                .append(isArtifact ? "Artifact " : "").append("Land")
                .append(subtypes.isEmpty() ? "":" — ")
                .append(subtypes).append("\n").append(abilityString);
        return cardString.toString();
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Land && ((Card) obj).getName().equals(this.getName());
    }
}
