package cardGame.model;

import cardGame.game.FlippableCard;

/**
 * A deck that has all possible cards
 */
public class CompleteDeck extends AbstractDeck {

    /**
     * Add all possible cards
     */

    FlippableCard fp;
    protected void addCards() {
        for(Card card : Card.values()) {
            fp = new FlippableCard(card);
            addOnTop(fp);
        }
    }
}
