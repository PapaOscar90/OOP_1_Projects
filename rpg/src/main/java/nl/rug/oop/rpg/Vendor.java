package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/** A Vendor class implementing a shop.
 * Created by saidf on 5/1/2017.
 */
public class Vendor extends NPC implements Shop {
    private List<Item> productList;

    public Vendor(String descr, String name, int health){
        super(descr, name, health);
        productList = new ArrayList<>();
    }

    public void addProduct(Item product) {
        productList.add(product);
    }

    public Item getProduct(int product) {
        return productList.get(product);
    }

    public void setProducts(List<Item> products) {
        productList = new ArrayList<>(products);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }

    public void sellProduct(int index, Player p) {
        Item item = productList.get(index);
        int itemPrice = item.getPrice();
        p.addGold(-itemPrice);
        System.out.println("You buy a " + item.getName() + " for " + itemPrice + " Gold!");
        removeProduct(index);
        if (item instanceof HealthPotion){
            addProduct(new HealthPotion());
        }
        p.addInventoryItem(item);
    }

    private int getValidProduct(int playerGold){
        int choice;
        while (true){
            choice = HelperClass.getValidChoice(0, productList.size());
            if (choice == productList.size()){
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

    private void transactionProcess(Player p){
        while (true) {
            int playerGold = p.getGold();
            for (int i = 0; i < productList.size(); i++) {
                String itemName = productList.get(i).getName();
                int itemPrice = productList.get(i).getPrice();
                System.out.println("(" + i + ") " + itemName + "     Price: " + itemPrice + " Gold");
            }
            System.out.println("(" + productList.size() + ") Exit shop");
            System.out.println();
            System.out.println("Pick what item you would like to buy:");
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

    public void interact(Player p) {
        if (productList.size() == 0){
            System.out.println("You approach the " + name + " but he does not have anything for sale!");
            return;
        }
        System.out.println("You approach the " + name + " and he offers you these items on sale:");
        System.out.println();
        transactionProcess(p);
    }
}
