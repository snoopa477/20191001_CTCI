package c03_StacksAndQueues.p02_StackMin;
import static java.lang.System.out;

import c03_StacksAndQueues.p01_ThreeInOne.EmptyStackException;
import util.MyStack;
public class StackMin_01_timeCapsule extends MyStack<NodeWithMin>{

	public void push(int key ) {
		
		if( super.isEmpty() ) {
			super.push( new NodeWithMin(key, key) );
		}else {
			
			NodeWithMin nodeWithMin = super.peek();
			int currentMin = nodeWithMin.min;
			
			super.push( new NodeWithMin ( key, Math.min(key, currentMin) ) );
		}
	}
	
	
	
	public int min() throws EmptyStackException {
		
		if( super.isEmpty() ) {
			throw new EmptyStackException();
		}
		
		return super.peek().min;
		
	}
	
//	public NodeWithMin pop() {
//		return null;
//	}
	
	/*
	 WRONG:The return type is incompatible with MyStack<NodeWithMin>.pop()
	 */
//	public int pop() {
//		
//	}
	
}



/*
 Question: Why can't I make this class as inner class?
 * */
class NodeWithMin{
	public int value;
	public int min;
	
	
	public NodeWithMin(int value, int min) {
		super();
		this.value = value;
		this.min = min;
	}
}
