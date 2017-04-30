package nl.rug.oop.rpg;

/**
 * Created by PhilO on 30-Apr-17.
 */
public class Weapon extends Item {
    private int damage;

    // The weapon description goes to item, and the weapon has a damage rating
    public Weapon(String s){
        super(s);
    }
}
