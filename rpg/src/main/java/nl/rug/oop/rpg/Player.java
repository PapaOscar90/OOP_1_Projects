package nl.rug.oop.rpg;

/**The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    private int currentRoom;

    public Player(int room){
        currentRoom = room;
    }

    public int getRoom(){
        return currentRoom;
    }
}
