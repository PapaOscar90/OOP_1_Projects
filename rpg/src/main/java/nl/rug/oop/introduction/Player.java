package nl.rug.oop.introduction;

/**The first pass of a character
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    // The current room the player is in
    private int inRoom;

    // Constructor with input of room to start in
    Player(int room){
        inRoom=room;
    }

    // Returns the room currently in
    public int getRoom(){
        return inRoom;
    }

    // Change the room currently in
    void updateRoom(int n){
        inRoom = n;
    }
}
