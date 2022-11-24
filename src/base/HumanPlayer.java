package base;

import java.util.Scanner;

import utils.Utils;

public class HumanPlayer extends Player {
	
	private Scanner cli = new Scanner(System.in);	
	

	@Override
	public void nameSelf() {
		Utils.println("請為自己命名:");
		String in = cli.nextLine();
		this.name = in;
	}


	@Override
	protected String readInput() {
		return cli.nextLine();
	}



}
