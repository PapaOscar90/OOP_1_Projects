package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Door class, "points" to a new room.
 * Created by PhilO on 27-Apr-17.
 */
public class Door extends Inspectable {
    private Room roomBehindDoor;
    // The door "points" to a room.
    // TODO: Add description import from file maybe
    public Door(String s) {
        super(s);
    }
    public Room interact() {
        return roomBehindDoor  = GameObjectFactory.generateRandomRoom(HelperClass.DOORS_PER_ROOM);
    }
}
