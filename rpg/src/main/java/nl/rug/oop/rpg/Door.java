package nl.rug.oop.rpg;

import java.util.List;

/**
 * Door class, "points" to a new room.
 * Created by PhilO on 27-Apr-17.
 */
public class Door extends Inspectable implements Interactable {
    private Room roomBehindDoor;

    // The door "points" to a room.
    public Door(String s) {
        super(s);
        roomBehindDoor = GameObjectFactory.generateRandomRoom(0, HelperClass.NPC_SPAWN_CHANCE);  // Room has zero doors at first, doors are generated when the player enters this room
    }

    public Door(String s, Room room) {
        super(s);
        roomBehindDoor = room;
    }

    // Player interacting with door, goes through door.
    public void interact(Player p) {
        if (!p.getVisitedRoomsList().contains(roomBehindDoor)) {
            List<Door> newDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM, p.getRoom());
            roomBehindDoor.setDoors(newDoors);
        }
        p.setRoom(roomBehindDoor);
    }

    public Room getRoomBehindDoor() {
        return roomBehindDoor;
    }
}
