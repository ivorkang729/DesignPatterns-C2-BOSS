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

public class TestSingle {

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
	public void test() {
		Single C10 = new Single(Card.build("C[10]"));
		Single D10 = new Single(Card.build("D[10]"));
		Single H10 = new Single(Card.build("H[10]"));
		Single S10 = new Single(Card.build("S[10]"));
		
		assertTrue(C10.compareTo(D10) < 0);
		assertTrue(D10.compareTo(H10) < 0);
		assertTrue(H10.compareTo(S10) < 0);
	}
	
	@Test
	public void test2() {
		Single C3 = new Single(Card.build("C[3]"));
		Single C5 = new Single(Card.build("C[5]"));
		Single CK = new Single(Card.build("C[K]"));
		Single C2 = new Single(Card.build("C[2]"));
		
		assertTrue(C3.compareTo(C5) < 0);
		assertTrue(C5.compareTo(CK) < 0);
		assertTrue(CK.compareTo(C2) < 0);
	}
	
	@Test
	public void test3() {
		Single C10 = new Single(Card.build("C[10]"));
		Single D10 = new Single(Card.build("D[10]"));
		Single H10 = new Single(Card.build("H[10]"));
		Single S10 = new Single(Card.build("S[10]"));
		
//		System.out.println(C10);
//		System.out.println(D10);
//		System.out.println(H10);
//		System.out.println(S10);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void givenDifferentCardPattern_whenCompare_thenThrowException() {
		CardPattern single = new Single(Card.build("C[4]"));
		CardPattern pair = new Pair(Card.build("C[4]"), Card.build("C[5]"));
		single.compareTo(pair);
	}
	
}
