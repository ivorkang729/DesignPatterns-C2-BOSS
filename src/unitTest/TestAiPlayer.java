package unitTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import base.AiPlayer;
import base.Deck;
import base.MockDeck;
import base.Player;
import base.TestdataReader;
import base.TurnMove;
import card.Card;
import utils.Utils;

public class TestAiPlayer {
	
	String path = "D:/Educations/2022_水球君_正式課程/C2_魔王題：大老二撲克牌遊戲/LAB_C2_魔王題：大老二撲克牌遊戲/test-data";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void givenTestdata_whenDeal_thenPrintHand() {
		TestdataReader testdataReader = new TestdataReader(path + "/normal-no-error-play2.in");
		
		Deck deck = new MockDeck(testdataReader);
		List<Player> players = Arrays.asList(new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader));
		
		deck.shuffle();
		do {
			players.forEach(player -> {
				player.deal(deck);
			});
		} while(!deck.isEmpty());
		
		players.forEach(player -> {
			player.printHand();
		});
		
	}

	@Test
	public void givenTestdata_whenPlay_thenSuccess() {
		TestdataReader testdataReader = new TestdataReader(path + "/normal-no-error-play1.in");
		
		Deck deck = new MockDeck(testdataReader);
		List<Player> players = Arrays.asList(new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader)
				, new AiPlayer(testdataReader));
		
		deck.shuffle();
		players.forEach(player -> player.nameSelf());
		do {
			players.forEach(player -> {
				player.deal(deck);
			});
		} while(!deck.isEmpty());
		
		
		int i = 3;
		Player player = players.get(i % 4);
		//player.printHand();
		assertEquals("C[3] C[4] S[7] S[8] H[9] D[10] S[J] D[Q] H[Q] D[A] S[A] D[2] H[2]", player.handToString());
		TurnMove turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("C[3]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());
		
		i++;
		player = players.get(i % 4);
		assertEquals("C[5] D[5] C[6] D[6] S[6] D[8] C[9] D[9] S[10] D[J] H[J] C[K] C[A]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("C[5]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("S[3] H[4] S[4] S[5] H[6] H[7] C[8] C[10] C[Q] S[Q] S[K] H[A] C[2]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("S[5]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("D[3] H[3] D[4] H[5] C[7] D[7] H[8] S[9] H[10] C[J] D[K] H[K] S[2]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("C[7]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("C[4] S[7] S[8] H[9] D[10] S[J] D[Q] H[Q] D[A] S[A] D[2] H[2]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("D[10]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("D[5] C[6] D[6] S[6] D[8] C[9] D[9] S[10] D[J] H[J] C[K] C[A]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("C[K]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("S[3] H[4] S[4] H[6] H[7] C[8] C[10] C[Q] S[Q] S[K] H[A] C[2]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("H[A]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("D[3] H[3] D[4] H[5] D[7] H[8] S[9] H[10] C[J] D[K] H[K] S[2]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("S[2]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("C[4] S[7] S[8] H[9] S[J] D[Q] H[Q] D[A] S[A] D[2] H[2]", player.handToString());
		turnMove = player.play();
		assertEquals("PASS", turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("D[5] C[6] D[6] S[6] D[8] C[9] D[9] S[10] D[J] H[J] C[A]", player.handToString());
		turnMove = player.play();
		assertEquals("PASS", turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("S[3] H[4] S[4] H[6] H[7] C[8] C[10] C[Q] S[Q] S[K] C[2]", player.handToString());
		turnMove = player.play();
		assertEquals("PASS", turnMove.isPass() ? "PASS" : turnMove.getPlayCards());
		player.undo(turnMove);
		assertEquals("S[3] H[4] S[4] H[6] H[7] C[8] C[10] C[Q] S[Q] S[K] C[2]", player.handToString());

		i = 2;
		player = players.get(i % 4);
		assertEquals("D[3] H[3] D[4] H[5] D[7] H[8] S[9] H[10] C[J] D[K] H[K]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("D[3]"), Card.build("H[3]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());

		i++;
		player = players.get(i % 4);
		assertEquals("C[4] S[7] S[8] H[9] S[J] D[Q] H[Q] D[A] S[A] D[2] H[2]", player.handToString());
		turnMove = player.play();
		assertEquals(Utils.toSet(Arrays.asList(Card.build("D[Q]"), Card.build("H[Q]"))), turnMove.isPass() ? "PASS" : turnMove.getPlayCards());
		assertEquals("C[4] S[7] S[8] H[9] S[J] D[A] S[A] D[2] H[2]", player.handToString());
		player.undo(turnMove);
		assertEquals("C[4] S[7] S[8] H[9] S[J] D[Q] H[Q] D[A] S[A] D[2] H[2]", player.handToString());
		
	}


}
