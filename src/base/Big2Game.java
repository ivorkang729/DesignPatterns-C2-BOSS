package base;

import java.util.ArrayList;
import java.util.List;

import pattern.CardPattern;
import pattern.IllegalPattern;
import recognizer.CardPatternRecognizer;
import utils.Utils;

public class Big2Game {
	
	private List<Player> players = new ArrayList<>();
	private Deck deck;
	
	
	private CardPattern topPlay;
	private int topPlayerIndex;	// 0, 1, 2, 3
	
	private int roundIndex;
	private int turnIndex;
	
	private int playerIndex;	// 0, 1, 2, 3
	private int passCount;
	
	
	private CardPatternRecognizer cardPatternRecognizer;
	
	
	public Big2Game(List<Player> players, Deck deck, CardPatternRecognizer cardPatternRecognizer) {
		this.players = players;
		this.deck = deck;
		this.cardPatternRecognizer = cardPatternRecognizer;
	}
	
	
	public void start() {
		deck.shuffle();
		players.forEach(Player::nameSelf);
		deal();
		nextTurn();	
		gameOver();
	}
	
	
	private void deal() {
		do {
			players.forEach(player -> player.deal(deck));
		} while (!deck.isEmpty());
	}
	
	
	private void nextTurn() {
		if (roundIndex == 0 && turnIndex == 0) {
			// 第一回合第一輪
			Utils.println("新的回合開始了。");
			playerIndex = findPlayerWhoHasClob3();
			passCount = 0;
			topPlayerIndex = playerIndex;
			topPlay = null;	// 清空頂牌
			
			Player player = players.get(playerIndex);
			TurnMove turnMove = takeTurn(player);
			Utils.printf("玩家 %s 打出了 %s", player.getName(), turnMove.getCardPattern().toString());
			
			topPlay = turnMove.getCardPattern();
			
		}
		else if (roundIndex != 0 && turnIndex == 0) {
			// 非第一回合的第一輪
			Utils.println("新的回合開始了。");
			roundIndex ++;
			turnIndex = 0;
			playerIndex = topPlayerIndex;
			passCount = 0;
			topPlayerIndex = playerIndex;
			topPlay = null;	// 清空頂牌
			
			Player player = players.get(playerIndex);
			TurnMove turnMove = takeTurn(player);
			Utils.printf("玩家 %s 打出了 %s", player.getName(), turnMove.getCardPattern().toString());
			
			topPlay = turnMove.getCardPattern();
			
		}
		else {
			// 任何回合的第二輪(含)之後
			turnIndex ++;
			playerIndex = (playerIndex + 1) % 4;
			
			Player player = players.get(playerIndex);
			TurnMove turnMove = takeTurn(player);
			if (turnMove.isPass()) {
				Utils.printf("玩家 %s PASS", player.getName());
				passCount++;
			}
			else {
				passCount = 0;
				Utils.printf("玩家 %s 打出了 %s", player.getName(), turnMove.getCardPattern().toString());
				topPlayerIndex = playerIndex;
				topPlay = turnMove.getCardPattern();
			}
			
		}
		
		// PASS >= 3 ? 回合結束
		if (passCount >= 3) {
			roundIndex ++;
			turnIndex = 0;
		}
		else {
			turnIndex ++;
		}
		
		// 玩家將手上的牌打完了? 遊戲結束
		// 否則 下一輪
		if (isGameOver()){
			return;
		}
		else {
			nextTurn();
		}
	}
	
	
	private TurnMove takeTurn(Player player) {
		Utils.printf("輪到%s了", player.getName());
		System.err.println("頂牌 " + topPlay);
		
		boolean legal = false;
		TurnMove turnMove = null;
		while(!legal) {
			player.printHand();
			turnMove = player.play();
			if (roundIndex == 0 && turnIndex == 0) {	// 第一回合第一輪
				if (turnMove.isPass()) {
					Utils.println("你不能在新的回合中喊 PASS"); 
					turnMove.undo();
					continue;
				}
				CardPattern cardPattern = cardPatternRecognizer.recognize(turnMove.getPlayCards());
				if (cardPattern.getClass() == IllegalPattern.class) {
					Utils.println("此牌型不合法，請再嘗試一次。"); 
					turnMove.undo();
					continue;
				}
				if (!turnMove.hasClub3()) {
					Utils.println("此牌型未包含梅花3"); 
					turnMove.undo();
					continue;
				}
				turnMove.setCardPattern(cardPattern);
				legal = true;
			}
			else if (roundIndex != 0 && turnIndex == 0) {	// 非第一回合的第一輪
				if (turnMove.isPass()) {
					Utils.println("你不能在新的回合中喊 PASS"); 
					turnMove.undo();
					continue;
				}
				CardPattern cardPattern = cardPatternRecognizer.recognize(turnMove.getPlayCards());
				if (cardPattern.getClass() == IllegalPattern.class) {
					Utils.println("此牌型不合法，請再嘗試一次。"); 
					turnMove.undo();
					continue;
				}
				turnMove.setCardPattern(cardPattern);
				legal = true;
			}
			else {	// 任何回合的第二輪之後
				if (turnMove.isPass()) {
					legal = true;
					continue;
				}
				CardPattern cardPattern = cardPatternRecognizer.recognize(turnMove.getPlayCards());
				if (cardPattern.getClass() == IllegalPattern.class) {
					Utils.println("此牌型不合法，請再嘗試一次。"); 
					turnMove.undo();
					continue;
				}
				if (cardPattern.getClass() != topPlay.getClass()) {
					Utils.println("此牌型不同於頂牌牌型，請再嘗試一次。"); 
					turnMove.undo();
					continue;
				}
				if (cardPattern.compareTo(topPlay) < 0 ) {
					Utils.println("此牌型沒有比頂牌大，請再嘗試一次。"); 
					turnMove.undo();
					continue;
				}
				turnMove.setCardPattern(cardPattern);
				legal = true;
			}
		} 
		return turnMove;
	}
	
	
	
	
	
	
	
	private int findPlayerWhoHasClob3() {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).hasClub3()) {
				return i;
			}
		}
		throw new IllegalStateException("找不到有梅花三的玩家?!");
	}
	
	
	private boolean isGameOver() {
		return players.get(playerIndex).isHandEmpty();
	}
	
	
	private void gameOver() {
		Utils.println("遊戲結束，遊戲的勝利者為 " + players.get(topPlayerIndex).getName());
	}
	

}
