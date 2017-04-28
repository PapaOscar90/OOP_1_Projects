package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**Door class, "points" to a new room.
 * Created by PhilO on 27-Apr-17.
 */
public class Door extends Inspectable{
    private Room goesTo;
    private List<String> roomDescriptionList;
   // private List<String> doorDescriptionList;
    private int random = new Random().nextInt(5);

    // The door "points" to a room.
    // TODO: Add description import from file maybe
    public Door(String s){
        super(s);
        roomDescriptionList = new ArrayList<>();
       // doorDescriptionList = new ArrayList<String>();

        roomDescriptionList.add("A dark room");
        roomDescriptionList.add("A large room");
        roomDescriptionList.add("A small room");
        roomDescriptionList.add("A massive room");
        roomDescriptionList.add("A bright room");

        randomDescription();

    }
    private void randomDescription(){
        goesTo = new Room(roomDescriptionList.get(random));
    }

    public Room interact(){
        return goesTo;
    }
}
