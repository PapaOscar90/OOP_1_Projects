package nl.rug.oop.rpg;

/** An item abstract class
 * Created by PhilO on 30-Apr-17.
 */
abstract class Item extends Inspectable {
    // Items have a description and price
    String name;
    int price;

    // Inputs a description, name, and price
    public Item(String descr, String name, int price){
        super(descr);
        this.name = name;
        this.price = price;
    }

    // Returns String name
    public String getName() {
        return name;
    }

    // Returns int price
    public int getPrice() {
        return price;
    }

    // Sets the name of the item
    public void setName(String name) {
        this.name = name;
    }

    // Sets the price of the item
    public void setPrice(int price) {
        this.price = price;
    }
}
