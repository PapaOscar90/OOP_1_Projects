package cardGame.game;

import cardGame.model.AbstractDeck;
import cardGame.model.Deck;

import java.util.Observable;
import java.util.Observer;

/**
 * Represents a silly memory matching 'game'
 */
public class Memory extends Observable implements Observer {

    private AbstractDeck deck;
    private int cardsFlippedCount;
    private FlippableCard previousCardFlipped; //Last two cards flipped
    private FlippableCard currentCardFlipped;
    private boolean isInvalidChoice;

    /**
     * Create a deck with all cards in Card
     */
    private static AbstractDeck makeDeck() {
        AbstractDeck deck = new Deck();
        deck.shuffle();
        return deck;
    }

    private void addObservers(){
        for (int i = 0; i < deck.size(); i++){
            deck.getFlippableCard(i).addObserver(this);
        }
    }

    /**
     * Create a new Memory with 12 cards, 6 pairs
     */
    public Memory() {
        deck = makeDeck();
        cardsFlippedCount = 0;
        isInvalidChoice = false;
        addObservers();
    }

    /**
     * Getter for deck so it may be looked at without being changed
     */
    public AbstractDeck getDeck() {
        return deck;
    }

    //Sets invalid choice to true if the last two cards flipped have a different face
    public void checkPairs() {
        if (cardsFlippedCount % 2 == 0)
            if (previousCardFlipped.getCard().getFace() != currentCardFlipped.getCard().getFace()){
                setInvalidChoice(true);
            }
    }

    /**
     * Put all cards back into the deck and shuffle it
     */
    public void reset() {
        deck = makeDeck();
        cardsFlippedCount=0;
        isInvalidChoice=false;
        addObservers();
        setChanged();
        notifyObservers();
    }

    public int getCardsFlippedCount() {
        return cardsFlippedCount;
    }

    public void incrementCardsFlipped() {
        this.cardsFlippedCount++;
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

    public boolean isInvalidChoice() {
        return isInvalidChoice;
    }

    public void setInvalidChoice(boolean invalidChoice) {
        isInvalidChoice = invalidChoice;
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
