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
 * Class for triggered/static abilities
 */
public class TriggeredStaticAbility extends Ability {
    private final String text;
    /**
     * Constructor for triggered/static abilities
     */
    public TriggeredStaticAbility(){
        text = GeneralUse.getStringWithSpaces("the ability's text");
    }
    @Override
    public String toString() {
        return text;
    }
}
