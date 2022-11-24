package unitTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import base.Hand;
import card.Card;
import utils.Utils;

public class TestHand {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		Hand hand = new Hand();
		hand.add(Arrays.asList(Card.build("C[K]"), Card.build("C[A]"), Card.build("C[Q]"), Card.build("H[9]"), Card.build("S[3]"), Card.build("C[2]")));
		assertEquals("S[3] H[9] C[Q] C[K] C[A] C[2]", hand.toString());
	}

	@Test
	public void testPlay() {
		Hand hand = new Hand();
		hand.add(Arrays.asList(Card.build("C[K]"), Card.build("C[A]"), Card.build("C[Q]"), Card.build("H[9]"), Card.build("S[3]"), Card.build("C[2]")));
		assertEquals("S[3] H[9] C[Q] C[K] C[A] C[2]", hand.toString());
		
		assertEquals(Utils.toSet(Arrays.asList(Card.build("C[Q]"), Card.build("C[A]"))), hand.play(Arrays.asList(2, 4)));
		assertEquals("S[3] H[9] C[K] C[2]", hand.toString());

		assertEquals(Utils.toSet(Arrays.asList(Card.build("S[3]"), Card.build("H[9]"), Card.build("C[2]"))), hand.play(Arrays.asList(0, 1, 3)));
		assertEquals("C[K]", hand.toString());
	}

	
	@Test
	public void testPrint() {
		Hand hand = new Hand();
		hand.add(Arrays.asList(Card.build("H[K]"), Card.build("C[J]"), Card.build("D[K]"), Card.build("S[9]"), Card.build("H[10]"), Card.build("H[8]")
				, Card.build("D[3]"), Card.build("D[7]"), Card.build("H[5]"), Card.build("D[4]"), Card.build("H[3]"), Card.build("S[2]"), Card.build("S[Q]"))
		);
		          
//		hand.print();
		
	}
	
	
}
