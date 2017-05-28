package cardGame.controller;

import cardGame.game.Draw;
import cardGame.view.DrawPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by PhilO on 27-May-17.
 */
public class MouseClicker extends MouseInputAdapter {
    private Draw draw;
    private DrawPanel panel;

    public MouseClicker(Draw draw, DrawPanel panel){
        this.draw = draw;
        this.panel = panel;

        panel.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent event){
        int cardX,cardY;
        draw.getDeck().getFlippableCard(4).flipCard();
        //TODO: Use math to get card clicked via e.getX and Y and board size
        //TODO: Invoke a game logic to flip the card and check for pair.
        System.out.println("Hello World.");
        //draw.checkPairs();
    }

}
