/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.abilities;

import pignated.Color;
/**
 * Class for keywords with a cost
 */
public class KeywordCost extends Keyword {
    private final String cost;
    /**
     * Constructor for keywords with a cost
     */
    public KeywordCost(){
        this.setKeyword(pignated.GeneralUse.getStringWithSpaces("the keyword"));
        cost = Color.getColorCost();
    }

    @Override
    public String toString() {
        return super.toString() + " " + cost;
    }
}
