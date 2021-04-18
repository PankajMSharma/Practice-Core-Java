package root.globalexception;

// Implement Thread.UncaughtExceptionHandler
public class GlobalException implements Thread.UncaughtExceptionHandler {

	// Override uncaughtException method
	public void uncaughtException(Thread t, Throwable th) {
		System.out.println("Global Exception Occured! Time to run!!");
		th.printStackTrace();
	}
}
