package unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import base.TestdataReader;

public class TestTestdataReader {

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

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TestdataReader dataReader = new TestdataReader(path + "/normal-no-error-play2.in");
		assertEquals("S[6] C[9] H[2] H[3] D[7] C[10] C[8] H[J] H[10] D[10] S[3] D[J] C[4] D[9] D[5] S[J] C[5] D[8] D[A] C[3] C[J] D[2] C[7] S[A] S[8] H[A] H[Q] C[K] D[6] C[2] D[3] D[K] C[A] D[Q] S[4] H[6] S[2] H[K] S[5] S[9] H[8] H[5] C[Q] S[Q] S[10] H[4] H[7] S[7] C[6] D[4] H[9] S[K]"
				, dataReader.readLine());
		assertEquals("水球", dataReader.readLine());
		assertEquals("火球", dataReader.readLine());
		assertEquals("保齡球", dataReader.readLine());
		assertEquals("地瓜球", dataReader.readLine());
		assertEquals("0 1", dataReader.readLine());
		assertEquals("0 1", dataReader.readLine());
		assertEquals("0 1", dataReader.readLine());
		assertEquals("2 3", dataReader.readLine());
		assertEquals("3 4", dataReader.readLine());
	}

}
