package nl.rug.oop.rpg;

import java.util.List;

/**
 * Created by saidf on 5/2/2017.
 */
public class GoodDoor extends SpecialDoor {
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
    public void interact(Player p) {
        if (!p.getVisitedRoomsList().contains(roomBehindDoor)) {
            List<Door> newDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM, p.getCurrentRoom());
            roomBehindDoor.setDoors(newDoors);
            wentThrough = applyGoodDoorEffects(p);
        } else if (wentThrough && !usageNoticeReceived){
            System.out.println("Ha! You passed through this door already, can't fool the system that easily.");
            usageNoticeReceived = true;
        }
        p.setRoom(roomBehindDoor);
    }
}

