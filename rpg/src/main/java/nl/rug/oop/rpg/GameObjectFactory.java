package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

/**
 * Creates randomly generated descriptions
 * Class to generate game objects
 * Created by saidf on 4/29/2017.
 */
public class GameObjectFactory {
    // Contains lists for random generation of rooms, doors, and NPCs
    private static List<String> roomDescriptionList;
    private static List<String> doorDescriptionList;
    private static List<Function<Void, NPC>> npcGeneratorList;
    private static Random rng;

    static {
        roomDescriptionList = new ArrayList<>(Arrays.asList(
                "A dark and massive room with no visible ceiling. Columns descend from the abyss above you.",
                "A bright room, with what appear to be bio-luminescent jelly fish, but floating in the air above you. They give the room a bright bluish tint. ",
                "A room disturbingly quiet. The walls appear to be a sponge-like material that dampens sound. You feel that you would go crazy in a room like this if trapped here.",
                "A common room with normal walls and a normal ceiling.",
                "A room with a small fountain in the center. It would have been beautiful whenever it was made. Now it is just a ruin.",
                "A room that seems to be made entirely out of wood.",
                "A stinky room full of flies.",
                "A room with cracked walls. It looks like its about to collapse.",
                "A small room with walls that seem to sporadically change color",
                "A slightly damp, misty room that smells of depression",
                "A large circular room",
                "A long room, almost like a corridor",
                "A room that seems to be slightly tilted to one side",
                "A room that seems to have transparent walls and ceiling. Beyond the walls seems to lie a weird kind of void.",
                "A room painted entirely orange for no reason."
        ));
        doorDescriptionList = new ArrayList<>(Arrays.asList(
                "A white door",
                "A green door",
                "A red door",
                "A blue door",
                "A black door"
        ));
        // Creates a list of functions that returns NPC objects
        npcGeneratorList = new ArrayList<>(Arrays.asList(
                (Void) -> {
                    return new Enemy("A wandering Spirit. Looks menacing.", "Spirit", 20, 5, 10);
                },
                (Void) -> {
                    return new Enemy("A gruesome, mangled Spirit.  Must have suffered a terrible death. Looks very dangerous.", "Tenacious Spirit", 50, 10, 15);
                },
                (Void) -> {
                    return new Enemy("A reaper. The most malevolent of specters.", "Reaper", 150, 20, 30);
                },
                (Void) -> {
                    return new Friendly("A Spirit... doesn't look dangerous though.", "Friendly Spirit", 100);
                }
        ));
        rng = new Random(System.nanoTime());
    }

    // Generates n doors with random descriptions and returns them in a list
    // Makes sure no two doors have the same description.
    public static List<Door> generateRandomDoors(int n) {
        int random = rng.nextInt(100);
        int random2 = rng.nextInt(100);
        List<String> tempDoorDescriptionList = new ArrayList<>(doorDescriptionList);
        List<Door> doorList = new ArrayList<>();
        while (n > 0 && !tempDoorDescriptionList.isEmpty()) {
            int randomDoorNumber = rng.nextInt(tempDoorDescriptionList.size());
            doorList.add(new Door(tempDoorDescriptionList.get(randomDoorNumber)));
            tempDoorDescriptionList.remove(randomDoorNumber);
            n--;
        }
        if (random < HelperClass.SPECIAL_DOOR_SPAWN_CHANCE) {
            doorList.add(new BadDoor(HelperClass.BAD_DOOR_DESCRIPTION));
        }
        if (random2 < HelperClass.SPECIAL_DOOR_SPAWN_CHANCE) {
            doorList.add(new GoodDoor(HelperClass.GOOD_DOOR_DESCRIPTION));
        }
        return doorList;
    }

    /* Creates random doors with rooms, plus a door that goes back towards the start room
    * Note that the normal door leading back a room are NEWLY created in this function (aka they are not the doors that the player actually walked through,
    * but behave as such, and use this function),
    * while special doors implement a scheme where the door just gets renamed and the rooms interchanged, and no new door is created (using the previous function
    * generateRandomDoors(int n) and the special door's "interact()" code.)
    * Due to time constraints, we unfortunately could not settle for just one creation scheme in ALL doors.
    */
    public static List<Door> generateRandomDoors(int n, Room oldRoom) {
        List<Door> doorList = new ArrayList<>(generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM));
        doorList.add(new Door("The door leading back a room.", oldRoom));
        return doorList;
    }

    // Generates random NPCs based on a weight 0 - 99, corresponding to the chance of an NPC spawning.
    // It continues trying to add NPCs based on that chance, until weight is less than or equal to a random number 0-99.
    public static List<NPC> generateRandomNpcs(int weight) {
        int random = rng.nextInt(100);
        List<NPC> randomNpcList = new ArrayList<>();
        while (weight > random) {
            int randomNpcNumber = rng.nextInt(npcGeneratorList.size());
            //npcGeneratorList used here to add newly generated npcs to another list.
            //This is necessary because "npcGeneratorList.get(randomNpcNumber)" with a list of already created objects
            //will pass the reference around, and since there's no obvious way of copying an object in Java (to my knowledge)
            //using this functional method works.
            randomNpcList.add(npcGeneratorList.get(randomNpcNumber).apply(null));
            random = rng.nextInt(100);
        }
        return randomNpcList;
    }

    // Generates a room with a random description and n amount of doors and random npcs.
    public static Room generateRandomRoom(int n, int weight) {
        int randomRoomNumber = rng.nextInt(roomDescriptionList.size());
        return new Room(roomDescriptionList.get(randomRoomNumber), generateRandomDoors(n), generateRandomNpcs(weight));
    }
}
