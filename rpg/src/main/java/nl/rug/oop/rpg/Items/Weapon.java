package nl.rug.oop.rpg.Items;

import nl.rug.oop.rpg.Player.Player;

import java.util.Random;

/** A weapon abstract class
 * Created by PhilO on 30-Apr-17.
 */
public class Weapon extends Item {
    private int minDamage;
    private int maxDamage;
    Random rng;

    public Weapon(String descr, String name, int price, int minDamage, int maxDamage){
        super(descr, name, price);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        rng = new Random();
    }

    // Returns a random number between min and max damage
    public int getDamage(){
        return minDamage + rng.nextInt(maxDamage - minDamage);
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    //Interacting with a weapon equips it.
    public void interact(Player p){
        p.getInventory().addInventoryItem(p.getWeapon());
        p.setWeapon(this);
        System.out.println("You equipped " + p.getWeapon().name + " as your weapon!");
    }


}
