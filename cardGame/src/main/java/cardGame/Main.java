package cardGame;

import cardGame.controller.MouseClicker;
import cardGame.model.Logic.Memory;

import cardGame.view.MemoryPanel;

import cardGame.controller.ButtonBar;

import javax.swing.*;

import java.awt.Dimension;

/**
 * Runs the Logic. Although technically a controller this class can be found
 * more easily if it's not in that package
 */
public class Main {
    public static void main(String[] args) {
        Memory memory = new Memory();
        JFrame frame = new JFrame("Memory Card Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setJMenuBar(new ButtonBar(memory));
        MemoryPanel panel = new MemoryPanel(memory);
        new MouseClicker(memory, panel);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.pack();
        frame.setLocationRelativeTo (null); // Center on screen.
        frame.setVisible(true);
    }
}
