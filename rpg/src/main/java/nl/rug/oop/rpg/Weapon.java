package nl.rug.oop.rpg;

import java.util.Random;

/** A weapon abstract class
 * Created by PhilO on 30-Apr-17.
 */
public class Weapon extends Item {
    // Weapons contain a min and max amount of damage
    private int minDamage;
    private int maxDamage;
    Random rng;

    // Constructor, takes description, name, price, min and max damage and sets them
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
}
