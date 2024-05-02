/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.cards;

import pignated.GeneralUse;
import pignated.abilities.Ability;

/**
 * Class for creatures
 */
public class Creature extends Card {
    private final String power;
    private final String toughness;
    private final String name;

    private final boolean isEnchantment;
    private final boolean isSnow;
    private final boolean isArtifact;
    private final String cost;
    private final String subtypes;
    private final Ability[] abilities;
    private final boolean isLegendary;
    /**
     * Constructor for creatures
     */
    public Creature(){
        name = pignated.GeneralUse.getStringWithSpaces("the creature's name");
        System.out.println("Is the creature legendary? (y/n)");
        isLegendary = pignated.GeneralUse.getYN();
        System.out.println("Is the creature snow? (y/n)");
        isSnow = pignated.GeneralUse.getYN();
        System.out.println("Is the creature an artifact? (y/n)");
        isArtifact = pignated.GeneralUse.getYN();
        System.out.println("Is the creature an enchantment? (y/n)");
        isEnchantment = pignated.GeneralUse.getYN();
        System.out.println("What is the creature's power? (0-99, X, or *)");
        String[] powTough = getPowTough();
        power = powTough[0];
        toughness = powTough[1];
        cost = pignated.Color.getColorCost();
        subtypes = GeneralUse.getStringWithSpaces("the creature's subtypes");
        abilities = pignated.abilities.Ability.getAbilityArray();
    }
    @Override
    public String toString() {
        StringBuilder cardString = new StringBuilder();
        StringBuilder abilityString = new StringBuilder();
        for (Ability ability: abilities) {
            abilityString.append(ability.toString()).append("\n");
        }
        cardString.append(name).append(cost).append("\n").append(isLegendary ? "Legendary " : "")
                .append(isSnow ? "Snow " : "").append(isEnchantment ? "Enchantment " : "")
                .append(isArtifact ? "Artifact " : "").append("Creature")
                .append(subtypes.isEmpty() ? "":" — ").append(subtypes).append("\n")
                .append(abilityString).append("\n").append(power).append("/").append(toughness);

        return cardString.toString();
    }

    @Override
    public String getName() {
        return name;
    }
}
