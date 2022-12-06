package c03_StacksAndQueues.p01_ThreeInOne;
//Warning: The serializable class FullStackException does not declare a static final serialVersionUID  field of type long
public class FullStackException extends Exception {
	
	private static final long serialVersionUID = 9095714725257596588L;
	public FullStackException() {};
	public FullStackException(String errorMessage) {
        super(errorMessage);
    }
}


