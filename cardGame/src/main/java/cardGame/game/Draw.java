package cardGame.game;

import cardGame.model.AbstractDeck;
import cardGame.model.CompleteDeck;

import java.util.Observable;
import java.util.Observer;

/**
 * Represents a silly 'game' (if you can even call it that) that draws cards
 * until the deck is empty, then shuffles them all back in.
 */
public class Draw extends Observable implements Observer {

    private AbstractDeck deck;
    private int cardsFlippedCount;
    private FlippableCard previousCardFlipped;
    private FlippableCard currentCardFlipped;

    /**
     * Create a deck with all cards in Card
     */
    private static AbstractDeck makeDeck() {
        AbstractDeck deck = new CompleteDeck();
        deck.shuffle();
        return deck;
    }

    private void addObservers(){
        for (int i = 0; i < deck.size(); i++){
            deck.getFlippableCard(i).addObserver(this);
        }
    }

    /**
     * Create a new Draw with 12 cards, 6 pairs
     */
    public Draw() {
        deck = makeDeck();
        cardsFlippedCount = 0;
        addObservers();
    }

    /**
     * Getter for deck so it may be looked at without being changed
     */
    public AbstractDeck getDeck() {
        return deck;
    }

    public void checkPairs() {
        if (cardsFlippedCount % 2 == 0)
            if (previousCardFlipped.getCard().getFace() != currentCardFlipped.getCard().getFace()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                currentCardFlipped.flipCard();
                previousCardFlipped.flipCard();
                resetCardsFlippedCount();
            }
    }

    /**
     * Put all cards back into the deck and shuffle it
     */
    public void reset() {
        deck = makeDeck();
        setChanged();
        notifyObservers();
    }

    public int getCardsFlippedCount() {
        return cardsFlippedCount;
    }

    public void incrementCardsFlipped() {
        this.cardsFlippedCount++;
    }

    private void resetCardsFlippedCount(){
        this.cardsFlippedCount -= 2;
    }

    public FlippableCard getPreviousCardFlipped() {
        return previousCardFlipped;
    }

    public void setPreviousCardFlipped(FlippableCard previousCardFlipped) {
        this.previousCardFlipped = previousCardFlipped;
    }

    public FlippableCard getCurrentCardFlipped() {
        return currentCardFlipped;
    }

    public void setCurrentCardFlipped(FlippableCard currentCardFlipped) {
        this.currentCardFlipped = currentCardFlipped;
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
