package cardGame.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Represents an action to reset the Logic
 */
public class ResetAction extends AbstractAction {

    private Memory memory;

    /**
     * Creates a new Logic action
     */
    public ResetAction(Memory memory) {
        super("Reset!");
        this.memory = memory;
    }

    /**
     * Resets the Logic
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        memory.reset();
    }
    
}
