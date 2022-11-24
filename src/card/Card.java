package card;

public class Card implements Comparable<Card>{
	
	private Suit suit = null;
	private Rank rank = null;
	
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	
	public Suit getSuit() {
		return suit;
	}

	
	public Rank getRank() {
		return rank;
	}


	@Override
	public String toString() {
		return suit.getName() + "[" + rank.getName() + "]";
	}
	
	
	public final static Card build(String expression) {
		// D[10] 、 C[2] 、 H[A]
		Suit suit = Suit.findByName(expression.substring(0, 1));
		Rank rank = Rank.findByName(expression.substring(expression.indexOf("[") +1, expression.indexOf("]")));
		return new Card(suit, rank);
	}


	@Override
	public int compareTo(Card o) {
		
		if (this.rank.getOrder() == o.rank.getOrder()) {
			return this.suit.getOrder() - o.suit.getOrder();
		}
		
		return this.rank.getOrder() - o.rank.getOrder();
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}
