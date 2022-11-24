package pattern;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import card.Card;

public class Pair extends CardPattern {
	
	
	public Pair(Card card1, Card card2) {
		super("對子", card1, card2);
		Pair.validate(getCards().stream().collect(Collectors.toSet()));
	}
	
	
	public Pair(Set<Card> cards) {
		super("對子", cards.stream().toArray(Card[]::new));
		Pair.validate(cards);
	}
	
	
	@Override
	protected boolean isSameType(CardPattern o) {
		return o.getClass() == Pair.class;
	}
	
	
	@Override
	protected int compareToPattern(CardPattern o) {
		return this.cards.get(0).getRank().compareTo(o.getCards().get(0).getRank()); 
	}

	
	public static void validate(Set<Card> cards) {
		if (cards.size() != 2) {
			throw new IllegalArgumentException("對子必須是兩張牌");
		}
		
		List<Card> list = cards.stream().collect(Collectors.toList());
		Card card1 = list.get(0);
		Card card2 = list.get(1);
		if (card1.getRank() != card2.getRank()) {
			throw new IllegalArgumentException("對子必須是兩張數字相同的牌");
		}
	}
	
	
}
