package nl.rug.oop.rpg;

import java.util.List;

/**
 * RPG game
 * Created by PhilO on 27-Apr-17.
 */
public class Main {

    // Temporary to display actions
    private static void printRoomActions() {
        System.out.println("What do you want to do?");
        System.out.println("(0) Look around");
        System.out.println("(1) Look for a way out");
        System.out.println("(2) Look for company");
        System.out.println("(3) Kill yourself");
    }

    // Looks around, views room description
    private static void lookAround(Player p) {
        System.out.println("You see: " + p.getCurrentRoom().inspect());
    }

    // Looks around for doors, allows for possible interaction with doors
    private static void checkForDoors(Player p) {
        System.out.println("You look around for doors. You see:");
        p.handleDoorChoices(); // Checks if player wishes to interact with doors
    }

    // Looks around for NPCs, then allows for possible interaction with NPCs
    private static void checkForNpcs(Player p) {
        System.out.print("You look if there's someone here.");
        if (p.getCurrentRoom().getNumberOfnpcs() == 0) {
            System.out.println("\nBut there is nobody here.");
            System.out.println();
            return;
        }
        System.out.println(" You see:");
        p.handleNpcChoices(); // Checks if player wishes to interact with any
    }

    // If the player wants to take the easy way out
    private static boolean commitSuicide(Player p) {
        System.out.println("Congratulations! You have found the easy way out.");
        return true;
    }

    // The game loop, entire game takes place here. If this loop ends, game over.
    private static void gameLoop(Player player) {
        // TODO: Create a win condition or end on death
        boolean exit = false;
        while (!exit) {
            System.out.println("You have " + player.getGold() + " Gold.\n");
            printRoomActions();
            int choice = HelperClass.getValidChoice(0, 3);
            switch (choice) {
                case 0:
                    lookAround(player);
                    break;
                case 1:
                    checkForDoors(player);
                    break;
                case 2:
                    checkForNpcs(player);
                    break;
                case 3:
                    exit = commitSuicide(player);
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }

    // Main game initialization
    public static void main(String[] args) {
        List<Door> startingDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM);
        List<NPC> startingNpcs = GameObjectFactory.generateRandomNpcs(HelperClass.NPC_SPAWN_CHANCE);
        Room startingRoom = new Room("A dark room. Filled with spiders and a cold chill in the air.", startingDoors, startingNpcs);
        Weapon startingWeapon = new Weapon("A weapon of mass destruction", "Rusty dagger", 10, 5, 10);
        Player player = new Player(startingRoom, 100, startingWeapon, 50);
        gameLoop(player);
    }
}