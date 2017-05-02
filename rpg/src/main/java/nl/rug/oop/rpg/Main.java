package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/** TODO: Allow spirits to immediatly attack when player enters room, adds small danger to each room
 *  RPG game
 *  Created by PhilO on 27-Apr-17.
 */
public class Main {

    // Prints the room actions
    private static void printRoomActions() {
        System.out.println("What do you want to do?");
        System.out.println("(0) Look around");
        System.out.println("(1) Look for a way out");
        System.out.println("(2) Look for company");
        System.out.println("(3) Check inventory");
        System.out.println("(4) Kill yourself");
        System.out.println();
        System.out.println("(5) Exit game (You lose all progress!)");
    }

    // Player looks around the room and sees what kind of room it is
    private static void lookAround(Player p) {
        System.out.println("You see: " + p.getCurrentRoom().inspect());
    }

    // Prints the types of door available
    private static void checkForDoors(Player p) {
        System.out.println("You look around for doors. You see:");
        p.handleDoorChoices();
    }

    // Prints the types of NPCs in the room
    private static void checkForNpcs(Player p) {
        System.out.print("You look if there's someone here.");
        if (p.getCurrentRoom().getNumberOfnpcs() == 0) {
            System.out.println("\nBut there is nobody here.");
            System.out.println();
            return;
        }
        System.out.println(" You see:");
        p.handleNpcChoices();
    }

    // Prints the items in the inventory
    private static void checkInventory(Player p){
        if (!p.isInventoryEmpty()){
            p.getInventory().interact(p);
        } else {
            System.out.println("Your inventory is empty");
            System.out.println();
        }

    }

    // Attempting suicide
    private static boolean commitSuicide(Player p) {
        return p.suicide();
    }

    // Prints current status of the player to the screen (gold, health, current weapon);
    private static void printStatus(Player p){
        int minWeaponDmg = p.getWeapon().getMinDamage();
        int maxWeaponDmg = p.getWeapon().getMaxDamage();
        String weaponName = p.getWeapon().getName();
        System.out.println("Status:");
        System.out.println("    Gold: " + p.getGold());
        System.out.println("    health: " + p.getHealth());
        System.out.println("    Current Weapon: " + weaponName + "    | Min Dmg: " + minWeaponDmg + " |  Max dmg: " + maxWeaponDmg + " |");
        System.out.println();
    }

    // The game loop.
    private static void gameLoop(Player player) {
        System.out.println();
        System.out.println("You awaken in an unknown place with only a rusty dagger in your hand. \n" +
                "The last thing you remember is... nothing, but you know that you must\n" +
                "somehow escape this place.");
        System.out.println();
        boolean exit = false;
        while (!exit) {
            System.out.println("Press Enter to continue...");
            HelperClass.getValidChoice();
            printStatus(player);
            printRoomActions();
            int choice = HelperClass.getValidChoice(0, 5);
            switch (choice) {
                case 0:
                    lookAround(player);
                    break;
                case 1:
                    checkForDoors(player);
                    break;
                case 2:
                    checkForNpcs(player);
                    break;
                case 3:
                    checkInventory(player);
                    break;
                case 4:
                    exit = commitSuicide(player);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }

    // Loads the game
    private static Player initializeGame(){
        List<Door> startingDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM);
        List<NPC> startingNpcs = GameObjectFactory.generateRandomNpcs(HelperClass.NPC_SPAWN_CHANCE);
        List<Item> products = new ArrayList<>();
        products.add(new Weapon("A steel sword. A must have over a rusty dagger.", "Steel sword", 100, 15, 30));
        products.add(new Weapon("A scythe... no one will stand a chance.", "Scythe", 300, 50, 100));
        products.add(new EnchantedStone("A glowing, red stone...", "Enchanted Stone", 1000));
        products.add(new HealthPotion());
        Vendor vendor = new Vendor("A Post-Material Merchant! He might have some useful things to buy.", "Post-Material Merchant", 100, products);
        Room startingRoom = new Room("A dark room. Filled with spiders and a cold chill in the air.", startingDoors, startingNpcs);
        startingRoom.addnpc(vendor);
        Weapon startingWeapon = new Weapon("A weapon of mass destruction.", "Rusty dagger", 10, 5, 10);
        return new Player(startingRoom, 50, startingWeapon, 25);
    }

    public static void main(String[] args) {
        Player player = initializeGame();
        gameLoop(player);
    }
}