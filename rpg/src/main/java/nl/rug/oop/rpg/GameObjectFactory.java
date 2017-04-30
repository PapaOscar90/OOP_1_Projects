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
                "A dark and massive room with no visible ceiling. Columns descend from the abyss above you. In the distance you think you see more doors.",
                "A bright room, with what appear to be bio-luminescent jelly fish, but floating in the air above you. They give the room a bright bluish tint. ",
                "A room disturbingly quiet. The walls appear to be a sponge-like material that dempens sound. You feel that you would go crazy in a room like this if trapped here.",
                "A common room with normal walls and a normal ceiling.",
                "A room with a small fountain in the center. It would have been beuitful whenever it was made. Now it is just a ruin."
        ));
        doorDescriptionList = new ArrayList<>(Arrays.asList(
                "A white door with beautiful etchings of the sky",
                "a black door with a skull for a knocker",
                "a green door with vines and planets growing on it",
                "a fiery door with magical fire that does not burn its surroundings",
                "a blue door that seams to leak water"
        ));
        npcDescriptionList = new ArrayList<>(Arrays.asList(
                "A wandering spirit",
                "A grusome mangeled spirit. Must have suffered a terrible death.",
                "An imp"
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
