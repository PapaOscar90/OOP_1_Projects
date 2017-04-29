package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**The Room, extends from Inspectable
 * Created by PhilO on 27-Apr-17.
 */
public class Room extends Inspectable{
    private List<Door> doorsList;

    protected Room(String s){
        this(s, new ArrayList<>());
    }

    protected Room(String s, List<Door> doors){
        super(s);
        doorsList = new ArrayList<>(doors);
    }

    // Method to add a door, so that they can be different in each room
    public void addDoor(Door door){
        doorsList.add(door);
    }

    public void setDoors(List<Door> doors){
        doorsList = new ArrayList<>(doors);
    }

    public Door getDoor(int index){
        return doorsList.get(index);
    }
    // Returns size of door list for iterating through them
    public int getNumberOfDoors(){
        return doorsList.size();
    }

    // Returns a string of the description of the door
    public String getDoorDescription(int doorNumber){
        return doorsList.get(doorNumber).inspect();
    }

}
