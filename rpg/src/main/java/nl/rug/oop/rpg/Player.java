package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    private Room currentRoom;
    private List<Room> visitedRoomsList;
    private List<SpecialDoor> visitedSpecialDoorList;
    private Inventory inventory;
    private Weapon weapon;
    private Room startingRoom;
    private int health;
    private int maxHealth;
    private int gold;
    private Boolean hasSuicideWeapon;

    public Player(Room startingRoom, int health, Weapon weapon, int gold) {
        currentRoom = startingRoom;
        this.startingRoom = startingRoom;
        visitedRoomsList = new ArrayList<>();
        visitedRoomsList.add(currentRoom);
        visitedSpecialDoorList = new ArrayList<>();
        this.health = health;
        maxHealth = this.health;
        this.weapon = weapon;
        this.gold = gold;
        inventory = new Inventory();
        hasSuicideWeapon = false;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getStartingRoom() {
        return startingRoom;
    }

    // Updates the current room, and adds the room to rooms visited if it has not been visited
    public void setCurrentRoom(Room room) {
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

    // The thought process a player takes to enter a door
    public void handleDoorChoices() {
        seeDoors();
        considerDoors();
        int choice = chooseDoor();
        enterDoor(choice);
    }

    // This will list the NPCs that are in the room
    private void examineNpcs() {
        int numberOfNpcs = currentRoom.getNumberOfnpcs();
        for (int i = 0; i < numberOfNpcs; i++) {
            System.out.println("(" + i + ") " + currentRoom.getnpc(i).inspect());
        }
        System.out.println("Who will you interact with? (-1 = None)");
    }

    // Only allows an allowed choice for NPC, returns the choice
    private int chooseNpc() {
        int numberOfNpcs = currentRoom.getNumberOfnpcs();
        int choice = HelperClass.getValidChoice(-1, numberOfNpcs - 1);
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

    // The thought process a player takes to interact with NPCs
    public void handleNpcChoices() {
        examineNpcs();
        int choice = chooseNpc();
        interactWithNpc(choice);
    }

    // Reduces the player health by int damage
    public void takeDamage(int damage) {
        health -= damage;
    }

    // Player deals damage to Enemy enemy with weapon's damage
    public void attack(Enemy enemy) {
        enemy.takeDamage(weapon.getDamage());
    }

    public void correctSpecialDoors(){
        for (SpecialDoor door : visitedSpecialDoorList){
            if (door.isLeadsBack()){
                door.setLeadsBack(false);
                if (door instanceof GoodDoor){
                    door.setDescription(HelperClass.GOOD_DOOR_DESCRIPTION);
                } else {
                    door.setDescription(HelperClass.BAD_DOOR_DESCRIPTION);
                }
            }
        }
    }
    // Respawns player at start with normal health.
    public void respawn() {
        currentRoom = startingRoom;
        health = maxHealth;
        correctSpecialDoors();
        gold = 0;
    }

    public int getGold() {
        return gold;
    }

    // Adds to player's gold
    public void addGold(int gold) {
        this.gold += gold;
        if (gold > 0) {
            System.out.println("You received " + gold + " Gold");
        }
    }

    public List<SpecialDoor> getVisitedSpecialDoorList() {
        return visitedSpecialDoorList;
    }

    public void addVisitedSpecialDoorList(SpecialDoor door){
        visitedSpecialDoorList.add(door);
    }

    public Inventory getInventory() {
        return inventory;
    }

    // This function enables suicide if the suicide weapon is present.
    public boolean suicide() {
        if (hasSuicideWeapon) {
            System.out.println("The stone glows brightly in your pocket... \n" +
                    "You manage to pierce your chest with the blade and you... are no longer. \n" +
                    "Congratulations! You have found the exit.");
            return true;
        }
        System.out.println("Your blade cannot pierce your skin. You sit there confused and slightly saddened");
        return false;
    }

    public void setHasSuicideWeapon(Boolean hasSuicideWeapon) {
        this.hasSuicideWeapon = hasSuicideWeapon;
    }

    public boolean isInventoryEmpty() {
        if (inventory.getSize() == 0) {
            return true;
        }
        return false;
    }
}
