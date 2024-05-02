/*
 * Course: CS1011 - 111
 * Spring 2024
 * Final Project
 * Name: Nathan Cobb
 * Created: 4/26/2024
 */
package pignated.cards;
/**
 * Class for basic lands
 */
public class BasicLand extends Land {
    private String name;
    private String ability;
    private String type;
    /**
     * Constructor for basic lands
     */
    public BasicLand(){
        System.out.println("Select Basic Land Type");
        System.out.println("1. Plains");
        System.out.println("2. Island");
        System.out.println("3. Swamp");
        System.out.println("4. Mountain");
        System.out.println("5. Forest");
        System.out.println("6. Wastes");
        boolean worked = true;
        do{
            int choice = pignated.GeneralUse.getInt(1, 3+3);
            System.out.println("Is it a snow land? (y/n)");
            boolean isSnow = pignated.GeneralUse.getYN();
            switch (choice) {
                case 1:
                    name = isSnow ? "Snow-Covered Plains" : "Plains";
                    ability = "{T}: Add {W}";
                    type = isSnow ? "Basic Snow Land" : "Basic Land";
                    break;
                case 2:
                    name = isSnow ? "Snow-Covered Island" : "Island";
                    ability = "{T}: Add {U}";
                    type = isSnow ? "Basic Snow Land" : "Basic Land";
                    break;
                case 3:
                    name = isSnow ? "Snow-Covered Swamp" : "Swamp";
                    ability = "{T}: Add {B}";
                    type = isSnow ? "Basic Snow Land" : "Basic Land";
                    break;
                case 4:
                    name = isSnow ? "Snow-Covered Mountain" : "Mountain";
                    ability = "{T}: Add {R}";
                    type = isSnow ? "Basic Snow Land" : "Basic Land";
                    break;
                case 2 + 3:
                    name = isSnow ? "Snow-Covered Forest" : "Forest";
                    ability = "{T}: Add {G}";
                    type = isSnow ? "Basic Snow Land" : "Basic Land";
                    break;
                case 3 + 3:
                    name = isSnow ? "Snow-Covered Wastes" : "Wastes";
                    ability = "{T}: Add {C}";
                    type = isSnow ? "Basic Snow Land" : "Basic Land";
                    break;
                default:
                    worked = false;
                    System.out.println("Try again");
                    break;
            }
        } while(worked);


    }
    @Override
    public String toString() {
        return name + "\n" + type + "\n" + ability;
    }
}
