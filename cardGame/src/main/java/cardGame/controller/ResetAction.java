package cardGame.controller;

import cardGame.game.Memory;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Represents an action made to shuffle all cards back into the deck. Although
 * useless on an empty discard pile, this action is always available.
 */
public class ResetAction extends AbstractAction {

    private Memory memory;

    /**
     * Creates a new action to shuffle all cards back into the deck
     */
    public ResetAction(Memory memory) {
        super("Reset Timer!");
        this.memory = memory;
    }

    /**
     * Draws a card
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        memory.reset();
    }
    
}
