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
 * Class for keywords
 */
public class Keyword extends Ability {
    private final String keyword;
    /**
     * Constructor for keywords
     */
    public Keyword(){
        keyword = GeneralUse.getStringWithSpaces("the keyword");
    }

    @Override
    public String toString() {
        return keyword;
    }
}

