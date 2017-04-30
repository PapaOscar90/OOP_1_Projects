package nl.rug.oop.rpg;

/**
 * An NPC.
 * // TODO: Add proper interaction
 * Created by saidf on 4/30/2017.
 */

public class NPC extends Inspectable implements Interactable {
    private int health;

    public NPC(String s, int h) {
        super(s);
        health = h;
    }


    public void interact(Player p) {
        System.out.println("You attempt to interact, but no code for this action exists as of this version of the game. Check back later!");
    }

}
