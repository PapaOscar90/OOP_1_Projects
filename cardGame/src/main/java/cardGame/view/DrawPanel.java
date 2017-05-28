package cardGame.view;

import cardGame.model.Card;

import cardGame.game.Draw;

import javax.swing.JPanel;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

import java.util.Observer;
import java.util.Observable;

/**
 * View of Draw
 */
public class DrawPanel extends JPanel implements Observer {

    private int cardWidth;
    private int cardHeight;
    
    private Draw draw;

    /**
     * Create a new DrawPanel
     */
    public DrawPanel(Draw draw) {
        this.draw = draw;
        draw.addObserver(this);
        setBackground(new Color(63, 126, 47));
        setVisible(true);
        setOpaque(true);
        cardWidth = (getWidth()-100)/4;
        cardHeight = (getHeight()-80)/3;
    }
    
    /**
     * Paint the areas in which deck and discard pile can be found
     */
    private void paintAreas(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawRect(0, 0, getWidth()-2, getHeight()-2);
        g.drawString("MEMORY", (getWidth()/2)-getSpacing(), 10);
        g.setColor(Color.BLACK);
    }
    
    /**
     * Get the scaled spacing between edges and cards
     */
    private int getSpacing() {
        return 20;
    }
    
    /**
     * Get the scaled width of cards. Default height is 600, default
     * width is 436, and cards are scaled depending on which dimension limits
     * their relative dimensions
     */
    private void updateCardWidth() {
        cardWidth = (getWidth()-100)/4;
    }
    
    /**
     * Get the scaled height of cards. Default height is 600, default
     * width is 436, and cards are scaled depending on which dimension limits
     * their relative dimensions
     */
    private void updateCardHeight() {
        cardHeight = (getHeight()-80)/3;
    }

    public int getCardWidth() {
        return cardWidth;
    }

    public int getCardHeight() {
        return cardHeight;
    }

    /**
     * Draw the deck
     */
    private void paintDeck(Graphics g) {
        updateCardWidth();
        updateCardHeight();
        int cardNumber=0;
        int row, col;
        for(row = 0; row < 3; row++) {
            for(col=0; col <4; col++){
                int posX = col * getWidth()/4 +10;
                int posY = row * getHeight()/3 +10;
                if(draw.getDeck().getFlippableCard(cardNumber).isFlipped()){
                    g.drawImage(CardTextures.getTexture(draw.getDeck().getFlippableCard(cardNumber).getCard()), posX, posY, getCardWidth(), getCardHeight(), this);
                }else {
                    g.drawImage(CardBackTextures.getTexture(CardBack.CARD_BACK_BLUE)
                            , posX, posY, getCardWidth(), getCardHeight(), this);
                }
                g.drawRect(posX, posY, getCardWidth(), getCardHeight());
                cardNumber++;
            }
        }
        //repaint();
    }


    
    /**
     * Paint the items that this class alone is responsible for.
     * 
     * This method is part of a template method that calls  
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintAreas(g);
        paintDeck(g);
    }
    
    /**
     * Tell this DrawPanel that the object it displays has changed
     */
    @Override
    public void update(Observable observed, Object message) {
        repaint();
    }

}
