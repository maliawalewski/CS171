import java.util.ArrayList;
import java.util.Iterator;

/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Malia Walewski Nathaniel Schrader */

/**
 * A class that represents a card player.
 * 
 * 
 * For each card player instance, we should keep track of how many points
 * they earned in the game so far, as well as whether it is their turn or not.
 * Additionally, their hand and bank of cards should be stored in two
 * separate ArrayLists of Card objects.
 * 
 * <p>
 * A player's points, turn, and hand of cards should all be declared
 * private fields, whereas the bank of cards should be public, as follows:
 * <p>
 * <code>
 * 		private int points; 
 * 
 * 		private boolean turn; 
 * 
 * 		private ArrayList&lt;Card&gt; hand = new ArrayList&lt;Card&gt;(); 
 *
 * 		public ArrayList&lt;Card&gt; bank = new ArrayList&lt;Card&gt;();
 * </code>
 * <p>
 * 
 * Note that the Field Summary section below will only show you public fields,
 * but you must declare all the fields described above in your implementation of
 * this class,
 * including the private fields. You are free to create additional fields if
 * deemed necessary.
 * 
 * @param <Card> the type of card used in the game
 */

public class CardPlayer extends GeneralPlayer<Card> {

    private int points;
    private boolean turn;
    private ArrayList<Card> hand = new ArrayList<Card>();

    // Bank of the player's cards that is public
    public ArrayList<Card> bank = new ArrayList<Card>();

    // Default Constructor that creates new CardPlayer with name "Card Player"
    public CardPlayer() {
        super();
        this.points = 0;
        this.turn = false;
    }

    // Constructor that creates a new CardPlayer with input name
    public CardPlayer(String name) {
        super(name);
        this.points = 0;
        this.turn = false;
    }

    // returns number of points of player
    public int getPoints() {
        return points;
    }

    // sets the number of points player has earned
    public void setPoints(int points) {
        this.points = points;
    }

    // returns true if its players turn, false otherwise
    public boolean isTurn() {
        return turn;
    }

    // sets if its players turn, true if it is, false otherwise
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    // adds a card to a players hand
    public void addToHand(Card card) {
        this.hand.add(card);
    }

    // gets players hand of cards
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    // returns a string of the players hand of cards
    public String handToString() {
        String result = name + "'s hand has " + hand.size() + " cards: ";
        Iterator<Card> cardIter = hand.iterator();
        while (cardIter.hasNext()) {
            Card card = cardIter.next();
            int cardIdentifier = card.getRank() + card.getSuit() * 100; // correct identification number
            result += cardIdentifier + " ";
        }
        return result;
    }

    // returns a string of the players bank of cards
    public String bankToString() {
        String result = name + " bank has " + bank.size() + " cards: ";
        Iterator<Card> cardIter = bank.iterator();
        while (cardIter.hasNext()) {
            Card card = cardIter.next();
            int cardIdentifier = card.getRank() + card.getSuit() * 100; // correct identification number
            result += cardIdentifier;

            if (cardIter.hasNext()) {
                result += " ";
            }
        }
        return result;
    }

    // gets the top card of players hand and removes it, returning this card, or
    // null if no cards left
    // from play() in GeneralPlayer.java
    public Card play() {
        if (this.hand.iterator().hasNext()) {
            Card topCard = this.hand.iterator().next();
            this.hand.remove(topCard);
            return topCard;
        }
        return null;
    }

}
