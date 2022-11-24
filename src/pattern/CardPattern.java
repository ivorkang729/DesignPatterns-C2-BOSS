package pattern;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import card.Card;

public abstract class CardPattern implements Comparable<CardPattern>{

	protected String name;
	
	protected List<Card> cards;
	
	
	public CardPattern(String name, Card... cards) {
		this.name = name;
		this.cards = Arrays.stream(cards).sorted().collect(Collectors.toList());
	}
	
	
	
	public List<Card> getCards(){
		return cards;
	}
	
	
	@Override
	public int compareTo(CardPattern o) {
		if (!isSameType(o)) {
			throw new IllegalArgumentException("只有相同種類的牌型之間可以比較大小");
		}
		return compareToPattern(o); 
	}
	
	
	public String toString() {
		return name + " " + String.join(" ", this.cards.stream().map(Card::toString).toArray(String[]::new));		
	}
	
	
	protected abstract boolean isSameType(CardPattern o);
	protected abstract int compareToPattern(CardPattern o);
	
}
