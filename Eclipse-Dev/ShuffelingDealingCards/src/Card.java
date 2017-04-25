
public class Card {

	private final String face; // Face of the card (Ace, Deuce ...	)
	private final String suit; // Suit of the card (Hearts, Diamonds ...)
	
	// two-argument constructor initialized cards' face and suit
	private Card(CardBuilder builder) {
		this.face = builder.face;
		this.suit = builder.suit;
	}
	
	// Return toString representation of the card
	@Override
	public String toString() {
		return face + " of " + suit;
	}
	
	// Helper builder class
	public static class CardBuilder {
		private  String face;
		private  String suit;
		
		// Initialize the two mandatory fields
		public CardBuilder(String cardFace, String cardSuit) {
			this.face = cardFace;
			this.suit = cardSuit;
		}
		
		public Card build() {
			Card card = new Card(this);
			return card;
		}
	}
}
