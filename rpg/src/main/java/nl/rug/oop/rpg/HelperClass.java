package nl.rug.oop.rpg;

import java.util.Scanner;

/**
 * A class for helper functions and constants
 * Created by saidf on 4/29/2017.
 */
public class HelperClass {
    public static final int DOORS_PER_ROOM = 2;
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

}
