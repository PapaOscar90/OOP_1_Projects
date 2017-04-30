package nl.rug.oop.rpg;

/** An item abstract class
 * Created by PhilO on 30-Apr-17.
 */
abstract class Item extends Inspectable {
    String name;
    int price;

    // An item has a description
    public Item(String descr, String name, int price){
        super(descr);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
