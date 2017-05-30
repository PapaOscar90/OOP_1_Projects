package cardGame.controller;

import cardGame.game.Memory;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Represents an action to reset the game
 */
public class ResetAction extends AbstractAction {

    private Memory memory;

    /**
     * Creates a new game action
     */
    public ResetAction(Memory memory) {
        super("Reset!");
        this.memory = memory;
    }

    /**
     * Resets the game
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        memory.reset();
    }
    
}
