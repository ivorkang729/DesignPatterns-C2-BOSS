package unitTest;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import base.MockDeck;
import base.TestdataReader;

public class TestMockDeck {
	
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

	@Test
	public void test() {
		TestdataReader testdataReader = new TestdataReader(path + "/normal-no-error-play2.in");
		
		MockDeck deck = new MockDeck(testdataReader);
		deck.shuffle();
		assertEquals("S[6] C[9] H[2] H[3] D[7] C[10] C[8] H[J] H[10] D[10] S[3] D[J] C[4] D[9] D[5] S[J] C[5] D[8] D[A] C[3] C[J] D[2] C[7] S[A] S[8] H[A] H[Q] C[K] D[6] C[2] D[3] D[K] C[A] D[Q] S[4] H[6] S[2] H[K] S[5] S[9] H[8] H[5] C[Q] S[Q] S[10] H[4] H[7] S[7] C[6] D[4] H[9] S[K]"
				, deck.toString());
		
	}

	@Test
	public void test2() {
		TestdataReader testdataReader = new TestdataReader(path + "/straight.in");
		
		MockDeck deck = new MockDeck(testdataReader);
		deck.shuffle();
		assertEquals("D[9] C[J] D[10] S[9] H[6] C[5] S[J] C[7] D[7] C[K] H[2] H[Q] S[8] S[Q] H[4] S[10] S[3] H[A] S[A] H[5] D[Q] C[A] S[4] D[8] C[8] C[9] S[7] S[2] D[6] C[4] D[A] H[8] D[3] C[6] H[10] D[2] H[9] C[2] H[3] H[K] D[5] D[J] C[3] D[K] H[7] S[6] C[Q] S[5] C[10] H[J] S[K] D[4]"
				, deck.toString());
		
	}

}
