package cardGame.controller;

import cardGame.game.Memory;

import javax.swing.JMenuBar;

/**
 * Panel with the buttons for the draw-class controllers
 */
public class ButtonBar extends JMenuBar {

    /**
     * Create a new buttonpanel with all the necessary buttons
     */
    public ButtonBar(Memory memory) {
        add(new ResetButton(memory));
    }

}
