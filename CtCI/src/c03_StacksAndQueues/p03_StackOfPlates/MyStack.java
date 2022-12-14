package c03_StacksAndQueues.p03_StackOfPlates;
import static java.lang.System.out;
public interface MyStack  {
	
	public void push( int key ) throws Exception;
	
	public int pop() throws Exception;
	
	public int removeFromBottom() throws Exception;
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public int peek() throws Exception;
	
}


