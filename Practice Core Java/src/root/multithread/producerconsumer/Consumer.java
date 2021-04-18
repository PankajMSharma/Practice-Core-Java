package root.multithread.producerconsumer;

import java.util.List;

public class Consumer implements Runnable {
	private final List<Integer> queue;
	
	Consumer(List<Integer> queue) {
		this.queue = queue;
	}
	
	public void run() {
		synchronized (queue) {
			while (true) {
				this.consume();
			}	
		}
	}
	
	synchronized void consume() {
		while(queue.size() == 0) {
			try {
				queue.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Consumed: " + queue.remove(0));
		queue.notifyAll();
	}
}
