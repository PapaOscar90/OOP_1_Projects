package cardGame.view;

import cardGame.model.Card.FlippableCard;

import cardGame.model.Logic.Memory;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import java.util.Observer;
import java.util.Observable;

/**
 * View of Memory
 */
public class MemoryPanel extends JPanel implements Observer {

    private int cardWidth;
    private int cardHeight;
    
    private Memory memory;

    /**
     * Create a new MemoryPanel
     */
    public MemoryPanel(Memory memory) {
        this.memory = memory;
        memory.addObserver(this);
        setBackground(new Color(63, 126, 47));
        setVisible(true);
        setOpaque(true);
        cardWidth = (getWidth()-100)/4;
        cardHeight = (getHeight()-80)/3;
    }
    
    /**
     * Paint the area
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
     * Get the scaled width of cards.
     */
    private void updateCardWidth() {
        cardWidth = (getWidth()-100)/4;
    }
    
    /**
     * Get the scaled height of cards.
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
     * Paints the cards ("Deck") on the screen
     */
    private void paintDeck(Graphics g) {
        updateCardWidth();
        updateCardHeight();
        int cardNumber=0;
        int row, col;
        for(row = 0; row < 3; row++) {
            for(col=0; col <4; col++){
                FlippableCard fp = memory.getDeck().getFlippableCard(cardNumber);
                int posX = col * getWidth()/4 +10;
                int posY = row * getHeight()/3 +10;
                fp.setPosX(posX);
                fp.setPosY(posY);
                if(fp.isFlipped()){
                    g.drawImage(CardTextures.getTexture(fp.getCard()), posX, posY, getCardWidth(), getCardHeight(), this);
                }else {
                    g.drawImage(CardBackTextures.getTexture(CardBack.CARD_BACK_BLUE)
                            , posX, posY, getCardWidth(), getCardHeight(), this);
                }
                g.drawRect(posX, posY, getCardWidth(), getCardHeight());
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
     * Tell this MemoryPanel that the object it displays has changed
     */
    @Override
    public void update(Observable observed, Object message) {
        repaint();
    }

}
