package nl.rug.oop.rpg;

import java.util.Scanner;

/**RPG game
 * Created by PhilO on 27-Apr-17.
 */
public class Main {
    public static void main(String[] args){
        int input;

        Room room = new Room("A white room with a red door and a black door.");
        Player player = new Player(0);

        Scanner in = new Scanner(System.in);

        while (true){
            printActions();
            input = in.nextInt();
            switch (input){
                case 0: System.out.println("You see: " + room.inspect());
            }
        }
    }

    public static void printActions(){
        System.out.println("What do you want to do?");
        System.out.println("(0) Look around");
    }
}
