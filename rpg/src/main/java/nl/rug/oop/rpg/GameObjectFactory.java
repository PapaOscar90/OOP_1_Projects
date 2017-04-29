package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**Class to generate game objects
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

    public static Room generateRandomRoom(int n){
        int randomRoomNumber = rng.nextInt(roomDescriptionList.size());
        return new Room(roomDescriptionList.get(randomRoomNumber), generateRandomDoors(n));
    }
}
