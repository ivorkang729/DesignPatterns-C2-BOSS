package pattern;

import java.util.Set;
import java.util.stream.Collectors;

import card.Card;

public class Single extends CardPattern {
	
	
	public Single(Card card) {
		super("單張", card);
		Single.validate(getCards().stream().collect(Collectors.toSet()));
	}
	
	
	public Single(Set<Card> cards) {
		super("單張", cards.stream().toArray(Card[]::new));
		Single.validate(cards);
	}
	
	
	@Override
	protected boolean isSameType(CardPattern o) {
		return o.getClass() == Single.class;
	}
	
	
	@Override
	protected int compareToPattern(CardPattern o) {
		return this.cards.get(0).compareTo(o.getCards().get(0)); 
	}

	
	public static void validate(Set<Card> cards) {
		if (cards.size() != 1) {
			throw new IllegalArgumentException("單張必須只有一張牌");
		}
	}

}
