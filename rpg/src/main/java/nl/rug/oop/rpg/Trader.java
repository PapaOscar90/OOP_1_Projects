package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhilO on 30-Apr-17.
 */
public class Trader extends NPC implements Interactable {
    private List<Item> Inventory = new ArrayList<Item>();

    public Trader(String s) {
        super(s, 5);
    }
}
