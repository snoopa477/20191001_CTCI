package c03_StacksAndQueues.p01_ThreeInOne;
public class EmptyStackException extends Exception{
	private static final long serialVersionUID = 1L;
	public EmptyStackException() {};
	public EmptyStackException(String errorMessage) {
        super(errorMessage);
    }
}


