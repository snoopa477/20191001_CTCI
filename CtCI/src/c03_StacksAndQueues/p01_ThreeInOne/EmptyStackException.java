package c03_StacksAndQueues.p01_ThreeInOne;
import static java.lang.System.out;
public class EmptyStackException extends Exception{
	public EmptyStackException() {};
	public EmptyStackException(String errorMessage) {
        super(errorMessage);
    }
}


