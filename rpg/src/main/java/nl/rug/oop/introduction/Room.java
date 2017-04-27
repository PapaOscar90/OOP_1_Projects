package nl.rug.oop.introduction;

import java.util.ArrayList;

/**The object Room, contains nothing currently
 * Created by PhilO on 27-Apr-17.
 */


public class Room extends Inspectable {
    private final int roomNumber;
    private ArrayList<String> roomOptions = new ArrayList<String>();
    private ArrayList<Door> doorList = new ArrayList<Door>(); // TODO: Access doorList


    // Constructor gives room a number and passes description to the super
    public Room(String desc, int n){
        super(desc);
        roomNumber = n;
    }

    // Returns the room number
    public int getRoomNumber(){
        return roomNumber;
    }

    // Adds door objects to a list with their description and room number
    public void addDoor(String desc, int toRoom){
        doorList.add(new Door(desc,toRoom));
    }

    public void addOptions(String s){
        roomOptions.add(s);
    }

    // Returns number of options
    public int getNumberOfOptions(){
        return roomOptions.size();
    }

    // Returns the option in list index n
    public String getOption(int n){
        return roomOptions.get(n);
    }

    // Returns the number of doors
    public int getNumberOfDoors(){
        return doorList.size();
    }

    // Returns the room number the door leads to
    public int getToRoomNumber(int n){
        return doorList.get(n).toRoom();
    }

    // Returns description of the door inputted
    String getDoorDescription(int n){
        return doorList.get(n).inspect();
    }
}
