/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated;

import pignated.cards.Card;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
/**
 * A collection of cards
 */
public class CardCollection implements Serializable {
    private final ArrayList<Card> cards;
    /**
     * Constructor for a card collection
     */
    public CardCollection(){
        cards = new ArrayList<>();
    }
    /**
     * Adds a card to the collection
     * @param card the card to add
     */
    public void addCard(Card card) {
        cards.add(card);
    }
    /**
     * Removes a card from the collection
     * @param name the card to remove
     */
    public void removeCard(String name) {
        //Thanks to intellij for this suggestion
        cards.removeIf(card -> card.getName().equals(name));
    }
    /**
     * Searches for card with given name
     * @param name the name of the card to search for
     */
    public void searchCard(String name) {
        boolean found = false;
        for (Card card : cards) {
            if (card.getName().equals(name)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Card not found");
        }
    }
    public int getCollectionSize() {
        return cards.size();
    }
    /**
     * View all cards in the collection
     */
    public void viewAllCards() {
        for (Card card : cards) {
            System.out.println(card.getName());
        }
    }
    /**
     * Saves a card to a file
     */
    public void cardOut() {
        String name = GeneralUse.getStringWithSpaces("card name");
        Card cardToSave = null;
        boolean wasFound = false;
        for (Card card : cards) {
            if (wasFound){
                return;
            }
            if (card.getName().equals(name)) {
                System.out.println("card located");
                cardToSave = card;
                wasFound = true;
            }
        }
        if (!wasFound) {
            System.out.println("Card not found");
        } else {
            System.out.println("Enter the file name to save the card to: ");
            String fileName = GeneralUse.getStringWithSpaces("")+".txt";
            File file = new File(fileName);

            try {
                PrintWriter out = new PrintWriter(new FileOutputStream(file));
                out.println(cardToSave);
                out.close();
            } catch (IOException e) {
                System.out.println("Error saving card");
            }
        }

    }

}
