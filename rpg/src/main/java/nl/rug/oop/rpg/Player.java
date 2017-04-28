package nl.rug.oop.rpg;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    // Stores the room object the player is in
    private Room currentRoom;
    private List<Room> RoomList = new ArrayList<Room>();


    // Constructor passes in a description of the first room
    // TODO: Create way to load rooms from file or generate random rooms
    public Player(String s){
        currentRoom = new Room(s);
        currentRoom.addDoor("A black door");
        currentRoom.addDoor("A white door");
        RoomList.add(currentRoom);
    }

    // Returns the room object currently in
    public Room getRoom(){
        return currentRoom;
    }

    // This is the action of looking for a way out. Prints by: (door number) Door description
    public void lookAtDoors(){
        int numberOfDoors = currentRoom.getNumberOfDoors();
        for (int i = 0; i < numberOfDoors; i++){
            System.out.println("("+i+")"+currentRoom.getDoorDescription(i));
        }

        System.out.println("\nWhat would you like to do?");
        for (int i=0; i< numberOfDoors+1; i++){
            if(i == 0){
                System.out.println("(0) Stay Here");
            }else{
                System.out.println("("+i+") Enter "+currentRoom.getDoorDescription(i-1));
            }
        }

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input>=0 && input<numberOfDoors) {
            currentRoom = currentRoom.enterDoor(input);
        }else{
            return;
        }
    }
}
