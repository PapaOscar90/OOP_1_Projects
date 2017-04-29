package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**Creates randomly generated descriptions
 * Class to generate game objects
 * Created by saidf on 4/29/2017.
 */
public class GameObjectFactory {
    private static List<String> roomDescriptionList;
    private static List<String> doorDescriptionList;
    private static Random rng;

    static {
        roomDescriptionList = new ArrayList<>(Arrays.asList(
                "A dark room",
                "A bright room",
                "A large room",
                "A small room",
                "A massive room"
        ));
        doorDescriptionList = new ArrayList<>(Arrays.asList(
                "A white door",
                "A black door",
                "A green door",
                "A red door",
                "A blue door"
        ));
        rng = new Random();
    }

    // Generates n doors with random descriptions and returns them in a list
    // Makes sure no two doors have the same description. This is the initial creation method
    public static List<Door> generateRandomDoors(int n){
        List<String> tempDoorDescriptionList = new ArrayList<>(doorDescriptionList);
        List<Door> doorList = new ArrayList<>();
        while (n > 0 && !tempDoorDescriptionList.isEmpty()){
            int randomDoorNumber = rng.nextInt(tempDoorDescriptionList.size());
            doorList.add(new Door(tempDoorDescriptionList.get(randomDoorNumber)));
            tempDoorDescriptionList.remove(randomDoorNumber);
            n--;
        }
        return doorList;
    }

    // The other one if it is creating new doors for also keeping the old room in a door.
    public static List<Door> generateRandomDoors(int n, Room room){
        List<String> tempDoorDescriptionList = new ArrayList<>(doorDescriptionList);
        List<Door> doorList = new ArrayList<>();
        while (n > 0 && !tempDoorDescriptionList.isEmpty()){
            int randomDoorNumber = rng.nextInt(tempDoorDescriptionList.size());
            doorList.add(new Door(tempDoorDescriptionList.get(randomDoorNumber)));
            tempDoorDescriptionList.remove(randomDoorNumber);
            n--;
        }
        doorList.add(new Door("The door you came through.", room));
        return doorList;
    }

    // Generates a room with a random description and n amount of doors
    public static Room generateRandomRoom(int n){
        int randomRoomNumber = rng.nextInt(roomDescriptionList.size());
        return new Room(roomDescriptionList.get(randomRoomNumber), generateRandomDoors(n));
    }
}
