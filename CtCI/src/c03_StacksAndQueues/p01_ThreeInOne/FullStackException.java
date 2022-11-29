package c03_StacksAndQueues.p01_ThreeInOne;
import static java.lang.System.out;
public class FullStackException extends Exception {
	
	public FullStackException() {};
	public FullStackException(String errorMessage) {
        super(errorMessage);
    }
}


