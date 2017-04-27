package nl.rug.oop.introduction;/*

RPG Game
Phil Oetinger & Said Faroghi
v0.1
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int input = 0;
        Scanner in = new Scanner(System.in);

        Room start = new Room("A white room with a red door and black door.",0);
        Player player = new Player(0);
        do{
            System.out.println("What do you want to do?");
            System.out.println("(0) Look Around");
            input = in.nextInt();
            start.inspect(input);
        }while(input != -2);

    }
}