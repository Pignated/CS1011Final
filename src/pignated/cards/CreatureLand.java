/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.cards;
/**
 * Class for creature land cards
 */
public class CreatureLand extends Card {
    private final String name;
    /**
     * Constructor for creature land cards
     */
    public CreatureLand(){
        name = "Dryad Arbor";
    }
    @Override
    public String toString() {
        return """
                Dryad Arbor
                Land Creature - Forest Dryad
                1/1""";
    }
    public String getName() {
        return name;
    }
}
