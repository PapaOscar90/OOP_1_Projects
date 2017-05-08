package nl.rug.oop.rpg.Doors;

import nl.rug.oop.rpg.Utility.GameObjectFactory;
import nl.rug.oop.rpg.Utility.HelperClass;
import nl.rug.oop.rpg.Player.Player;
import nl.rug.oop.rpg.Utility.Room;

import java.util.List;

/**
 * Created by saidf on 5/2/2017.
 */
public class GoodDoor extends SpecialDoor {
    private static final long serialVersionUID = 46L;
    public GoodDoor(String s){
        super(s);
        wentThrough = false;
        usageNoticeReceived = false;
    }

    private boolean applyGoodDoorEffects(Player p){
        System.out.println("You hear a clinging sound in your backpack");
        p.addGold(50);
        return true;
    }

    //Player goes through door and associated special door effects are applied.
    public void interact(Player p) {
        if (!p.getVisitedRoomsList().contains(roomBehindDoor)) {
            List<Door> newDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM);
            roomBehindDoor.setDoors(newDoors);
            roomBehindDoor.addDoor(this);
            roomInfrontDoor = p.getCurrentRoom();
            wentThrough = applyGoodDoorEffects(p);
            p.addVisitedSpecialDoorList(this);
        } else if (wentThrough && !usageNoticeReceived){
            System.out.println("Ha! You passed through this door already, can't fool the system that easily.");
            usageNoticeReceived = true;
        }
        //Here we alternate between two descriptions based on whether the door "leads back" (towards the starting room) or not.
        if (leadsBack){
            p.setCurrentRoom(roomInfrontDoor);
            setDescription(HelperClass.GOOD_DOOR_DESCRIPTION);
            leadsBack = false;
        } else {
            p.setCurrentRoom(roomBehindDoor);
            setDescription(HelperClass.GOOD_DOOR_DESCRIPTION + " (Leads back a room)");
            leadsBack = true;
        }

        // Here we switch 2 rooms between current room of player and room behind the door
        p.setCurrentRoom(roomBehindDoor);
    }
}

