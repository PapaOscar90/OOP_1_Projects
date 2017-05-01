package nl.rug.oop.rpg;

/**
 * An NPC.
 * // TODO: Add proper interaction
 * Created by saidf on 4/30/2017.
 */

abstract class NPC extends Inspectable implements Interactable{
    String name;
    int health;
    int maxHealth;

    public NPC(String descr, String name, int health) {
        super(descr);
        this.name = name;
        this.health = health;
        maxHealth = this.health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

}
