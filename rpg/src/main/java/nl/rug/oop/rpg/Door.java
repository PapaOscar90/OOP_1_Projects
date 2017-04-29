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

    // Room has zero doors at first, doors are generated when the player enters this room
    public Door(String s, Room room) {
        super(s);
        roomBehindDoor = room;
    }

    // Player interacting with door, goes through door.
    public void interact(Player p) {
        List<Door> newDoors = GameObjectFactory.generateRandomDoors(HelperClass.DOORS_PER_ROOM, p.getRoom());
        roomBehindDoor.setDoors(newDoors);
        p.setRoom(roomBehindDoor);
    }

    public Room getRoom(){
        return  roomBehindDoor;
    }
}
