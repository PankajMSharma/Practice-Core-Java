package root;

import root.customexception.TestException;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starter");
		(new TestException()).test();
	}

}
