package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    // Stores the room object the player is in
    private Room currentRoom;
    private List<Room> visitedRoomsList;
    private List<Item> inventory;
    private Weapon weapon;
    private Room startingRoom;
    private int health;
    private int maxHealth;
    private int gold;

    // Player Constructor
    public Player(Room startingRoom, int health, Weapon weapon, int gold) {
        currentRoom = startingRoom;
        this.startingRoom = startingRoom;
        visitedRoomsList = new ArrayList<>();
        this.health = health;
        maxHealth = this.health;
        this.weapon = weapon;
        this.gold = gold;
        inventory  = new ArrayList<>();
    }

    // Returns the room object currently in
    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Updates the current room, and adds the room to rooms visited if it has not been visited
    public void setRoom(Room room) {
        currentRoom = room;
        if (!visitedRoomsList.contains(room)) {
            visitedRoomsList.add(room);
        }
    }

    public List<Room> getVisitedRoomsList() {
        return visitedRoomsList;
    }

    // Player looks at the doors
    private void seeDoors() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        for (int i = 0; i < numberOfDoors; i++) {
            System.out.println(currentRoom.getDoor(i).inspect());
        }
    }

    // Player considers which door to enter
    private void considerDoors() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        System.out.println("\nWhat would you like to do?");
        System.out.println("(0) Stay Here");
        for (int i = 0; i < numberOfDoors; i++) {
            System.out.println("(" + (i + 1) + ") Enter " + currentRoom.getDoor(i).inspect());
        }
    }

    // Player can choose a door
    private int chooseDoor() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        int choice = HelperClass.getValidChoice(0, numberOfDoors);
        return choice;
    }

    // Steps a player takes to choose a door
    private void enterDoor(int choice) {
        if (choice != 0) {
            System.out.println("You enter through the door");
            currentRoom.getDoor(choice - 1).interact(this);
        } else {
            System.out.println("You do nothing.");
        }
    }

    // This will list the NPCs that are in the room
    private void examineNpcs() {
        int numberOfNpcs = currentRoom.getNumberOfnpcs();
        System.out.println(":");
        for (int i = 0; i < numberOfNpcs; i++) {
            System.out.println("(" + i + ") " + currentRoom.getnpc(i).inspect());
        }
        System.out.println("Who will you interact with? (-1 = None)");
    }

    // Only allows an allowed choice for NPC, returns the choice
    private int chooseNpc() {
        int numberOfNpcs = currentRoom.getNumberOfnpcs();
        int choice = HelperClass.getValidChoice(-1, numberOfNpcs);
        return choice;
    }

    // Calls the interact with the valid choice
    private void interactWithNpc(int choice) {
        if (choice == -1) {
            System.out.println("You do nothing.");
        } else {
            currentRoom.interactWithNpc(choice, this);
        }
    }

    // The thought process a player takes to enter a door
    public void handleDoorChoices() {
        seeDoors();
        considerDoors();
        int choice = chooseDoor();
        enterDoor(choice);
    }

    // The thought process a player takes to interact with NPCs
    public void handleNpcChoices() {
        examineNpcs();
        int choice = chooseNpc();
        interactWithNpc(choice);
    }

    // Returns player health
    public int getHealth() {
        return health;
    }

    // Sets player health
    public void setHealth(int health) {
        this.health = health;
    }

    // Returns the player weapon
    public Weapon getWeapon() {
        return weapon;
    }

    // Sets the player weapon
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // Reduces the player health by int damage
    public void takeDamage(int damage) {
        health -= damage;
    }

    // Player deals damage to Enemy enemy with weapon's damage
    public void attack(Enemy enemy) {
        enemy.takeDamage(weapon.getDamage());
    }

    // Respawns player at start with normal health.
    public void respawn() {
        currentRoom = startingRoom;
        health = maxHealth;
        gold = 0;
    }

    // Returns player gold amount
    public int getGold() {
        return gold;
    }

    // Sets player gold
    public void setGold(int gold) {
        this.gold = gold;
    }

    // Adds to player's gold
    public void addGold(int gold) {
        this.gold += gold;
        if (gold > 0) {
            System.out.println("You received " + gold + " Gold");
        } else {
            System.out.println("You lost " + -(gold) + " Gold");
        }
    }

    public Item getInventoryItem(int index) {
        return inventory.get(index);
    }

    public void addInventoryItem(Item item) {
        inventory.add(item);
    }

    public void removeInventoryItem(int index) {
        inventory.remove(index);
    }

    public void setInventory(List<Item> items){
        inventory = new ArrayList<>(items);
    }
}
