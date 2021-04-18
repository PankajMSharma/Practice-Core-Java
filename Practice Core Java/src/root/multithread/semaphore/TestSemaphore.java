package root.multithread.semaphore;

import java.util.Arrays;

public class TestSemaphore {
	
	public static void main(String args[]) {
		Resource r = new Resource();
		PrintRequester printRequester = new PrintRequester(r);
		
		Thread[] threads = new Thread[10];
		
		for(int i=0; i < threads.length; ++i) {
			threads[i] = new Thread(printRequester);
		}
		
		Arrays.stream(threads).forEach(thread -> thread.start());
	}
}
