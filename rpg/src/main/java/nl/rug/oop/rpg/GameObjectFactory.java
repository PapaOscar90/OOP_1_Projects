package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Creates randomly generated descriptions
 * Class to generate game objects
 * Created by saidf on 4/29/2017.
 */
public class GameObjectFactory {
    private static List<String> roomDescriptionList;
    private static List<String> doorDescriptionList;
    private static List<String> npcDescriptionList;
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
        npcDescriptionList = new ArrayList<>(Arrays.asList(
                "An orc",
                "Yet another orc",
                "A small orc",
                "A large orc",
                "An omnipotent orc"
        ));
        rng = new Random();
    }

    // Generates n doors with random descriptions and returns them in a list
    // Makes sure no two doors have the same description. This is the initial creation method
    public static List<Door> generateRandomDoors(int n) {
        List<String> tempDoorDescriptionList = new ArrayList<>(doorDescriptionList);
        List<Door> doorList = new ArrayList<>();
        while (n > 0 && !tempDoorDescriptionList.isEmpty()) {
            int randomDoorNumber = rng.nextInt(tempDoorDescriptionList.size());
            doorList.add(new Door(tempDoorDescriptionList.get(randomDoorNumber)));
            tempDoorDescriptionList.remove(randomDoorNumber);
            n--;
        }
        return doorList;
    }

    public static List<Door> generateRandomDoors(int n, Room oldRoom) {
        List<Door> doorList = new ArrayList<>(generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM));
        doorList.add(new Door("The door you came through.", oldRoom));
        return doorList;
    }

    // Generates random NPCs based on a weight 0 - 99, corresponding to the chance of an NPC spawning.
    // It continues trying to add NPCs based on that chance, until weight is less than or equal to a random number 0-99.
    public static List<NPC> generateRandomNpcs(int weight) {
        int random = rng.nextInt(100);
        List<NPC> npcList = new ArrayList<>();
        while (weight > random) {
            int randomNpcNumber = rng.nextInt(npcDescriptionList.size());
            npcList.add(new NPC(npcDescriptionList.get(randomNpcNumber)));
            random = rng.nextInt(100);
        }
        return npcList;
    }

    // Generates a room with a random description and n amount of doors and random npcs.
    public static Room generateRandomRoom(int n, int weight) {
        int randomRoomNumber = rng.nextInt(roomDescriptionList.size());
        return new Room(roomDescriptionList.get(randomRoomNumber), generateRandomDoors(n), generateRandomNpcs(weight));
    }
}
