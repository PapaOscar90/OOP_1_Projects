package nl.rug.oop.rpg;

import java.util.List;

/**
 * RPG game
 * Created by PhilO on 27-Apr-17.
 */
public class Main {

    // Temporary to display actions
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

    private static void lookAround(Player p) {
        System.out.println("You see: " + p.getCurrentRoom().inspect());
    }

    private static void checkForDoors(Player p) {
        System.out.println("You look around for doors. You see:");
        p.handleDoorChoices();
    }

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

    private static void checkInventory(Player p){
        if (!p.isInventoryEmpty()){
            p.interactWithInventoryItem();
        } else {
            System.out.println("Your inventory is empty");
            System.out.println();
        }

    }

    private static boolean commitSuicide(Player p) {
        return p.suicide();
    }

    private static void printStatus(Player p){
        int minWeaponDmg = p.getWeapon().getMinDamage();
        int maxWeaponDmg = p.getWeapon().getMaxDamage();
        String weaponName = p.getWeapon().getName();
        System.out.println();
        System.out.println("Status:");
        System.out.println("    Gold: " + p.getGold());
        System.out.println("    health: " + p.getHealth());
        System.out.println("    Current Weapon: " + weaponName + "    | Min Dmg: " + minWeaponDmg + " |  Max dmg: " + maxWeaponDmg + " |");
        System.out.println();
    }

    // The game loop, entire game takes place here. This loop ends, game over.
    private static void gameLoop(Player player) {
        // TODO: Create a win condition or end on death
        boolean exit = false;
        while (!exit) {
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

    private static Player initializeGame(){
        List<Door> startingDoors = GameObjectFactory.generateRandomDoors(HelperClass.NEW_DOORS_PER_ROOM);
        List<NPC> startingNpcs = GameObjectFactory.generateRandomNpcs(HelperClass.NPC_SPAWN_CHANCE);
        Vendor vendor = new Vendor("A Post-Material Merchant! He might have some useful things to buy.", "Post-material Reality vendor", 100);
        Weapon sword = new Weapon("A steel sword. A must have over a rusty dagger.", "Steel sword", 200, 15, 30);
        Weapon scythe = new Weapon("A scythe... no one will stand a chance.", "Scythe", 500, 50, 100);
        EnchantedStone theEnd = new EnchantedStone("A glowing, red stone...", "Enchanted Stone", 1000);
        HealthPotion hp = new HealthPotion();
        vendor.addProduct(hp);
        vendor.addProduct(sword);
        vendor.addProduct(scythe);
        vendor.addProduct(theEnd);
        Room startingRoom = new Room("A dark room. Filled with spiders and a cold chill in the air.", startingDoors, startingNpcs);
        startingRoom.addnpc(vendor);
        Weapon startingWeapon = new Weapon("A weapon of mass destruction", "Rusty dagger", 10, 5, 10);
        return new Player(startingRoom, 100, startingWeapon, 2000);
    }

    public static void main(String[] args) {
        Player player = initializeGame();
        gameLoop(player);
    }
}