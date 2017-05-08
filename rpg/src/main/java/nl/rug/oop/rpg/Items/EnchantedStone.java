package nl.rug.oop.rpg.Items;

import nl.rug.oop.rpg.Player.Player;

/** The game ending Item
 * Created by saidf on 5/2/2017.
 */
public class EnchantedStone extends Item {
    private static final long serialVersionUID = 51L;
    public EnchantedStone(String descr, String name, int price){
        super(descr, name, price);
    }
    public void interact(Player p){
        System.out.println("You tried shaking it, throwing it around, even stomping on it... \n" +
                "but it seems like it does nothing.");
    }
}
