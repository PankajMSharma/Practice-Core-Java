package root.globalexception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestGlobalException {

	public static void main(String args[]) throws IOException {
		GlobalException gExc = new GlobalException();
		
		// Pass instance of global exception handler as argument to thread.
		Thread.setDefaultUncaughtExceptionHandler(gExc);
		
		// Test 1
		Integer ans = divide(new Integer(1100), new Integer(0));
		System.out.println(ans);
		
		// Test 2
		Path file = Paths.get("");
	    Files.delete(file);
	}
	
	public static Integer divide(Integer a, Integer b) {
		Integer c = a / b;
		return c;
	}
}
