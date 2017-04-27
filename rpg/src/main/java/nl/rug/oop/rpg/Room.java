package nl.rug.oop.rpg;

/**
 * Created by PhilO on 27-Apr-17.
 */
public class Room extends Inspectable{
    private String descrip;
    private int roomNumber;

    public Room(String s){
        descrip = s;
    }

    public String inspect(){
        return descrip;
    }
}
