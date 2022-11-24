package card;

import java.util.Arrays;

public enum Rank {
	_3(0, "3"),
	_4(1, "4"),
	_5(2, "5"),
	_6(3, "6"),
	_7(4, "7"),
	_8(5, "8"),
	_9(6, "9"),
	_10(7, "10"),
	_J(8, "J"),
	_Q(9, "Q"),
	_K(10, "K"),
	_A(11, "A"),
	_2(12, "2")
	;
	
	
	private int order;	// 大小，數字越小越小
	private String name;
	
	Rank(int order, String name){
		this.order = order;
		this.name = name;
	}
	
	public int getOrder() {
		return order;
	}
	
	public String getName() {
		return name;
	}
	
	public static Rank findByName(String name) {
		return Arrays.stream(Rank.values()).filter(row -> row.getName().equals(name)).findAny().orElse(null);
	}
	
}
