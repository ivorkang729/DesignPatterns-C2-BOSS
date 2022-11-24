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

public class TestFullHouse {

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
		CardPattern pattern = new FullHouse(Card.build("C[4]")
											, Card.build("D[2]")
											, Card.build("H[2]")
											, Card.build("S[4]")
											, Card.build("C[2]"));
		
//		System.out.println(pattern);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void givenInvalidFullhouse_when_thenThrowException() {
		new FullHouse(Card.build("C[4]")
											, Card.build("D[2]")
											, Card.build("H[2]")
											, Card.build("S[9]")
											, Card.build("C[2]"));
		
	}
	
	@Test
	public void givenTwoFullhouse_whenCompare_thenSuccess() {
		CardPattern pattern1 = new FullHouse(Card.build("C[A]")
											, Card.build("D[A]")
											, Card.build("H[3]")
											, Card.build("S[A]")
											, Card.build("C[3]"));
		

		CardPattern pattern2 = new FullHouse(Card.build("C[2]")
											, Card.build("D[2]")
											, Card.build("H[5]")
											, Card.build("S[5]")
											, Card.build("C[5]"));
		
		assertTrue(pattern1.compareTo(pattern2) > 0);
	}
	
	@Test
	public void givenTwoFullhouse_whenCompare_thenSuccess_2() {
		CardPattern pattern1 = new FullHouse(Card.build("C[A]")
											, Card.build("D[A]")
											, Card.build("H[A]")
											, Card.build("S[3]")
											, Card.build("C[3]"));
		

		CardPattern pattern2 = new FullHouse(Card.build("C[2]")
											, Card.build("D[2]")
											, Card.build("H[5]")
											, Card.build("S[5]")
											, Card.build("C[5]"));
		
		assertTrue(pattern1.compareTo(pattern2) > 0);
	}
	
	

}
