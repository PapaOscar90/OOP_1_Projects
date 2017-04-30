package nl.rug.oop.rpg;

/** A weapon abstract class
 * Created by PhilO on 30-Apr-17.
 */
abstract class Weapon extends Item {
    private int damage;
    // The weapon description goes to item, and the weapon has a damage rating
    public Weapon(String s, int damage){
        super(s);
        this.damage = damage;
    }
}
