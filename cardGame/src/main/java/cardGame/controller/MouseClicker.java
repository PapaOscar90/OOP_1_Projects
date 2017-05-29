package cardGame.controller;

import cardGame.game.Draw;
import cardGame.game.FlippableCard;
import cardGame.view.DrawPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by PhilO on 27-May-17.
 */
public class MouseClicker extends MouseInputAdapter {
    private Draw draw;
    private DrawPanel panel;
    public MouseClicker(Draw draw, DrawPanel panel) {
        this.draw = draw;
        this.panel = panel;

        panel.addMouseListener(this);
    }

    private void flipCard(int x, int y) {
        for (int i = 0; i < draw.getDeck().size(); i++){
            FlippableCard fp = draw.getDeck().getFlippableCard(i);
            if (x > fp.getPosX() &&
                    x < fp.getPosX() + panel.getCardWidth() &&
                    y > fp.getPosY() &&
                    y < fp.getPosY() + panel.getCardHeight()
                    ) {
                if (draw.isInvalidChoice()){
                    draw.getCurrentCardFlipped().flipCard();
                    draw.getPreviousCardFlipped().flipCard();
                    draw.setInvalidChoice(false);
                }
                if (!fp.isFlipped()){
                    fp.flipCard();
                    draw.incrementCardsFlipped();
                    if(draw.getCardsFlippedCount() % 2 == 1){
                        draw.setPreviousCardFlipped(fp);
                    } else {
                        draw.setCurrentCardFlipped(fp);
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
        draw.checkPairs ();

    }

}
