package nl.rug.oop.rpg;

import java.util.Random;

/** Friendly NPC
 * Created by saidf on 5/1/2017.
 */
public class Friendly extends NPC {
    private boolean gaveGold;
    private Random rng;
    public Friendly(String descr, String name, int health){
        super(descr, name, health);
        gaveGold = false;
        rng = new Random();
    }

    public void interact(Player p){
        if (gaveGold == false){
            System.out.println("After some words of encouragement, the " + name + " decides to give you some gold.");
            p.addGold(Math.round(100*rng.nextFloat()));
            gaveGold = true;
        } else {
            System.out.println("You already collected gold from this " + name);
        }
    }
}

