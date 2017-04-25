package nl.rug.oop.introduction;

import java.lang.management.MemoryManagerMXBean;
import java.util.Scanner;

public class Main{
    // Return a new string that is reversed from the input arg.
    private static String reverseString(String arg){
        StringBuilder reverse = new StringBuilder();
        for(int idx = arg.length(); idx > 0; idx--){
            reverse.append(arg.charAt(idx - 1));
        }
        return reverse.toString();
    }

    public static void main(String[] args){
        for(String argument : args) {
            System.out.println(reverseString(argument));
        }
        Memory mem = new Memory();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(mem.canRemember(line)){
                System.out.println("Pffft, everyone knows that!");
            }else{
                System.out.println("You're so smart and intelligent!");
                mem.remember(line);
            }
        }
    }
}