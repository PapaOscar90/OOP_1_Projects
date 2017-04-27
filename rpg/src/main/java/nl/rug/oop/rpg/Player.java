package nl.rug.oop.rpg;

/**The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    // Stores the room object the player is in
    private Room currentRoom;

    // Constructor passes in a description of the first room
    // TODO: Create way to load rooms from file or generate random rooms
    public Player(String s){
        currentRoom = new Room(s);
    }

    // Returns the room object currently in
    public Room getRoom(){
        return currentRoom;
    }
}
