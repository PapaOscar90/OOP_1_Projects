package nl.rug.oop.rpg.Utility;

import java.util.Scanner;

/**
 * Helper functions
 * A class for helper functions and constants
 * Created by saidf on 4/29/2017.
 */

public abstract class HelperClass {
    // Universal static final ints for easy changing later
    public static final int NEW_DOORS_PER_ROOM = 2;
    public static final int NPC_SPAWN_CHANCE = 50;
    public static final int COMBAT_SCROLL_SPEED = 900;
    public static final int SPECIAL_DOOR_SPAWN_CHANCE = 25;
    public static final String GOOD_DOOR_DESCRIPTION = "A sparkly, golden door";
    public static final String BAD_DOOR_DESCRIPTION = "A bloody door with a skull for a knocker";
    public static final String DIRECTORY_NAME = "Savegames";
    public static final String SAVEFILE_EXTENSION = ".ser";
    public static final String QUICKSAVE_FILENAME = "Quicksave";


    // Allows only valid choices for a lower and upper bound
    public static int getValidChoice(int lowerB, int upperB) {
        Scanner in = new Scanner(System.in);
        int choice;
        while (true) {
            String input = in.nextLine();
            if (input.matches("^-?\\d{1,2}+$")) {  //This regex checks whether the string is a one or two digit number
                choice = Integer.parseInt(input);
                if (choice >= lowerB && choice < upperB + 1) {
                    break;
                }
            }
            System.out.println("Incorrect input, try again");
        }
        return choice;
    }

    public static void getValidChoice(){
        Scanner in = new Scanner(System.in);
        in.nextLine();
    }

    public static String getValidStringChoice(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while(input.isEmpty()) {
            System.out.println("1 or more characters please");
            input = in.nextLine();
        }
        return input;
    }


}
