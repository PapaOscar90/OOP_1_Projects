package nl.rug.oop.rpg.Player;

import nl.rug.oop.rpg.Utility.HelperClass;
import nl.rug.oop.rpg.Utility.Interactable;
import nl.rug.oop.rpg.Items.HealthPotion;
import nl.rug.oop.rpg.Items.Item;
import nl.rug.oop.rpg.Items.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**An inventory to be used by Player
 * Created by saidf on 5/2/2017.
 */
public class Inventory implements Interactable, Serializable {
    private static final long serialVersionUID = 00L;
    private List<Item> inventory;

    public Inventory(){
        inventory = new ArrayList<>();
    }

    public Item getInventoryItem(int index) {
        return inventory.get(index);
    }

    public void addInventoryItem(Item item) {
        inventory.add(item);
    }

    public void removeInventoryItem(int index) {
        inventory.remove(index);
    }

    public int getSize(){
        return inventory.size();
    }

    //Prints the items in the inventory to the screen
    private void lookAtInventory(){
        System.out.println("You have these items: ");
        for (int i = 0; i < inventory.size(); i++){
            String itemName = getInventoryItem(i).getName();
            System.out.println("("+ i + ") " + itemName);
        }
        System.out.println();
        System.out.println("(" + inventory.size() + ") Exit inventory");
    }

    //Enables interaction with all the items in the inventory
    private void interactWithInventoryItem(Player p){
        System.out.println("Pick an item to interact with:");
        int choice = HelperClass.getValidChoice(0, inventory.size());
        if (choice == inventory.size()){
            //Exit option was selected
            return;
        }
        Item selectedItem = getInventoryItem(choice);
        System.out.println("What would you like to do with this item?");
        System.out.println();
        System.out.println("(0) Use");
        System.out.println("(1) Inspect");
        int choice2 = HelperClass.getValidChoice(0, 1);
        if (choice2 == 0){
            if (selectedItem instanceof Weapon || selectedItem instanceof HealthPotion){
                //Interaction with a weapon equips it, removing it from inventory
                //A health potion will be used up, so also removed
                removeInventoryItem(choice);
            }
            selectedItem.interact(p);
        } else {
            System.out.println(selectedItem.inspect());
        }
    }

    public void interact(Player p){
        lookAtInventory();
        interactWithInventoryItem(p);
    }
}
