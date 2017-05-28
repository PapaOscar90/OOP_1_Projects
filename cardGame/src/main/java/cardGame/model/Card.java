package cardGame.model;

import java.util.Observable;

/**
 * Represents the kinds of playing cards found in ubiquitous 54-card decks
 *
 * WARNING: enum types implement toString by default. This information is
 * used to load textures in view. If you override toString you may break
 * the texture loading mechanism.
 */
public enum Card {

    //Clubs
    ACE_CLUBS(Face.ACE, Suit.CLUBS),
    TWO_CLUBS(Face.TWO, Suit.CLUBS),
    THREE_CLUBS(Face.THREE, Suit.CLUBS),
    FOUR_CLUBS(Face.FOUR, Suit.CLUBS),
    FIVE_CLUBS(Face.FIVE, Suit.CLUBS),
    SIX_CLUBS(Face.SIX, Suit.CLUBS),
    ACE_CLUBS_2(Face.ACE, Suit.CLUBS),
    TWO_CLUBS_2(Face.TWO, Suit.CLUBS),
    THREE_CLUBS_2(Face.THREE, Suit.CLUBS),
    FOUR_CLUBS_2(Face.FOUR, Suit.CLUBS),
    FIVE_CLUBS_2(Face.FIVE, Suit.CLUBS),
    SIX_CLUBS_2(Face.SIX, Suit.CLUBS);

    
    /**
     * Represents the faces a card can have
     */
    public enum Face {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
    }
    
    /**
     * The colours a card can have
     */
    public enum Colour {
        BLACK;
    }
    
    /**
     * The suits a card can be in. Each of them has a colour.
     */
    public enum Suit {
        CLUBS (Colour.BLACK);
        
        private final Colour colour;
        
        /**
         * Create a new suit with the appropriate colour
         */
        private Suit(Colour colour) {
            this.colour = colour;
        }
        
        /**
         * Get the colour of this suit.
         */
        public Colour getColour() {
            return colour;
        }
    }
    
    private final Face face;
    private final Suit suit;
    private final Colour colour;
    
    /**
     * Create a new card with the given face and suit
     */
    private Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
        this.colour = suit.getColour();
    }
    
    /**
     * Joker constructor since Jokers don't belong to a suit
     */
    private Card(Face face, Colour colour) {
        this.face = face;
        this.suit = null;
        this.colour = colour;
    }
    
    /**
     * Get the face of this card
     */
    public Face getFace() {
        return face;
    }
    
    /**
     * Get the suit of this card (which might be null if getFace() is JOKER)
     */
    public Suit getSuit() {
        return suit;
    }
    
    /**
     * The colour of this card
     */
    public Colour getColour() {
        return colour;
    }
}


