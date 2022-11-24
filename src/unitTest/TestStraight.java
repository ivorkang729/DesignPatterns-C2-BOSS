package unitTest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import card.Card;
import pattern.CardPattern;
import pattern.FullHouse;
import pattern.Straight;

public class TestStraight {

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
	public void givenValidFullhouse_when_thenSuccess() {
		CardPattern pattern = new Straight(Card.build("C[3]")
											, Card.build("D[4]")
											, Card.build("H[5]")
											, Card.build("S[6]")
											, Card.build("C[7]"));
		

		pattern = new Straight(Card.build("C[K]")
											, Card.build("D[A]")
											, Card.build("H[2]")
											, Card.build("S[3]")
											, Card.build("C[4]"));
		

		pattern = new Straight(Card.build("C[J]")
											, Card.build("D[K]")
											, Card.build("H[Q]")
											, Card.build("S[2]")
											, Card.build("C[A]"));
		
//		System.out.println(pattern);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void givenInvalidFullhouse_when_thenThrowException() {
		CardPattern pattern = new Straight(Card.build("C[K]")
											, Card.build("D[A]")
											, Card.build("H[Q]")
											, Card.build("S[3]")
											, Card.build("C[4]"));
		
	}
	
	@Test
	public void givenTwoFullhouse_whenCompare_thenSuccess() {
		CardPattern pattern1 = new Straight(Card.build("C[2]")
											, Card.build("D[4]")
											, Card.build("H[3]")
											, Card.build("S[6]")
											, Card.build("C[5]"));
		

		CardPattern pattern2 = new Straight(Card.build("C[10]")
											, Card.build("D[J]")
											, Card.build("H[Q]")
											, Card.build("S[K]")
											, Card.build("C[A]"));
		
		assertTrue(pattern1.compareTo(pattern2) > 0);
	}
	
	@Test
	public void givenTwoFullhouse_whenCompare_thenSuccess_2() {
		CardPattern pattern1 = new Straight(Card.build("C[10]")
											, Card.build("D[J]")
											, Card.build("H[Q]")
											, Card.build("S[K]")
											, Card.build("C[A]"));
		
		CardPattern pattern2 = new Straight(Card.build("C[9]")
											, Card.build("D[10]")
											, Card.build("H[J]")
											, Card.build("S[Q]")
											, Card.build("C[K]"));

		CardPattern pattern3 = new Straight(Card.build("D[9]")
											, Card.build("D[10]")
											, Card.build("H[J]")
											, Card.build("H[Q]")
											, Card.build("H[K]"));
		
		assertTrue(pattern1.compareTo(pattern2) > 0);
		assertTrue(pattern3.compareTo(pattern3) == 0);
	}
	
	

}
