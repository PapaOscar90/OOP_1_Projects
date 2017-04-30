package nl.rug.oop.rpg;

/** An item abstract class
 * Created by PhilO on 30-Apr-17.
 */
abstract class Item extends Inspectable {
    // An item has a description
    public Item(String s){
        super(s);
    }
}
