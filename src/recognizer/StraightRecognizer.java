package recognizer;

import java.util.Set;

import card.Card;
import pattern.CardPattern;
import pattern.Straight;

public class StraightRecognizer extends CardPatternRecognizer {

	
	public StraightRecognizer(CardPatternRecognizer next) {
		super(next);
	}
	

	@Override
	protected boolean condition(Set<Card> cards) {
		try {
			Straight.validate(cards);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	protected CardPattern getCardPattern(Set<Card> cards) {
		return new Straight(cards);
	}

}
