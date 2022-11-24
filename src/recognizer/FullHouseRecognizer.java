package recognizer;

import java.util.Set;

import card.Card;
import pattern.CardPattern;
import pattern.FullHouse;

public class FullHouseRecognizer extends CardPatternRecognizer {

	
	public FullHouseRecognizer(CardPatternRecognizer next) {
		super(next);
	}
	

	@Override
	protected boolean condition(Set<Card> cards) {
		try {
			FullHouse.validate(cards);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	protected CardPattern getCardPattern(Set<Card> cards) {
		return new FullHouse(cards);
	}

}
