package unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import card.Card;

public class TestCard {

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
	public void test1() {
		assertTrue(Card.build("C[2]").compareTo(Card.build("D[2]")) < 0);
		assertTrue(Card.build("D[2]").compareTo(Card.build("H[2]")) < 0);
		assertTrue(Card.build("H[2]").compareTo(Card.build("S[2]")) < 0);
		
		assertTrue(Card.build("C[3]").compareTo(Card.build("C[4]")) < 0);
		assertTrue(Card.build("C[6]").compareTo(Card.build("C[J]")) < 0);
		assertTrue(Card.build("C[J]").compareTo(Card.build("C[K]")) < 0);
		assertTrue(Card.build("C[3]").compareTo(Card.build("C[2]")) < 0);
		
		assertTrue(Card.build("S[3]").compareTo(Card.build("C[4]")) < 0);
		assertTrue(Card.build("H[6]").compareTo(Card.build("D[J]")) < 0);
		assertTrue(Card.build("S[J]").compareTo(Card.build("D[K]")) < 0);
	}

}
