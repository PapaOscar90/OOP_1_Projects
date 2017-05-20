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
        setBackground(new Color(0x7E, 0x35, 0x4D));
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
        g.drawRect(0, 0, getWidth(), getHeight());
        g.drawString("Memory Game", getWidth() / 2, 10);
        g.setColor(Color.BLACK);
    }
    
    /**
     * Get the scaled spacing between edges and cards
     */
    private int getSpacing() {
        return 25;
    }
    
    /**
     * Get the scaled width of cards. Default height is 600, default
     * width is 436, and cards are scaled depending on which dimension limits
     * their relative dimensions
     */
    public int cardWidth() {
        return (60);
    }
    
    /**
     * Get the scaled height of cards. Default height is 600, default
     * width is 436, and cards are scaled depending on which dimension limits
     * their relative dimensions
     */
    public int cardHeight() {
        return (120);
    }
    
    /**
     * Draw the deck
     */
    private void paintDeck(Graphics g) {
        int row, col;
        for(row = 1; row <= 3; row++) {
            for(col = 1; col <= 3; col++){
                int posX = getSpacing() + row*65;
                int posY = getSpacing() + col*125;
                g.drawImage( CardBackTextures.getTexture(CardBack.CARD_BACK_BLUE)
                        , posX, posY, cardWidth(), cardHeight(), this);
                g.drawRect(posX, posY, cardWidth(), cardHeight());
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
