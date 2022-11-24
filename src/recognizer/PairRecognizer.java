package recognizer;

import java.util.Set;

import card.Card;
import pattern.CardPattern;
import pattern.Pair;
import pattern.Single;

public class PairRecognizer extends CardPatternRecognizer {

	
	public PairRecognizer(CardPatternRecognizer next) {
		super(next);
	}
	

	@Override
	protected boolean condition(Set<Card> cards) {
		try {
			Pair.validate(cards);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	protected CardPattern getCardPattern(Set<Card> cards) {
		return new Pair(cards);
	}

}
