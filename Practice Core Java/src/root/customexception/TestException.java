package root.customexception;

public class TestException {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test EXP");
		(new TestException()).test();
	}
	
	public void test() {
		// To test checked exception
		testCheckedException();
		
		// To test unchecked exception
		testUncheckedException();
	}
	
	void testCheckedException() { // Requires try and catch at compile time
		try {
			throw new AgeCheckedException("Checked Exception: Age not valid");
		} catch (AgeCheckedException e) {
			e.printStackTrace();
		}
	}
	
	void testUncheckedException() { // Does not require try and catch and compile time
		throw new AgeUncheckedException("Unchecked exception: Age not valid");
	}
}
