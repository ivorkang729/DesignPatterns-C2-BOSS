package pattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import card.Card;
import card.Rank;
import utils.Utils;

public class FullHouse extends CardPattern {
	
	public FullHouse(Card card1, Card card2, Card card3, Card card4, Card card5) {
		super("葫蘆", card1, card2, card3, card4, card5);
		FullHouse.validate(getCards().stream().collect(Collectors.toSet()));
	}
	
	
	public FullHouse(Set<Card> cards) {
		super("葫蘆", cards.stream().toArray(Card[]::new));
		FullHouse.validate(cards);
	}
	
	
	@Override
	protected boolean isSameType(CardPattern o) {
		return o.getClass() == FullHouse.class;
	}
	
	
	@Override
	protected int compareToPattern(CardPattern other) {
		Rank rank = getRankOfTripleCards(this);
		Rank rankOther = getRankOfTripleCards(other);
		return rank.compareTo(rankOther); 
	}
	
	
	public static void validate(Set<Card> cards) {

		if (cards.size() != 5) {
			throw new IllegalArgumentException("葫蘆必須是五張牌");
		}
		
		Map<Rank, Integer> map = from(cards);
		
		if (map.keySet().size() != 2) {
			throw new IllegalArgumentException("葫蘆必須只能有兩種數字");
		}
		
		Set<Integer> countSet = map.entrySet().stream().map(Entry::getValue).collect(Collectors.toSet());
		Set<Integer> expectedSet = new HashSet<>(Arrays.asList(2, 3)); 
		if (!countSet.equals(expectedSet)) {
			throw new IllegalArgumentException("葫蘆必須由三張數字相同的牌，和兩張數字相同的牌所構成");
		}
	}
	
	
	private static Map<Rank, Integer> from(Set<Card> cards){
		Map<Rank, Integer> map = new HashMap<>();
		for (Card card : cards) {
			if (map.get(card.getRank()) == null) {
				map.put(card.getRank(), 1);
			}
			else {
				map.put(card.getRank(), map.get(card.getRank()).intValue() + 1);
			}
		}
		return map;
	}
	
	
	/**
	 * 找出葫蘆內三張數字相同的牌的數字(Rank)
	 * */
	private Rank getRankOfTripleCards(CardPattern pattern) {
		Map<Rank, Integer> map = from(Utils.toSet(pattern.getCards()));
		Rank rank = map.entrySet().stream().filter(entry -> entry.getValue() == 3).map(Entry::getKey).findAny().orElse(null);
		return rank;
	}
	
	
	
}
