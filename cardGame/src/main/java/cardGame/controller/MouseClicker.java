package cardGame.controller;

import cardGame.model.Card.FlippableCard;
import cardGame.view.MemoryPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;


/**
 * A mouseClicker class - handles the logic that happens if a mouse is clicked on the screen
 * Created by PhilO on 27-May-17.
 */
public class MouseClicker extends MouseInputAdapter {
    private Memory memory;
    private MemoryPanel panel;

    public MouseClicker(Memory memory, MemoryPanel panel) {
        this.memory = memory;
        this.panel = panel;

        panel.addMouseListener(this);
    }

    //This function detects whether the user has clicked on a card or not, and if so,
    //handle the logic associated with clicking that card
    private void flipCard(int x, int y) {
        for (int i = 0; i < memory.getDeck().size(); i++) {
            //Loop through each card to check whether it has been clicked
            FlippableCard fp = memory.getDeck().getFlippableCard(i);
            if (x > fp.getPosX() &&
                    x < fp.getPosX() + panel.getCardWidth() &&
                    y > fp.getPosY() &&
                    y < fp.getPosY() + panel.getCardHeight()
                    ) {
                if (memory.isInvalidChoice()) {
                    //If the last two cards flipped was invalid (aka do not match),
                    //they are flipped back
                    memory.getCurrentCardFlipped().flipCard();
                    memory.getPreviousCardFlipped().flipCard();
                    memory.setInvalidChoice(false);
                }
                if (!fp.isFlipped()) {
                    fp.flipCard();
                    memory.incrementCardsFlipped();
                    if (memory.getCardsFlippedCount() % 2 == 1) {
                        memory.setPreviousCardFlipped(fp);
                    } else {
                        memory.setCurrentCardFlipped(fp);
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        flipCard(event.getX(), event.getY());
        memory.checkPairs();
    }
}
