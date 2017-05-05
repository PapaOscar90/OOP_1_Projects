package nl.rug.oop.rpg;

/**A class for an item that teleports you back to the starting room
 * Created by saidf on 5/2/2017.
 */
public class TeleportationStone extends Item {

    public TeleportationStone(String descr, String name, int price){
        super(descr, name, price);
    }

    //Moves player to starting room immediately, if not already in it
    public void interact(Player p) {
        if (p.getCurrentRoom().equals(p.getStartingRoom())){
            System.out.println("You already are in the starting room!");
        } else {
            System.out.println("You teleport back to the starting room.");
            p.setCurrentRoom(p.getStartingRoom());
        }

    }
}
