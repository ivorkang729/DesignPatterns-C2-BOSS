package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import card.Card;
import utils.Utils;

public abstract class Player {
	
	protected String name;
	protected Hand hand;
	
	public Player() {
		this.hand = new Hand();
	}
	
	public void deal(Deck deck) {
		hand.add(Arrays.asList(deck.deal()));
	}
	
	public TurnMove play() {
		List<Integer> indexes = new ArrayList<>();
		for (String in : readInput().split(" ")) {
			if ("-1".equals(in)) {
				return new TurnMove(this, true, new HashSet<Card>());
			}
			else {
				indexes.add(Integer.valueOf(in));
			}
		}
		return new TurnMove(this, false, hand.play(indexes));
	}
	
	public void undo(TurnMove turnMove) {
		if (!turnMove.isPass()) {
			hand.add(Utils.toList(turnMove.getPlayCards()));
		}
	}	
	
	public void printHand() {
		hand.print();
	}
	
	public String getName() {
		return name;
	}
	
	public String handToString() {
		return hand.toString();
	}
	
	public boolean hasClub3() {
		return hand.hasClub3();
	}
	
	public boolean isHandEmpty() {
		return hand.isEmpty();
	}
	
	
	public abstract void nameSelf();
	protected abstract String readInput();

}
