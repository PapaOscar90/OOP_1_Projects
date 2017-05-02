package nl.rug.oop.rpg;

import java.util.List;

/**
 * A class that implements the behaviour of a Bad Door
 * Created by saidf on 5/2/2017.
 */
public class BadDoor extends SpecialDoor {
    public BadDoor(String s) {
        super(s);
        wentThrough = false;
        usageNoticeReceived = false;

    }

    private boolean applyBadDoorEffects(Player p) {
        System.out.println("You feel like someone stabbed you from the inside,\n" +
                "and cough up some blood. \n" +
                "You loose 10 HP. ");
        p.setHealth(p.getHealth() - 10);
        if (p.getHealth() <= 0) {
            System.out.println();
            System.out.println("The door just killed you. You respawn back at the start with no gold.");
            p.respawn();
        }
        return true;
    }

    //Player goes through door and associated special door effects are applied.
    public void interact(Player p) {
        if (!p.getVisitedRoomsList().contains(roomBehindDoor)) {
            List<Door> newDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM);
            roomBehindDoor.setDoors(newDoors);
            roomBehindDoor.addDoor(this);
            wentThrough = applyBadDoorEffects(p);
        } else if (wentThrough && !usageNoticeReceived) {
            System.out.println("The door does not hurt you anymore.");
            usageNoticeReceived = true;
        }

        //Here we alternate between two descriptions based on whether the special door "leads back" (towards the starting room) or not.
        if (leadsBack) {
            setDescription(HelperClass.BAD_DOOR_DESCRIPTION);
            leadsBack = false;
        } else {
            setDescription(HelperClass.BAD_DOOR_DESCRIPTION + " (Leads back a room)");
            leadsBack = true;
        }

        // Here we switch 2 rooms between current room of player and room behind the special door
        Room currentRoom = p.getCurrentRoom();
        p.setCurrentRoom(roomBehindDoor);
        roomBehindDoor = currentRoom;
    }
}
