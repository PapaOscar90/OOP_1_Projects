package nl.rug.oop.rpg;

import java.util.List;

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
        System.out.println("(2) Look for company");
        System.out.println("(3) Kill yourself");
    }

    private static void lookAround(Player p) {
        System.out.println("You see: " + p.getRoom().inspect());
    }

    private static void checkForDoors(Player p) {
        System.out.println("You look around for doors. You see:");
        p.handleDoorChoices();
    }

    private static void checkForNpcs(Player p) {
        System.out.println("You look if there's someone here. You see:");
        if (p.getRoom().getNumberOfnpcs() == 0) {
            System.out.println("There's no one here.");
            System.out.println();
            return;
        }
        p.handleNpcChoices();
    }

    private static boolean commitSuicide(Player p) {
        System.out.println("Congratulations! You have found the exit.");
        return true;
    }

    // The game loop, entire game takes place here. This loop ends, game over.
    private static void gameLoop(Player player) {
        // TODO: Create a win condition or end on death
        boolean exit = false;
        while (!exit) {
            printRoomActions();
            int choice = HelperClass.getValidChoice(0, 3);
            // TODO: Put all the code in each case in separate methods
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

    public static void main(String[] args) {
        List<Door> startingDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM);
        List<NPC> startingNpcs = GameObjectFactory.generateRandomNpcs(HelperClass.NPC_SPAWN_CHANCE);
        Room startingRoom = new Room("A dark room. Filled with spiders and a cold chill in the air.", startingDoors, startingNpcs);
        Player player = new Player(startingRoom);
        gameLoop(player);
    }
}