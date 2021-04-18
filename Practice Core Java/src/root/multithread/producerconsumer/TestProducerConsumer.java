package root.multithread.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class TestProducerConsumer {
	static List<Integer> queue = new ArrayList<Integer>();

	public static void main(String[] args) {
		Producer prod = new Producer(queue);
		Thread tProd = new Thread(prod);
		
		Consumer cons = new Consumer(queue);
		Thread tCons = new Thread(cons);
		
		tProd.start();
		tCons.start();
	}

}
