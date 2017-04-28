package nl.rug.oop.rpg;

import java.util.Scanner;

/**RPG game
 * Created by PhilO on 27-Apr-17.
 */
public class Main {
    public static void main(String[] args){
        int input;
        // Test
        // Initializes the player, and places them in the first room
        // TODO: Make the room generation input from files or generate them from random premade sentences
        Player player = new Player("A dark room with a white and black door.");

        Scanner in = new Scanner(System.in);

        // While true just for debugging
        // TODO: Create a win condition or end on death
        while (true){
            printActions();
            input = in.nextInt();
            switch (input){
                case 0: System.out.println("You see: " + player.getRoom().inspect());
                        break;
                case 1: System.out.println("You look around for doors. You see:");
                        player.lookAtDoors();
                        break;
                default: System.out.println("Incorrect input");
            }
        }
    }

    // Temporary to display actions
    // TODO: Add system to know what actions are available. Expand this
    private static void printActions(){
        System.out.println("What do you want to do?");
        System.out.println("(0) Look around");
        System.out.println("(1) Look for a way out");
    }

}
