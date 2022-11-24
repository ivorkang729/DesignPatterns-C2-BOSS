package base;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class TestdataReader {
	
	private List<String> lines = null;
	private int ptr = 0;
	
	public TestdataReader(String testdataFilePath) {
		try {
			lines = Files.readAllLines(Paths.get(testdataFilePath), Charset.forName("UTF-8"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String readLine() {
		return lines.get(ptr++);
	}

}
