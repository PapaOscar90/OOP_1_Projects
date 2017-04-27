package nl.rug.oop.introduction;/*

RPG Game
Phil Oetinger & Said Faroghi
v0.1
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int input;

        // Construct the room
        Room room0 = new Room("A white room with a red door and black door.",0);
        room0.addOptions("Look Around");
        room0.addOptions("Look for a way out");
        room0.addDoor("A red door",1);
        room0.addDoor("A black door", 2);

        Scanner in = new Scanner(System.in);

        Player player = new Player(0);
        do{
            System.out.println("What do you want to do?");
            for (int i = 0; i<room0.getNumberOfOptions(); i++){
                System.out.println("(" + i + ") " + room0.getOption(i));
            }
            input = in.nextInt();
            switch (input){
                case 0: room0.inspect();
                break;
                case 1:
                    System.out.println("You look around for doors. You see:");
                    for (int i =0; i<room0.getNumberOfDoors(); i++){
                        System.out.println("("+i+ ") " + room0.getDoorDescription(i));
                    }
            }
        }while(input != -2);

    }

}