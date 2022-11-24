package base;

import java.util.Set;

import card.Card;
import card.Rank;
import card.Suit;
import pattern.CardPattern;

public class TurnMove {
	
	private Player player;
	private boolean isPass = false;
	private Set<Card> playCards;
	private CardPattern cardPattern;
	
	
	public TurnMove(Player player, boolean isPass, Set<Card> playCards) {
		this.player = player;
		this.isPass = isPass;
		this.playCards = playCards;
	}


	public CardPattern getCardPattern() {
		return cardPattern;
	}


	public void setCardPattern(CardPattern cardPattern) {
		this.cardPattern = cardPattern;
	}




	public boolean isPass() {
		return isPass;
	}


	public Set<Card> getPlayCards() {
		return playCards;
	}
	

	public boolean hasClub3() {
		return playCards.contains(new Card(Suit.C, Rank._3));
	}
	
	public void undo() {
		player.undo(this);
	}	
	

}
