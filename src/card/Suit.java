package card;

import java.util.Arrays;

public enum Suit {
	C(0, "C"), 		//梅花
	D(1, "D"),		//方塊
	H(2, "H"),		//紅心
	S(3, "S")		//黑桃
	;
	
	private int order;	// 大小，數字越小越小
	private String name;
	
	
	Suit(int order, String name){
		this.order = order;
		this.name = name;
	}
	
	
	public int getOrder() {
		return order;
	}
	
	
	public String getName() {
		return name;
	}

	
	public static Suit findByName(String name) {
		return Arrays.stream(Suit.values()).filter(row -> row.getName().equals(name)).findAny().orElse(null);
	}
	
}
