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
public class KeywordCost extends Ability {
    private final String cost;
    private final String keyword;
    /**
     * Constructor for keywords with a cost
     */
    public KeywordCost(){
        this.keyword = pignated.GeneralUse.getStringWithSpaces("the keyword");
        cost = Color.getColorCost();
    }

    @Override
    public String toString() {
        return keyword + " " + cost;
    }
}
