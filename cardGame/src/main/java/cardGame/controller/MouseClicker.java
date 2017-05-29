package cardGame.controller;

import cardGame.game.Memory;
import cardGame.game.FlippableCard;
import cardGame.view.MemoryPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;


/**
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

    private void flipCard(int x, int y) {
        for (int i = 0; i < memory.getDeck().size(); i++){
            FlippableCard fp = memory.getDeck().getFlippableCard(i);
            if (x > fp.getPosX() &&
                    x < fp.getPosX() + panel.getCardWidth() &&
                    y > fp.getPosY() &&
                    y < fp.getPosY() + panel.getCardHeight()
                    ) {
                if (memory.isInvalidChoice()){
                    memory.getCurrentCardFlipped().flipCard();
                    memory.getPreviousCardFlipped().flipCard();
                    memory.setInvalidChoice(false);
                }
                if (!fp.isFlipped()){
                    fp.flipCard();
                    memory.incrementCardsFlipped();
                    if(memory.getCardsFlippedCount() % 2 == 1){
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
        //TODO: Use math to get card clicked via e.getX and Y and board size
        //TODO: Invoke a game logic to flip the card and check for pair.
        memory.checkPairs ();

    }

}
