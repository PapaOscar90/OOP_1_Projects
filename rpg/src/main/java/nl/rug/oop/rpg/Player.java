package nl.rug.oop.rpg;

import java.util.Scanner;

/**
 * The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    // Stores the room object the player is in
    private Room currentRoom;

    // Constructor passes in a description of the first room
    // TODO: Create way to load rooms from file or generate random rooms
    public Player(Room startingRoom) {
        currentRoom = startingRoom;
    }

    // Returns the room object currently in
    public Room getRoom() {
        return currentRoom;
    }

    private void printDoorDescriptions() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        for (int i = 0; i < numberOfDoors; i++) {
            System.out.println(currentRoom.getDoorDescription(i));
        }
    }

    private void printChoices() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        System.out.println("\nWhat would you like to do?");
        System.out.println("(0) Stay Here");
        for (int i = 0; i < numberOfDoors; i++) {
            System.out.println("(" + (i + 1) + ") Enter " + currentRoom.getDoorDescription(i));
        }
    }

    private int chooseDoor() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        int choice = HelperFunctions.getValidChoice(0, numberOfDoors);
        return choice;
    }

    private void handleDoorChoice(int choice) {
        if (choice != 0) {
            System.out.println("You enter through the door");
            currentRoom = currentRoom.enterDoor(choice - 1);
        } else {
            System.out.println("You do nothing.");
        }
    }

    public void handleDoorChoices() {
        printDoorDescriptions();
        printChoices();
        int choice = chooseDoor();
        handleDoorChoice(choice);
    }
}
