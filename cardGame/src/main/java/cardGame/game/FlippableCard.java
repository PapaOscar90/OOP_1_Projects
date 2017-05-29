package cardGame.game;

import cardGame.model.Card;

import java.util.Observable;

/**
 * Created by saidf on 5/28/2017.
 */
public class FlippableCard extends Observable {

    private Card card;
    private boolean isFlipped;
    private int posX;
    private int posY;

    public FlippableCard(Card card){
        this.card = card;
        isFlipped = false;
    }

    public Card getCard() {
        return card;
    }

    public void flipCard(){
        if (this.isFlipped){
            this.isFlipped = false;
        }else{
            this.isFlipped = true;
        }
        setChanged();
        notifyObservers();
    }

    public Boolean isFlipped(){
        return isFlipped;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
