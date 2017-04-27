package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**The Room, extends from Inspectable
 * Created by PhilO on 27-Apr-17.
 */
public class Room extends Inspectable{
    private List<Door> doorsList = new ArrayList<Door>();

    protected Room(String s){
        super(s);
    }

    // Method to add doors, so that they can be different in each room
    // TODO: Add one door each call, with one argument.
    public void addDoor(String one, String two){
        doorsList.add(new Door(one));
        doorsList.add(new Door(two));
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
