/*
* Course: CS1011 - 111
* Spring 2024
* Final Project
* Name: Nathan Cobb
* Created: 4/26/2024
*/
package pignated;


import java.io.Serializable;

/**
 * Enumerated type for the colors
 */
public enum Color implements Serializable {
    /**
     * The color white
     */
    WHITE("W"),
    /**
     * The color blue
     */
    BLUE("U"),
    /**
     * The color black
     */
    BLACK("B"),
    /**
     * The color red
     */
    RED("R"),
    /**
     * The color green
     */
    GREEN("G");
    private static final java.util.Scanner SCANNER = new java.util.Scanner(System.in);
    private final String symbol;
    
    Color(String symbol) {
        this.symbol = symbol;
    }
    static int getCount(String color) {

        System.out.println("How many " + color + " mana symbols are in the cost?");
        return SCANNER.nextInt();
    }

    /**
     * Get the color cost
     * @return the color cost
     */
    public static String getColorCost() {
        boolean done = false;
        StringBuilder colorString = new StringBuilder();
        System.out.println("Color cost generator");
        while(!done) {
            System.out.println("Choose color: ");
            System.out.println("1. Colorless");
            System.out.println("2. White");
            System.out.println("3. Blue");
            System.out.println("4. Black");
            System.out.println("5. Red");
            System.out.println("6. Green");
            System.out.println("7. Done with cost selection");
            System.out.println("Enter choice: ");
            int choice = GeneralUse.getInt(1, 3+4);
            switch (choice) {
                case 1:
                    colorString.append("{");
                    colorString.append(getCount("colorless"));
                    colorString.append("}");
                    break;

                case 2:
                    colorString.append("{");
                    colorString.append(String.valueOf(WHITE.symbol).
                            repeat(Math.max(0, getCount("white"))));
                    colorString.append("}");
                    break;
                case 3:
                    colorString.append("{");
                    colorString.append(String.valueOf(BLUE.symbol).
                            repeat(Math.max(0, getCount("blue"))));
                    colorString.append("}");
                    break;
                case 4:
                    colorString.append("{");
                    colorString.append(String.valueOf(BLACK.symbol).
                            repeat(Math.max(0, getCount("black"))));
                    colorString.append("}");
                    break;
                case 4 + 1:
                    colorString.append("{");
                    colorString.append(String.valueOf(RED.symbol).
                            repeat(Math.max(0, getCount("red"))));
                    colorString.append("}");
                    break;
                case 4 + 2:
                    colorString.append("{");
                    colorString.append(String.valueOf(GREEN.symbol).
                            repeat(Math.max(0, getCount("green"))));
                    colorString.append("}");
                    break;
                case 4 + 3: //Best solution to magic numbers
                    done = true;
                    break;
            }
        }
        return colorString.toString();

    }
}
