package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saidf on 5/2/2017.
 */
public class Inventory implements Interactable {
    private List<Item> inventory;

    public Inventory(){
        inventory = new ArrayList<>();
    }
    public void setInventory(List<Item> items){
        inventory = new ArrayList<>(items);
    }
    public List<Item> getInventory(){
        return inventory;
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

    private void lookAtInventory(){
        System.out.println("You have these items: ");
        for (int i = 0; i < inventory.size(); i++){
            String itemName = getInventoryItem(i).getName();
            System.out.println("("+ i + ") " + itemName);
        }
        System.out.println();
        System.out.println("(" + inventory.size() + ") Exit inventory");
    }

    private void interactWithInventoryItem(Player p){
        System.out.println("Pick an item to interact with:");
        int choice = HelperClass.getValidChoice(0, inventory.size());
        if (choice == inventory.size()){
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
