import java.security.SecureRandom;

public class DeckOfCards {

	private Card[] deck;	 // array of card objects
	private int currentCard; // index of next card to be dealt (0-51)
	private static final int NUMBER_OF_CARDS = 51; 	// Constant number of cards
	private static final SecureRandom randomNumbers = new SecureRandom();	// random number generator
	
	// Constructor to fill deck of cards
	public DeckOfCards() {
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		deck = new Card[NUMBER_OF_CARDS];	// create an array of card objects
		currentCard = 0;	// first card dealt will be deck[0]
		
		// populate deck with cards
		for (int count = 0; count < deck.length; count++) {
			deck[count] = new Card.CardBuilder(faces[count % 13], suits[count / 13]).build();
		}
	}
	
	
	// shuffle deck of cards with one pass algorithm
	public void shuffle() {
		// next call to method dealCard should start ad deck[0] again
		currentCard = 0;
		
		// for each card, pick another random card (0-51) and swap them
		for (int first = 0; first < deck.length; first++) {
			 // select a random number between (0-51)
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			
			// swap current card with randomly selected card
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	
	// deal one Card
	public Card dealCard() {
		// determine whether Cards remain to be dealt
		if (currentCard < deck.length) {
			return deck[currentCard++];		// return current card in the array
		}
		else {
			return null;	// return null to indicate that all Cards were delt
		}
	}
}
