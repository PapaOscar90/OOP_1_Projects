package nl.rug.oop.rpg.Utility;

import nl.rug.oop.rpg.Doors.Door;
import nl.rug.oop.rpg.NPC.NPC;
import nl.rug.oop.rpg.Player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Room, extends from Inspectable
 * Created by PhilO on 27-Apr-17.
 */

public class Room extends Inspectable {
    private static final long serialVersionUID = 44L;
    // Room contains multiple doors
    private List<Door> doorsList;
    private List<NPC> npcList;

    protected Room(String s) {
        this(s, new ArrayList<>());
    }

    protected Room(String s, List<Door> doors) {
        this(s, doors, new ArrayList<>());
    }

    public Room(String s, List<Door> doors, List<NPC> npcs) {
        super(s);
        doorsList = new ArrayList<>(doors);
        npcList = new ArrayList<>(npcs);
    }

    public void addDoor(Door door) {
        doorsList.add(door);
    }

    public void setDoors(List<Door> doors) {
        doorsList = new ArrayList<>(doors);
    }

    public Door getDoor(int index) {
        return doorsList.get(index);
    }

    public int getNumberOfDoors() {
        return doorsList.size();
    }

    public void addnpc(NPC npc) {
        npcList.add(npc);
    }

    public NPC getnpc(int index) {
        return npcList.get(index);
    }

    public int getNumberOfnpcs() {
        return npcList.size();
    }

    //More easily enables interactions with NPCs in the room
    public void interactWithNpc(int npcIndex, Player p) {
        NPC npc = npcList.get(npcIndex);
        npc.interact(p);
        if (npc.getHealth() <= 0) {
            npcList.remove(npc);
        }
    }

}
