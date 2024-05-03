/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated;

import pignated.cards.Card;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

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
        boolean alreadyExists = false;
        for (Card c : cards) {
            if (alreadyExists) {
                return;
            }
            if (c.equals(card)) {
                alreadyExists = true;
            }
        }
        if(!alreadyExists) {
            cards.add(card);
        } else {
            System.out.println("Card already exists in collection");
        }
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
    private void saveCard(Card card) {
        String fileName = card.getName().
                replace(" ", "_").replace(",", "")+".txt";
        File dir = new File(".\\src\\examples");
        if (!dir.exists()) {
            if(dir.mkdirs()) {
                System.out.println("Directory created");
            }
        }

        try {

            File file = new File(dir, fileName);
            PrintWriter out = new PrintWriter(file);
            out.println(card);
            out.close();
        } catch (IOException e) {
            System.out.println("Error saving card");
            System.out.println(e.getMessage());
        }
    }
    /**
     * Saves all cards to files
     */
    public void allCardsOut() {
        for (Card card : cards) {
            saveCard(card);
        }
    }
    /**
     * Saves a card to a file
     */
    public void cardOut() {
        String name = GeneralUse.getStringWithSpaces("card name");
        boolean wasFound = false;
        for (Card card : cards) {
            if (wasFound){
                return;
            }
            if (card.getName().equalsIgnoreCase(name)) {
                System.out.println("card located");
                wasFound = true;
                saveCard(card);
            }
        }
        if (!wasFound) {
            System.out.println("Card not found");
        }

    }

}
