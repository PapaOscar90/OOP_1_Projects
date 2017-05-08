package nl.rug.oop.rpg.Items;

import nl.rug.oop.rpg.Player.Player;

/**A health Potion
 * Created by saidf on 5/1/2017.
 */
public class HealthPotion extends Item{
    private static final long serialVersionUID = 52L;
    public HealthPotion(){
        super("A health potion! This blue liquid restores full health.", "Health Potion", 50);
    }

    public void interact(Player p){
        p.setHealth(p.getMaxHealth());
        System.out.println("You drank the potion and it restores all your health!");
    }

}
