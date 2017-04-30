package nl.rug.oop.rpg;

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

    public int getDamage(){
        return minDamage + rng.nextInt(maxDamage - minDamage);
    }
}
