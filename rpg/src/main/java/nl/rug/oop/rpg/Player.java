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
        currentRoom.addDoor("A black door", "A white door");
    }

    // Returns the room object currently in
    public Room getRoom(){
        return currentRoom;
    }

    // This is the action of looking for a way out. Prints by: (door number) Door description
    public void lookAtDoors(){
        for (int i = 0; i < currentRoom.getNumberOfDoors(); i++){
            System.out.println("("+i+")"+currentRoom.getDoorDescription(i));
        }
    }
}
