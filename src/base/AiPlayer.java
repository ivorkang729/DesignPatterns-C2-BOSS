package base;

public class AiPlayer extends Player {
	
	private TestdataReader testdataReader;
	
	
	public AiPlayer(TestdataReader testdataReader) {
		this.testdataReader = testdataReader;
	}
	

	@Override
	public void nameSelf() {
		this.name = testdataReader.readLine();
	}


	@Override
	protected String readInput() {
		return testdataReader.readLine();
	}
	

}
