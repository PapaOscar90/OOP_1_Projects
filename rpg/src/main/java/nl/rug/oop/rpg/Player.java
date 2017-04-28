package nl.rug.oop.rpg;

import java.util.Scanner;

/**The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    // Stores the room object the player is in
    private Room currentRoom;

    // Constructor passes in a description of the first room
    // TODO: Create way to load rooms from file or generate random rooms
    public Player(String s, String...doorDescriptions){
        currentRoom = new Room(s, doorDescriptions);
    }

    // Returns the room object currently in
    public Room getRoom(){
        return currentRoom;
    }

    private void printDoorDescriptions(){
        int numberOfDoors = currentRoom.getNumberOfDoors();
        for (int i = 0; i < numberOfDoors; i++){
            System.out.println(currentRoom.getDoorDescription(i));
        }
    }

    private void printChoices(){
        int numberOfDoors = currentRoom.getNumberOfDoors();
        System.out.println("\nWhat would you like to do?");
        for (int i=0; i< numberOfDoors+1; i++){
            if(i == 0){
                System.out.println("(0) Stay Here");
            }else{
                System.out.println("("+i+") Enter "+currentRoom.getDoorDescription(i-1));
            }
        }
    }

    private int chooseDoor(){
        int numberOfDoors = currentRoom.getNumberOfDoors();
        Scanner in = new Scanner(System.in);
        int choice;
        while(true){
            choice = in.nextInt();
            if (choice>=0 && choice<numberOfDoors+1) {
                break;
            }else{
                System.out.println("Incorrect input, try again");
            }
        }
        return choice;

    }

    private void handleDoorChoice(int choice){
        if (choice != 0){
            System.out.println("You enter through the door");
            currentRoom = currentRoom.enterDoor(choice - 1);
        } else {
            System.out.println("You do nothing.");
        }
    }

    public void handleDoorChoices(){
        printDoorDescriptions();
        printChoices();
        int choice = chooseDoor();
        handleDoorChoice(choice);
    }
}
