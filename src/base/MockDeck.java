package base;

import java.util.Stack;

import card.Card;

public class MockDeck extends Deck {
	
	private TestdataReader testdataReader;
	
	public MockDeck(TestdataReader testdataReader) {
		this.testdataReader = testdataReader;
	}
	
	@Override
	public void shuffle() {
		Stack<Card> shuffledStack = new Stack<>();
		for (String expression : testdataReader.readLine().split(" ")) {
			shuffledStack.push(Card.build(expression));
		}
		this.stack = shuffledStack;
	}
	
}
