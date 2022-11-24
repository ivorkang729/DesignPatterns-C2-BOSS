package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

import card.Card;
import card.Rank;
import card.Suit;

public class Deck {
	
	protected Stack<Card> stack = new Stack<>();
	
	
	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				stack.push(new Card(suit, rank));
			}
		}
	}
	
	
	public void shuffle() {
		Collections.shuffle(stack);
	}
	
	
	public Card deal() {
		return stack.pop();
	}
	
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	
	public String toString() {
		return String.join(" ", new ArrayList<Card>(stack).stream().map(Card::toString).collect(Collectors.toList()));
	}
	

}
