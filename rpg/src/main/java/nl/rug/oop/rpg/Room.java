package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * The Room, extends from Inspectable
 * Created by PhilO on 27-Apr-17.
 */

public class Room extends Inspectable {
    // Room contains multiple doors
    private List<Door> doorsList;
    private List<NPC> npcList;

    protected Room(String s) {
        this(s, new ArrayList<>());
    }

    protected Room(String s, List<Door> doors) {
        this(s, doors, new ArrayList<>());
    }

    protected Room(String s, List<Door> doors, List<NPC> npcs) {
        super(s);
        doorsList = new ArrayList<>(doors);
        npcList = new ArrayList<>(npcs);
    }

    // Method to add a door
    public void addDoor(Door door) {
        doorsList.add(door);
    }

    public void setDoors(List<Door> doors) {
        doorsList = new ArrayList<>(doors);
    }

    // Returns the door at index of list
    public Door getDoor(int index) {
        return doorsList.get(index);
    }
    // Returns size of door list for iterating through them

    public int getNumberOfDoors() {
        return doorsList.size();
    }

    public void addnpc(NPC npc) {
        npcList.add(npc);
    }

    public void setnpcs(List<NPC> npcs) {
        npcList = new ArrayList<>(npcs);
    }

    public NPC getnpc(int index) {
        return npcList.get(index);
    }

    public int getNumberOfnpcs() {
        return npcList.size();
    }

    public void interactWithNpc(int npcIndex, Player p){
        NPC npc = npcList.get(npcIndex);
        npc.interact(p);
        if (npc.getHealth() <= 0){
            npcList.remove(npc);
        }
    }

}
