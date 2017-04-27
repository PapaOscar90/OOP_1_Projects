package nl.rug.oop.rpg;

/**Door class, "points" to a new room.
 * Created by PhilO on 27-Apr-17.
 */
public class Door extends Inspectable{
    private Room goesTo;

    // The door "points" to a room.
    // TODO: Add more rooms. The door can have a method that randomly generates a description and doors.
    public Door(String s){
        super(s);
        goesTo = new Room("A second room.");
    }
}
