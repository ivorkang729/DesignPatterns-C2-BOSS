package base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import card.Card;
import card.Rank;
import card.Suit;
import utils.Utils;

public class Hand {
	
	protected List<Card> cards = new ArrayList<>();
	
	public void add(List<Card> card) {
		this.cards.addAll(card);
		removeNullThenSort();
	}
	
	
	public Set<Card> play(List<Integer> indexes){
		Set<Card> playCards = new HashSet<>();
		for (int index : indexes) {
			playCards.add(cards.get(index));
			cards.set(index, null);
		}
		removeNullThenSort();
		return playCards;
	}
	
	
	private void removeNullThenSort() {
		cards = cards.stream().filter(card -> card != null).sorted().collect(Collectors.toList());
	}
	
	
	public void print() {
		
		String indexLine = "";
		for (int i = 0; i < cards.size(); i++) {
			indexLine += Utils.rightPadding(String.valueOf(i), cards.get(i).toString().length() + 1, " ");
		}

		System.out.println(indexLine.trim());
		System.out.println(this.toString());
	}
	
	
	public String toString() {
		String result = "";
		for (int i = 0; i < cards.size(); i++) {
			result += cards.get(i).toString() + " ";
		}
		return result.trim();
	}
	
	
	public boolean hasClub3() {
		return cards.contains(new Card(Suit.C, Rank._3));
	}
	
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
}
