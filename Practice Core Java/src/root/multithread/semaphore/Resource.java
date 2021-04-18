package root.multithread.semaphore;

import java.util.concurrent.Semaphore;

public class Resource {
	public final Semaphore sema = new Semaphore(1); // This can be made binary or normal semaphore
	public int counter = 0;
	
	void printer(String requesterName, String message) {
		System.out.println(requesterName + ": " + message + ": " + ++counter);
	}
}
