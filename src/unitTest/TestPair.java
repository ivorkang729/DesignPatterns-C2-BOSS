package unitTest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import card.Card;
import pattern.CardPattern;
import pattern.Pair;
import pattern.Single;

public class TestPair {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void given_whenToString_thenGetStringName() {
//		System.out.println(new Pair(Card.build("C[4]"), Card.build("H[4]")).toString());
//		System.out.println(new Pair(Card.build("S[4]"), Card.build("D[4]")).toString());
//		System.out.println(new Pair(Card.build("D[K]"), Card.build("H[K]")).toString());
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void given_whenDifferentRank_thenThrowException() {
		new Pair(Card.build("C[4]"), Card.build("C[5]"));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void given_whenDifferentCardPattern_thenThrowException() {
		CardPattern single = new Single(Card.build("D[4]"));
		CardPattern pair = new Pair(Card.build("C[4]"), Card.build("H[4]"));
		pair.compareTo(single);
	}
	
	
	@Test
	public void givenPair2AndPair4_whenCompare_thenPair2LargerThenPair4() {
		Pair pair1 = new Pair(Card.build("H[2]"), Card.build("S[2]"));
		Pair pair2 = new Pair(Card.build("C[4]"), Card.build("D[4]"));
		assertTrue(pair1.compareTo(pair2) > 0);
	}
	
	

}
