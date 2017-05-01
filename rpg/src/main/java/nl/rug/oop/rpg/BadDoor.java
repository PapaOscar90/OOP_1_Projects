package nl.rug.oop.rpg;

import java.util.List;

/**
 * Created by saidf on 5/2/2017.
 */
public class BadDoor extends SpecialDoor {
    private boolean wentThrough;
    private boolean usageNoticeRecieved;
    public BadDoor(String s){
        super(s);
        wentThrough = false;
        usageNoticeRecieved = false;
    }

    private boolean applyBadDoorEffects(Player p){
        System.out.println("You feel like someone stabbed you from the inside,\n" +
                "and cough up some blood. \n" +
                "You loose 10 HP. ");
        p.setHealth(p.getHealth() - 10);
        if (p.getHealth() <= 0){
            System.out.println();
            System.out.println("The door just killed you. You respawn back at the start with no gold.");
            p.respawn();
        }
        return true;
    }
    public void interact(Player p) {
        if (!p.getVisitedRoomsList().contains(roomBehindDoor)) {
            List<Door> newDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM, p.getCurrentRoom());
            roomBehindDoor.setDoors(newDoors);
            wentThrough = applyBadDoorEffects(p);
        } else if (wentThrough && !usageNoticeRecieved){
            System.out.println("The door does not hurt you anymore.");
            usageNoticeRecieved = true;
        }
        p.setRoom(roomBehindDoor);
    }
}
