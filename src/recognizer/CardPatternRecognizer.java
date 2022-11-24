package recognizer;

import java.util.Set;

import card.Card;
import pattern.CardPattern;
import pattern.IllegalPattern;

public abstract class CardPatternRecognizer {

	protected CardPatternRecognizer next;
	
	
	public CardPatternRecognizer(CardPatternRecognizer next) {
		this.next = next;
	}
	
	
	public CardPattern recognize(Set<Card> cards) {
		if (condition(cards)) {
			return getCardPattern(cards);
		}
		if (next != null) {
			return next.recognize(cards);
		}
		return new IllegalPattern();
	}
	
	
	protected abstract boolean condition(Set<Card> cards);
	protected abstract CardPattern getCardPattern(Set<Card> cards);
	
	
}
