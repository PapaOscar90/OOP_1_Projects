package nl.rug.oop.rpg;

import java.util.List;

/** An interface for a simple shop
 * Created by saidf on 5/1/2017.
 */

public interface Shop {
    void addProduct(Item item);
    Item getProduct(int index);
    void removeProduct(int index);
    void sellProduct(int index, Player p);
}


