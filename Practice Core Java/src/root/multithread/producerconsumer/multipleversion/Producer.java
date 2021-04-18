package root.multithread.producerconsumer.multipleversion;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	List<Integer> queue;
	static AtomicInteger counter = new AtomicInteger(0);
	
	Producer(List<Integer> q) {
		this.queue = q;
	}
	
	public void run() {
		synchronized (queue) {
			while (true) {
				this.produce();
			}	
		}
	}
	
	public void produce() {
		while(queue.size() == 1) {
			try {
				queue.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Produced: " + counter + " by " + Thread.currentThread().getName());
		queue.add(counter.incrementAndGet());
		
		queue.notifyAll();
		
		// Sleep can be removed
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
