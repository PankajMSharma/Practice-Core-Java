package root.multithread.producerconsumer.multipleversion;

import java.util.ArrayList;
import java.util.List;

public class TestMultiProducerConsumer {
	static List<Integer> queue = new ArrayList<Integer>();
	
	private static final int MAX_PRODUCERS = 10;
	private static final int MAX_CONSUMERS = 10;

	public static void main(String[] args) {
		Thread[] producerThreads = new Thread[MAX_PRODUCERS];
		Thread[] consumerThreads = new Thread[MAX_CONSUMERS];
		
		for(int i=0; i<MAX_PRODUCERS; ++i) {
			Producer prod = new Producer(queue);
			producerThreads[i] = new Thread(prod, "Producer: " + i);
		}
		
		for(int i=0; i<MAX_CONSUMERS; ++i) {
			Consumer cons = new Consumer(queue);
			consumerThreads[i] = new Thread(cons, "Consumer: " + i);
		}
		
		for(int i=0; i<MAX_PRODUCERS; ++i) {
			producerThreads[i].start();
		}
		
		for(int i=0; i<MAX_CONSUMERS; ++i) {
			consumerThreads[i].start();
		}
	}

}
