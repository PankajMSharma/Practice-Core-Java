package root.customexception;

public class AgeUncheckedException extends RuntimeException {
	AgeUncheckedException(String s) {
		super(s);
	}
}
