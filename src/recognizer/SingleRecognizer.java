package recognizer;

import java.util.Set;

import card.Card;
import pattern.CardPattern;
import pattern.Single;

public class SingleRecognizer extends CardPatternRecognizer {

	
	public SingleRecognizer(CardPatternRecognizer next) {
		super(next);
	}
	

	@Override
	protected boolean condition(Set<Card> cards) {
		try {
			Single.validate(cards);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	protected CardPattern getCardPattern(Set<Card> cards) {
		return new Single(cards);
	}

}
