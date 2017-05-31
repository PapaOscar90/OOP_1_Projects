package cardGame.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * Panel with the buttons for the draw-class controllers
 */
public class ButtonBar extends JMenuBar {

    /**
     * Represents an action to reset the Logic
     */
    private class ResetAction extends AbstractAction {

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

    private class ResetButton extends JButton {

        /**
         * Initialise the properties of this button
         */
        private void setButtonProperties() {
            setVerticalTextPosition(AbstractButton.CENTER);
            setHorizontalTextPosition(AbstractButton.CENTER);
            setMnemonic(KeyEvent.VK_S);
            setToolTipText("Restart a New Game");
        }

        /**
         * Create a reset button
         */
        public ResetButton(Memory memory) {
            super(new ResetAction(memory));
            setButtonProperties();
        }

    }

    /**
     * Create a new buttonpanel with all the necessary buttons
     */
    public ButtonBar(Memory memory) {
        add(new ResetButton(memory));
    }

}
