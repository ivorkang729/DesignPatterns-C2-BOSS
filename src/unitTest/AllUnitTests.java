package unitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCard.class, TestSingle.class, TestPair.class, TestFullHouse.class, TestStraight.class
	, TestCardPatternRecognizer.class, TestUtils.class, TestTestdataReader.class, TestMockDeck.class
	, TestHand.class, TestAiPlayer.class})
public class AllUnitTests {

}
