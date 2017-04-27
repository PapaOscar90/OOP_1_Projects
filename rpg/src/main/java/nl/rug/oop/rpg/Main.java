package nl.rug.oop.rpg;

import java.util.Scanner;

/**
 * Created by PhilO on 27-Apr-17.
 */
public class Main {
    public static void main(String[] args){
        int input;

        Room room = new Room("A white room with a red door and a black door.");
        Player player = new Player(0);

        System.out.println("What do you want to do?");
        Scanner in = new Scanner(System.in);

        while (true){
            input = in.nextInt();
            switch (input){
                case 0: System.out.println("You see: " + room.inspect());
                default: System.out.println("You cannot do that.");
            }
        }
    }
}
