package cardGame.controller;

import cardGame.model.Logic.Memory;

import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * Button that shuffles all cards into the deck. It uses the Action API to 
 * perform its action which means that this is merely a default configuration 
 * for this button.
 */
public class ResetButton extends JButton {
    
    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Reset Timer");
    }
    
    /**
     * Create a reset button
     */
    public ResetButton(Memory memory) {
        super(new ResetAction(memory));
        setButtonProperties();
    }

}
