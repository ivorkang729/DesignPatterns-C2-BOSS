package pattern;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import card.Card;
import card.Rank;

public class Straight extends CardPattern {
	
	public Straight(Card card1, Card card2, Card card3, Card card4, Card card5) {
		super("順子", card1, card2, card3, card4, card5);
		Straight.validate(getCards().stream().collect(Collectors.toSet()));
	}
	
	
	public Straight(Set<Card> cards) {
		super("順子", cards.stream().toArray(Card[]::new));
		Straight.validate(cards);
	}
	
	
	@Override
	protected boolean isSameType(CardPattern o) {
		return o.getClass() == Straight.class;
	}
	
	
	@Override
	protected int compareToPattern(CardPattern other) {
		Rank rank = getMaxRank(this);
		Rank rankOther = getMaxRank(other);
		return rank.compareTo(rankOther); 
	}
	
	
	/**
	 * 找出五張牌中數字最大的牌
	 * */
	private Rank getMaxRank(CardPattern pattern) {
		return pattern.getCards().stream().map(card -> card.getRank()).max(Comparator.comparing(Rank::getOrder)).get();
	}
	
	
	public static void validate(Set<Card> cards) {
		new _Validator().validate(cards);;
	}
	
	
	
	
	private static class _Validator {
		
//		Array:
//		Rank	=>	3	4	5	6	7	8	9	10	J	Q	K	A	2	3	4	5	6
//		index 	=>	0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16

		
		private static Map<Rank, List<Integer>> mapRank2Index = new HashMap<>();
		static {
			mapRank2Index.put(Rank._3, Arrays.asList(0, 13));
			mapRank2Index.put(Rank._4, Arrays.asList(1, 14));
			mapRank2Index.put(Rank._5, Arrays.asList(2, 15));
			mapRank2Index.put(Rank._6, Arrays.asList(3, 16));
			mapRank2Index.put(Rank._7, Arrays.asList(4));
			mapRank2Index.put(Rank._8, Arrays.asList(5));
			mapRank2Index.put(Rank._9, Arrays.asList(6));
			mapRank2Index.put(Rank._10, Arrays.asList(7));
			mapRank2Index.put(Rank._J, Arrays.asList(8));
			mapRank2Index.put(Rank._Q, Arrays.asList(9));
			mapRank2Index.put(Rank._K, Arrays.asList(10));
			mapRank2Index.put(Rank._A, Arrays.asList(11));
			mapRank2Index.put(Rank._2, Arrays.asList(12));
		}
		
		public void validate(Set<Card> cards) {
			if (cards.size() != 5) {
				throw new IllegalArgumentException("順子必須是五張牌");
			}
			
			int[] array = new int[17];
			for (Card card : cards) {
				mapRank2Index.get(card.getRank()).forEach(index -> {
					array[index] = 1;
				});
			}
			
			int count = 0;
			for (int value : array) {
				if (value == 0) {
					count = 0;
				}
				else {
					count ++;
				}
				if (count == 5) {
					break;
				}
			}
			
			if (count != 5) {
				throw new IllegalArgumentException("順子必須是連續數字的五張牌");
			}
			
		}
		
	}
	
	
	
	
}
