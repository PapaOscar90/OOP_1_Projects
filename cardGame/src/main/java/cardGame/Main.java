/*
* Card Game
* v0.1
*
* Phil Oetinger
* Said Faroghi
* */


package cardGame;

import cardGame.View.WindowFrame;

import javax.swing.*;

public class Main{
    public static void main(String[] args){
        System.out.println("Hello World.");
        WindowFrame window = new WindowFrame();
        window.setVisible(true);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);

    }
}