import java.util.Arrays;
import java.util.List;

import base.AiPlayer;
import base.Big2Game;
import base.Deck;
import base.MockDeck;
import base.Player;
import base.TestdataReader;
import recognizer.CardPatternRecognizer;
import recognizer.FullHouseRecognizer;
import recognizer.PairRecognizer;
import recognizer.SingleRecognizer;
import recognizer.StraightRecognizer;

public class Main {
	
	private static String path = "D:/Educations/2022_水球君_正式課程/C2_魔王題：大老二撲克牌遊戲/LAB_C2_魔王題：大老二撲克牌遊戲/test-data";

	public static void main(String[] args) {
//		TestdataReader testdataReader = new TestdataReader(path + "/normal-no-error-play1.in");
//		TestdataReader testdataReader = new TestdataReader(path + "/normal-no-error-play2.in");
		TestdataReader testdataReader = new TestdataReader(path + "/illegal-actions.in");
//		TestdataReader testdataReader = new TestdataReader(path + "/fullhouse.in");
//		TestdataReader testdataReader = new TestdataReader(path + "/always-play-first-card.in");
//		TestdataReader testdataReader = new TestdataReader(path + "/straight.in");
		
		List<Player> players = Arrays.asList(new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader));
		Deck deck = new MockDeck(testdataReader);
		CardPatternRecognizer recognizer = new SingleRecognizer(new PairRecognizer(new FullHouseRecognizer(new StraightRecognizer(null))));
		new Big2Game(players, deck, recognizer).start();
	}
	

}
