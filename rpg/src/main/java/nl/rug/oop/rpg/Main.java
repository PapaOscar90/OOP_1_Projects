package nl.rug.oop.rpg;

import java.util.Scanner;

/**
 * RPG game
 * Created by PhilO on 27-Apr-17.
 */
public class Main {

    // Temporary to display actions
    // TODO: Add system to know what actions are available. Expand this
    private static void printRoomActions() {
        System.out.println("What do you want to do?");
        System.out.println("(0) Look around");
        System.out.println("(1) Look for a way out");
        System.out.println("(2) Kill yourself");
    }

    private static void gameLoop(Player player){
        // While true just for debugging
        // TODO: Create a win condition or end on death
        boolean exit = false;
        while (!exit) {
            printRoomActions();
            int choice = HelperFunctions.getValidChoice(0, 2);
            switch (choice) {
                case 0:
                    System.out.println("You see: " + player.getRoom().inspect());
                    break;
                case 1:
                    System.out.println("You look around for doors. You see:");
                    player.handleDoorChoices();
                    break;
                case 2:
                    System.out.println("Congratulations! You have found the exit.");
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }

    public static void main(String[] args) {
        // Initializes the player, and places them in the first room
        // TODO: Make the room generation input from files or generate them from random premade sentences

        Room startingRoom = new Room("A dark room with a white and black door.", "A white door", "A black door");
        Player player = new Player(startingRoom);
        gameLoop(player);
    }
}
