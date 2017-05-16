package cardGame.game;

import cardGame.model.AbstractDeck;
import cardGame.model.CompleteDeck;
import cardGame.model.DiscardPile;

import java.util.Observable;
import java.util.Observer;

/**
 * TODO: Think of a game to implement.
 */
public class Draw extends Observable implements Observer {

    @Override
    public void update(Observable observable, Object message) {
        setChanged();
        notifyObservers();
    }

}
