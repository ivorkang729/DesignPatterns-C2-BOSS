package unitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utils.Utils;

public class TestUtils {

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
	public void testRightPadding() {
		assertEquals("     ", Utils.rightPadding(null, "C[10]".length(), " "));
		assertEquals("6    ", Utils.rightPadding("6", "C[10]".length(), " "));
		assertEquals("batyzyzy", Utils.rightPadding("bat", 8, "yz"));
	}

}
