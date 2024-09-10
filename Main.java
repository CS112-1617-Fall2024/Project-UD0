/**
 * Driver program that creates standard 52-card deck (as Card array)
 * and prints out each card in deck.
 *
 * @author ???
 * @version ???
 */

public class Main {

	/* ALGORITHM
	*
	1. Generate 52 card deck into Card array
	- Iterate over all suits (SPADE, HEART, DIAMOND, CLUB)
	- Iterate over values from 1 to 13 (Ace to King)
	- Create a new Card object for each combination and store in the array
	2. Print deck (simple)
	- Loop through the array and print each card using its toString method
	*
	*/
	public static void main(String[] args) {
		/*** RUNNING TESTER ***/
		// Uncomment the line below to run CardTester:
		// CardTester.main(null);

		/*** DRIVER PROGRAM ***/
		// 1. Generate 52 card deck into Card array
		Card[] deck = new Card[52];
		int index = 0;

		// Populate the deck with all 52 cards
		for (char suit : new char[]{Card.SPADE, Card.HEART, Card.DIAMOND, Card.CLUB}) {
			for (int value = 1; value <= 13; value++) {
				deck[index++] = new Card(value, suit);
			}
		}

		// 2. Print deck
		System.out.println("Generated 52-card deck:");
		for (Card card : deck) {
			System.out.println(card);
		}
	}
}
