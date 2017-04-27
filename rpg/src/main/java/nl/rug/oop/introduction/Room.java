package nl.rug.oop.introduction;

/**The object Room, contains nothing currently
 * Created by PhilO on 27-Apr-17.
 */

// TODO: Add doors
public class Room extends Inspectable {
    private final int roomNumber;

    // Constructor gives room a number and passes description to the super
    public Room(String desc, int n){
        super(desc);
        roomNumber = n;
    }

    // Returns the room number
    public int getRoomNumber(){
        return roomNumber;
    }
}
