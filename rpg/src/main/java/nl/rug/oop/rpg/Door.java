package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**Door class, "points" to a new room.
 * Created by PhilO on 27-Apr-17.
 */
public class Door extends Inspectable{
    private Room goesTo;
    private List<String> descriptionList = new ArrayList<String>();
    private int random = new Random().nextInt(5);

    // The door "points" to a room.
    // TODO: Add description import from file maybe
    public Door(String s){
        super(s);
        descriptionList.add("A dark room");
        descriptionList.add("A large room");
        descriptionList.add("A small room");
        descriptionList.add(("A massive room"));
        randomDescription();
    }

    private void randomDescription(){
        goesTo = new Room(descriptionList.get(random));
    }
}
