package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    // Stores the room object the player is in
    private Room currentRoom;
    private List<Room> previousRoomsList = new ArrayList<Room>();

    // Constructor
    public Player(Room startingRoom) {
        currentRoom = startingRoom;
        previousRoomsList.add(currentRoom);
    }

    // Returns the room object currently in
    public Room getRoom() {
        return currentRoom;
    }

    // Updates the current room, and adds the room to rooms visited if it has not been visited
    public void setRoom(Room room){
        currentRoom = room;
        if(!previousRoomsList.contains(room)){
            previousRoomsList.add(room);
        }
    }

    // Player looks at the doors
    private void seeDoors() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        for (int i = 0; i < numberOfDoors; i++) {
            System.out.println(currentRoom.getDoorDescription(i));
        }
    }

    // Player considers which door to enter
    private void considerDoors() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        System.out.println("\nWhat would you like to do?");
        System.out.println("(0) Stay Here");
        for (int i = 0; i < numberOfDoors; i++) {
            System.out.println("(" + (i + 1) + ") Enter " + currentRoom.getDoorDescription(i));
        }
    }

    // Player can choose a door
    private int chooseDoor() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        int choice = HelperClass.getValidChoice(0, numberOfDoors);
        return choice;
    }

    // Steps a player takes to choose a door
    private void enterDoor(int choice) {
        if (choice != 0) {
            System.out.println("You enter through the door");
            if (previousRoomsList.contains(currentRoom.getDoor(choice-1).getRoom())){
                currentRoom = currentRoom.getDoor(choice-1).getRoom();
                return;
            }else {
                currentRoom.getDoor(choice - 1).interact(this);
            }
        } else {
            System.out.println("You do nothing.");
        }
    }

    // The though process a player takes to enter a door
    public void handleDoorChoices() {
        seeDoors();
        considerDoors();
        int choice = chooseDoor();
        enterDoor(choice);
    }
}
