/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated;


import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import pignated.cards.CreatureLand;
import pignated.cards.Creature;
import pignated.cards.Planeswalker;
import pignated.cards.BasicLand;
import pignated.cards.Land;
import pignated.cards.Enchantment;
import pignated.cards.InstantSorcery;
import pignated.cards.Card;
import pignated.cards.Artifact;

/**
 * Main class for the program
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to your card collection manager");
        /*
        Try to load the collection from a file. If fine dne then create a new collection
        which will be saved later
         */
        CardCollection collection;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("collection.bin"));
            collection = (CardCollection) in.readObject();
            System.out.println("Loaded collection with " +
                    collection.getCollectionSize() + " cards");
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No collection found");
            collection = new CardCollection();
        }
        boolean cont = true;
        while(cont){
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a card");
            System.out.println("2. View all cards");
            System.out.println("3. Search for a card");
            System.out.println("4. Delete a card");
            System.out.println("5. Save card to file");
            System.out.println("6. Save all cards to files");
            System.out.println("7. Exit");
            switch (GeneralUse.getInt(1, 3+1+3)) {
                case 1:
                    collection.addCard(newCard());
                    saveCollection(collection);
                    break;
                case 2:
                    collection.viewAllCards();
                    break;
                case 3:
                    collection.searchCard(GeneralUse.getStringWithSpaces("name"));
                    break;
                case 4:
                    collection.removeCard(GeneralUse.getStringWithSpaces("name"));
                    saveCollection(collection);
                    break;
                case 2+3:
                    collection.cardOut();
                    break;
                case 3+3:
                    collection.allCardsOut();
                    break;
                case 4+3:
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        saveCollection(collection);
    }
    private static void saveCollection(CardCollection collection){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                    "collection.bin"));
            out.writeObject(collection);
            out.close();
            System.out.println("Collection saved");
        } catch (IOException e) {
            System.out.println("Error saving collection");
            System.out.println(e.getMessage());
        }
    }
    private static Card newCard(){
        Card card;
        System.out.println("Is your card a permanent? (y/n)");
        if (GeneralUse.getYN()){
            System.out.println("Is your card a creature? (y/n)");
            if (GeneralUse.getYN()){
                System.out.println("Is your creature a land? (y/n)");
                if (GeneralUse.getYN()){
                    card = new CreatureLand();
                } else {
                    card = new Creature();
                }
            } else {
                System.out.println("Is your card a planeswalker? (y/n)");
                if (GeneralUse.getYN()) {
                    card = new Planeswalker();
                } else {
                    System.out.println("Is your card a Land");
                    if (GeneralUse.getYN()) {
                        System.out.println("Is your land a basic land? (y/n)");
                        if (GeneralUse.getYN()) {
                            card = new BasicLand();
                        } else {
                            card = new Land();
                        }
                    } else {
                        System.out.println("Is your card an enchantment? (y/n)");
                        if (GeneralUse.getYN()) {
                            card = new Enchantment();
                        } else {
                            card = new Artifact();
                        }
                    }

                }
            }
        } else {
            card = new InstantSorcery();
        }
        System.out.println(card);
        return card;
    }
}