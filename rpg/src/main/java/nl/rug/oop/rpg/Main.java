package nl.rug.oop.rpg;

import java.util.Scanner;

/**RPG game
 * Created by PhilO on 27-Apr-17.
 */
public class Main {
    public static void main(String[] args){
        int input;

        Player player = new Player("A dark room with a white and black door.");

        Scanner in = new Scanner(System.in);

        // While true just for debugging
        // TODO: Create a win condition or end on death
        while (true){
            printActions();
            input = in.nextInt();
            switch (input){
                case 0: System.out.println("You see: " + player.getRoom().inspect());
            }
        }
    }

    // Temporary to display actions
    // TODO: Add system to know what actions are available.
    public static void printActions(){
        System.out.println("What do you want to do?");
        System.out.println("(0) Look around");
    }
}
