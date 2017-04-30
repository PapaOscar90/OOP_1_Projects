package nl.rug.oop.rpg;

/**
 * Created by PhilO on 30-Apr-17.
 */
public class Spirit extends NPC implements Interactable {
    // Spirits can attack and deal damage, this is the amount of damage they do
    private int attack;

    public Spirit(String s){
        super(s, 1);
        attack = 1;
    }
}
