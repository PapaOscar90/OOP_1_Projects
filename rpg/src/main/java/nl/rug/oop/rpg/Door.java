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
    public Door(String s) {
        super(s);
        roomBehindDoor = GameObjectFactory.generateRandomRoom(0);  // Room has zero doors at first, doors are generated when the player enters this room
    }

    public void interact(Player p, Room currentRoom) {
        List<Door> newDoors = GameObjectFactory.generateRandomDoors(HelperClass.DOORS_PER_ROOM);
        // TODO: Add the currentRoom to the newDoors list
        roomBehindDoor.setDoors(newDoors);
        p.setRoom(roomBehindDoor);
    }
}
