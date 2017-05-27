package cardGame.view;

import cardGame.model.Card;

import cardGame.game.Draw;
import cardGame.game.MovableCard;

import javax.swing.JPanel;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import java.util.Observer;
import java.util.Observable;

/**
 * View of Draw
 */
public class DrawPanel extends JPanel implements Observer {

    private static final int CARD_SPACING = 2; //pixels
    private static final int Y_OFFSET = Card.values().length * CARD_SPACING;
    
    private Draw draw;
    
    private int movableX;
    private int movableY;
    
    /**
     * Get the number of pixels in X this card has been moved
     */
    public int getMovableX() {
        return movableX;
    }
    
    /**
     * Get the number of pixels in Y this card has been moved
     */
    public int getMovableY() {
        return movableY;
    }
    
    /**
     * Create a new DrawPanel
     */
    public DrawPanel(Draw draw) {
        this.draw = draw;
        draw.addObserver(this);
        setBackground(new Color(63, 126, 47));
        setVisible(true);
        setOpaque(true);
    }
    
    public boolean inDiscardArea(Point point) {
        return point.getX() > getWidth() / 2;
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
    public int cardWidth() {
        return (getWidth()-100)/4;
    }
    
    /**
     * Get the scaled height of cards. Default height is 600, default
     * width is 436, and cards are scaled depending on which dimension limits
     * their relative dimensions
     */
    public int cardHeight() {
        return (getHeight()-80)/3;
    }
    
    /**
     * Draw the deck
     */
    private void paintDeck(Graphics g) {
        int cardNumber=0;
        int row, col;
        for(row = 0; row < 3; row++) {
            for(col=0; col <4; col++){
                int posX = col * getWidth()/4 +10;
                int posY = row * getHeight()/3 +10;
                if(draw.getDeck().getCard(cardNumber).isFlipped()){
                    g.drawImage(CardTextures.getTexture(draw.getDeck().getCard(cardNumber)), posX, posY, cardWidth(), cardHeight(), this);
                }else {
                    g.drawImage(CardBackTextures.getTexture(CardBack.CARD_BACK_BLUE)
                            , posX, posY, cardWidth(), cardHeight(), this);
                }
                g.drawRect(posX, posY, cardWidth(), cardHeight());
                cardNumber++;
            }
        }
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
