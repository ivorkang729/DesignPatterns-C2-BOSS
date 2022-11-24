package pattern;

import card.Card;

public class IllegalPattern extends CardPattern {
	
	
	public IllegalPattern() {
		super("不合法的牌型", new Card[0]);
	}
	
	
	@Override
	protected boolean isSameType(CardPattern o) {
		throw new UnsupportedOperationException("不支援此操作");
	}
	
	
	@Override
	protected int compareToPattern(CardPattern o) {
		throw new UnsupportedOperationException("不支援此操作");
	}

	
}
