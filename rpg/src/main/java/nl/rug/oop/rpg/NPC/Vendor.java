package nl.rug.oop.rpg.NPC;

import nl.rug.oop.rpg.Utility.HelperClass;
import nl.rug.oop.rpg.Items.EnchantedStone;
import nl.rug.oop.rpg.Items.HealthPotion;
import nl.rug.oop.rpg.Items.Item;
import nl.rug.oop.rpg.Items.TeleportationStone;
import nl.rug.oop.rpg.Player.Player;

import java.util.ArrayList;
import java.util.List;

/** A Vendor class implementing a shop.
 * Created by saidf on 5/1/2017.
 */
public class Vendor extends NPC implements Shop {
    private static final long serialVersionUID = 00L;
    private List<Item> productList;
    private boolean neverShopped;

    public Vendor(String descr, String name, int health, List<Item> products){
        super(descr, name, health);
        productList = new ArrayList<>(products);
        neverShopped = true;
    }

    public void addProduct(Item product) {
        productList.add(product);
    }

    public Item getProduct(int product) {
        return productList.get(product);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }

    // When you buy the enchanted stone, this dialogue initiates
    private void vendorDialogue(){
        try {
            Thread.sleep(1000);
            System.out.println();
            System.out.println("The vendor eyes you, crestfallen, and says...");
            System.out.println();
            Thread.sleep(5000);
            System.out.println("\"Oh, you too? I guess I'm the only one who enjoys this place...\"");
            System.out.println();
            Thread.sleep(6000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // The process of selling a product
    public void sellProduct(int index, Player p) {
        Item Product = productList.get(index);
        int itemPrice = Product.getPrice();
        p.addGold(-itemPrice);
        System.out.println("You buy a " + Product.getName() + " for " + itemPrice + " Gold!");
        removeProduct(index);
        if (Product instanceof HealthPotion){
            addProduct(new HealthPotion());
        }
        if (Product instanceof EnchantedStone){
            p.setHasSuicideWeapon(true);
            vendorDialogue();
        }
        p.getInventory().addInventoryItem(Product);
    }

    // Makes sure the input choice is correct and the player has enough gold to purchase the product
    private int getValidProduct(int playerGold){
        int choice;
        while (true){
            choice = HelperClass.getValidChoice(0, productList.size());
            if (choice == productList.size()){
                // Exited the shop
                return choice;
            }
            int chosenItemPrice = getProduct(choice).getPrice();
            if (chosenItemPrice > playerGold){
                System.out.println("Sorry, you don't have enough Gold for that. Choose something else.");
            } else {
                break;
            }
        }
        return choice;
    }

    //Lists the items available for sale and attempts to transact. Continues until player exits.
    private void transactionProcess(Player p){
        while (true) {
            int playerGold = p.getGold();
            for (int i = 0; i < productList.size(); i++) {
                String itemName = productList.get(i).getName();
                int itemPrice = productList.get(i).getPrice();
                System.out.println("(" + i + ") " + itemName + " | " + itemPrice + " Gold |");
            }
            System.out.println("(" + productList.size() + ") Exit shop");
            System.out.println();
            System.out.println("Gold left: " + p.getGold());
            System.out.println();
            System.out.println("Pick the item you would like to buy:");
            int choice = getValidProduct(playerGold);
            if (choice == productList.size()) {
                return;
            }
            sellProduct(choice, p);
            System.out.println();
            System.out.println("Would you like to buy another item?");
            System.out.println();
        }
    }

    //Initiates the transaction process with some descriptions (+ dialogues) before and after.
    public void interact(Player p) {
        if (productList.size() == 0){
            System.out.println("You approach the " + name + " but he does not have anything for sale!");
            return;
        }
        System.out.println("You approach the " + name + " and he offers you these items on sale:");
        System.out.println();
        transactionProcess(p);
        if (neverShopped){
            System.out.println("The vendor gives you an object and says...");
            System.out.println();
            System.out.println("\"Here! Something to bring you back to this room quickly.\"");
            System.out.println();
            System.out.println("You received a Teleportation Stone!");
            System.out.println();
            p.getInventory().addInventoryItem(new TeleportationStone("A mystic stone that helps you teleport back to the starting room.", "Teleportation Stone",0 ));
            neverShopped = false;
        }
        System.out.println("You leave the shop.");
    }
}
