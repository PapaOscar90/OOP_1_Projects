package nl.rug.oop.rpg.NPC;

import nl.rug.oop.rpg.Utility.Inspectable;
import nl.rug.oop.rpg.Utility.Interactable;

import java.io.Serializable;

/**
 * An NPC.
 * Created by saidf on 4/30/2017.
 */

public abstract class NPC extends Inspectable implements Interactable {
    // All NPCs have a name, and health
    protected String name;
    protected int health;
    protected int maxHealth;

    // NPC Contructor, takes a description, name, and health for current and max
    public NPC(String descr, String name, int health) {
        super(descr);
        this.name = name;
        this.health = health;
        maxHealth = this.health;
    }

    // Returns String name
    public String getName() {
        return name;
    }

    // Returns int health
    public int getHealth() {
        return health;
    }

}
