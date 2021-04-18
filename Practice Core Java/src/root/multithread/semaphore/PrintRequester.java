package root.multithread.semaphore;

public class PrintRequester implements Runnable {
	Resource resource = new Resource();
	
	PrintRequester(Resource r) {
		resource = r;
	}

	public void run() {
		requestPrint();
	}
	
	public void requestPrint() {
		try {
			resource.sema.acquire();
			resource.printer(Thread.currentThread().getName(), "");
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			resource.sema.release();
		}
	}
}
