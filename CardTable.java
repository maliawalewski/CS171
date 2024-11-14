import java.util.ArrayList;


/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Malia Walewski Nathaniel Schrader */
/**
 * 
 * This class represents a table where a game is being played.
 * 
 * It implements the Table interface and is designed to work with Card and
 * CardPlayer objects.
 * 
 * <p>
 * Each table instance must keep track of the cards that players place on the
 * table
 * during the game. The number of places available has a fixed size
 * (<code>NUMBER_OF_PLACES</code>),
 * so we use a regular Java array to represent a CardTable's places field.
 * Each entry in this places array contains
 * the cards that were added to that place, which is a more dynamic structure
 * (we don't know
 * in advance how many cards will be added to this place!).
 * <p>
 * Therefore, each place
 * entry in this array will reference an ArrayList of Card objects.
 * array list inside of an array... linked lists
 * <p>
 * Here is how to declare the array of ArrayLists field <code>places</code>:
 * 
 * <p>
 * <code>
 * 		private ArrayList&lt;Card&gt;[] places = new ArrayList[NUMBER_OF_PLACES];  
 * </code>
 * <p>
 * 
 * Note that the Field Summary section below will only show you public fields,
 * but you must declare the required field places described above, which is
 * private.
 * You are also free to create additional fields in your class implementation,
 * if deemed necessary.
 * 
 */


public class CardTable implements Table<Card, CardPlayer> { 


	@SuppressWarnings("unchecked")
	private ArrayList<Card>[] places = new ArrayList[NUMBER_OF_PLACES];
	private int currentPlace;
	private int previousPlace;

	
	public CardTable() {
		for (int i = 0; i < NUMBER_OF_PLACES; i++) {
			places[i] = new ArrayList<Card>();
			places[i].add(new Card(0, -1));
		}

		currentPlace = 0;
	}

	// TODO: implement all required CardTable methods (you can add helper methods if
	// needed)
	// Adds a card to the current place on the table.
	public void addCardToPlace(Card card) {
		this.places[currentPlace].add(card);
		previousPlace = currentPlace;
		if (currentPlace != 3) {
			currentPlace += 1;
		} else {
			currentPlace = 0;
		}
	}

	// Returns the identifiers of the cards on places 1, 2, 3, and 4 on the table(in
	// that same order).
	public int[] getPlaces() {
		int[] identifiers = new int[NUMBER_OF_PLACES];
		for (int i = 0; i < NUMBER_OF_PLACES; i++) {
			identifiers[i] = this.places[i].get(this.places[i].size() - 1).identifier();
		}
		return identifiers;
	}

	/**
	 * Checks the places on the table to see if any player occupies a place and
	 * removes any cards that they played.
	 *
	 * @param player the player to check for occupying a place.
	 *               1. If there is another visible card in places other than the
	 *               current place whose rank is the same as the current
	 *               player’s card rank, then the player takes that card from the
	 *               table and adds both cards to their bank.
	 *               2. If none of the visible cards (in places other than the
	 *               current place)
	 *               have a rank that matches the current
	 *               player’s card, then this new card becomes the top card in the
	 *               current place
	 */

	// what does it mean for a player to occupy a place?
	// same hand?
	// check if each list of cards is the same as a hand?
	// public void checkPlaces(CardPlayer player) {
	// int[] placesIdentifiers = getPlaces();
	// int[] placesRanks = new int[NUMBER_OF_PLACES];

	// for (int i = 0; i < NUMBER_OF_PLACES ; i++) {
	// if (!this.places[i].isEmpty()) { //check to see if the place is empty first
	// placesRanks[i] = this.places[i].get(this.places[i].size()-1).getRank();
	// } else {
	// placesRanks[i] = -1;
	// }
	// }
	// for (int i = 0; i < NUMBER_OF_PLACES; i++) {

	// if(i == currentPlace || placesRanks[i] == -1 || placesRanks[currentPlace] ==
	// -1){
	// continue;
	// }else if (placesRanks[i] == placesRanks[currentPlace]){
	// System.out.println("Checking place " + i + " with identifier " +
	// placesIdentifiers[i]);
	// //adding new cards to player bank
	// Card matched = new
	// Card(this.places[i].get(this.places[i].size()-1).getRank(),
	// this.places[i].get(this.places[i].size()-1).getSuit());
	// Card current = new
	// Card(this.places[currentPlace].get(this.places[currentPlace].size()-1).getRank(),
	// this.places[currentPlace].get(this.places[currentPlace].size()-1).getSuit());
	// player.bank.add(matched);
	// player.bank.add(current);

	// //removing cards from places
	// this.places[i].remove(this.places[i].size()-1);
	// this.places[currentPlace].remove(this.places[currentPlace].size()-1);
	// System.out.println("Matched ranks: " + placesIdentifiers[i] + " (on table)
	// and " + placesIdentifiers[currentPlace] + " (" + player.name + "'s card)");
	// player.setPoints(player.getPoints() + 1);
	// }
	// }
	// }
	public void checkPlaces(CardPlayer player) {
		/**
		 * The player has already placed the card on the table. So the previous card is
		 * player's card.
		 */
		Card playerCard = (places[previousPlace].iterator().hasNext()
				? places[previousPlace].get(places[previousPlace].size() - 1)
				: null);
		int count = 0;
		for (int place = 0; place < NUMBER_OF_PLACES; place++) {
			Card current = (places[place].iterator().hasNext() ? places[place].get(places[place].size() - 1) : null);
			if (place != previousPlace && current != null && playerCard != null
					&& current.getRank() == playerCard.getRank()) {

				System.out.println("Matched ranks: " + current.identifier() + " (on table) and "
						+ playerCard.identifier() + " (" + player.name + "'s card)");
				player.setPoints(player.getPoints() + 1);

				// for each other match, remove the topmost place card from the table
				player.bank.add(places[place].remove(places[place].size() - 1));
				if (count == 0) {
					player.bank.add(places[previousPlace].remove(places[previousPlace].size() - 1));
					player.setPoints(player.getPoints() + 1);
				}
				count++;
				// places[previousPlace].get(places[previousPlace].size() - 1);
				// places[place].remove(places[place].size() - 1);
			}
		}

		player.setTurn(false);
	}
}
