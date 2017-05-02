package nl.rug.oop.rpg;

/** The game ending Item
 * Created by saidf on 5/2/2017.
 */
public class EnchantedStone extends Item {
    public EnchantedStone(String descr, String name, int price){
        super(descr, name, price);
    }
    public void interact(Player p){
        System.out.println("You tried shaking it, throwing it around, even stomping on it... \n" +
                "but it seems like it does nothing.");
    }
}
