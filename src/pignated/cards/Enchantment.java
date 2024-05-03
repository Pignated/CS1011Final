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
 * Class for enchantment cards
 */
public class Enchantment extends Card {
    private final String name;
    private final String subtype;
    private final String cost;
    private final boolean isSnow;
    private final boolean isLegendary;
    private final Ability[] abilities;

    /**
     * Constructor for enchantment cards
     */
    public Enchantment(){
        name = pignated.GeneralUse.getStringWithSpaces("the enchantment's name");
        subtype = pignated.GeneralUse.getStringWithSpaces("the enchantment's subtypes");
        System.out.println("Is the enchantment legendary? (y/n)");
        isLegendary = pignated.GeneralUse.getYN();
        System.out.println("Is the enchantment snow? (y/n)");
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
                .append(isSnow ? "Snow " : "").append("Enchantment")
                .append(subtype.isEmpty() ? "":" — ").append(subtype).append("\n")
                .append(abilityString);
        return cardString.toString();
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Enchantment && ((Card) obj).getName().equals(this.getName());
    }
}
