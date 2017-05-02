package nl.rug.oop.rpg;

/**
 * Created by saidf on 5/2/2017.
 */
public class TeleportationStone extends Item {

    public TeleportationStone(String descr, String name, int price){
        super(descr, name, price);
    }

    public void interact(Player p) {
        if (p.getCurrentRoom().equals(p.getStartingRoom())){
            System.out.println("You already are in the starting room!");
        }
        System.out.println("You teleport back to the starting room.");
        p.setCurrentRoom(p.getStartingRoom());
    }
}
