package root.multithread.producerconsumer;

import java.util.List;

public class Producer implements Runnable {
	List<Integer> queue;
	int counter = 0;
	
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
		
		System.out.println("Produced: " + counter);
		queue.add(++counter);
		
		queue.notifyAll();
		
		// Sleep can be removed
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
