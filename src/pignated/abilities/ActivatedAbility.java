/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.abilities;

import pignated.GeneralUse;

/**
 * Class for activated abilities
 */
public class ActivatedAbility extends Ability {
    private final String cost;
    private final String text;

    /**
     * Constructor for activated abilities
     */
    public ActivatedAbility(){
        text = GeneralUse.getStringWithSpaces("the ability's text");
        cost = abilityCost();
    }
    @Override
    public String toString() {
        return cost + ": " + text;
    }
}
