package unitTest;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import card.Card;
import pattern.FullHouse;
import pattern.IllegalPattern;
import pattern.Pair;
import pattern.Single;
import recognizer.CardPatternRecognizer;
import recognizer.FullHouseRecognizer;
import recognizer.PairRecognizer;
import recognizer.SingleRecognizer;
import utils.Utils;

public class TestCardPatternRecognizer {
	
	private static CardPatternRecognizer recognizer;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		recognizer = new SingleRecognizer(new PairRecognizer(new FullHouseRecognizer(null)));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testSingle () {
		Set<Card> cards = Utils.toSet(new Card[] {Card.build("C[10]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), Single.class));
		
		cards = Utils.toSet(new Card[] {Card.build("D[Q]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), Single.class));
	}
	

	@Test
	public void testPair () {
		Set<Card> cards = Utils.toSet(new Card[] {Card.build("C[10]"), Card.build("H[10]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), Pair.class));
		
		cards = Utils.toSet(new Card[] {Card.build("S[5]"), Card.build("D[5]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), Pair.class));
	}
	

	@Test
	public void testFullHouse () {
		Set<Card> cards = Utils.toSet(new Card[] {Card.build("C[10]"), Card.build("D[10]"), Card.build("H[10]"), Card.build("S[J]"), Card.build("C[J]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), FullHouse.class));
	}

	
	@Test
	public void testInvalid () {
		Set<Card> cards = Utils.toSet(new Card[] {Card.build("C[10]"), Card.build("H[A]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), IllegalPattern.class));
		
		cards = Utils.toSet(new Card[] {Card.build("C[10]"), Card.build("C[3]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), IllegalPattern.class));
		
		cards = Utils.toSet(new Card[] {Card.build("C[10]"), Card.build("H[9]"), Card.build("H[J]"), });
		assertTrue(Utils.isSameType(recognizer.recognize(cards), IllegalPattern.class));
		
		cards = Utils.toSet(new Card[] {Card.build("C[10]"), Card.build("D[10]"), Card.build("H[10]"), Card.build("S[J]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), IllegalPattern.class));
		
		cards = Utils.toSet(new Card[] {Card.build("C[10]"), Card.build("D[10]"), Card.build("H[10]"), Card.build("S[10]"), Card.build("C[J]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), IllegalPattern.class));
		
		cards = Utils.toSet(new Card[] {Card.build("C[10]"), Card.build("D[10]"), Card.build("H[10]"), Card.build("S[J]"), Card.build("C[J]"), Card.build("D[J]")});
		assertTrue(Utils.isSameType(recognizer.recognize(cards), IllegalPattern.class));
	}

}
