package c03_StacksAndQueues.p02_StackMin;
import static java.lang.System.out;

import java.util.EmptyStackException;

import util.MyStack;
public class StackMin_02_timeCapsule {

	private MyStack<NodeWithMin> myStack;
	
	
	
	public StackMin_02_timeCapsule() {
		this.myStack = new MyStack<>();;
	}



	public void push(int key ) {
		
		if( myStack.isEmpty() ) {
			myStack.push( new NodeWithMin(key, key) );
		}
		
		else {
			
			NodeWithMin nodeWithMin = myStack.peek();
			int currentMin = nodeWithMin.min;
			int newMin = Math.min(key, currentMin);
			
			myStack.push( new NodeWithMin ( key, newMin ) );
		}
	}
	
	
	
	public int pop() {
		
		if( myStack.isEmpty() ) {
			throw new EmptyStackException();
		}
		
		return myStack.pop().value;
	}
	
	
	
	public boolean isEmpty() {
		return myStack.isEmpty();
	}
	
	
	
	public int peek() {
		
		if( myStack.isEmpty() ) {
			throw new EmptyStackException();
		}
		
		return myStack.peek().value;
	}
	
	
	
	public int min() {
		
		if( myStack.isEmpty() ) {
			throw new EmptyStackException();
		}
		
		return myStack.peek().min;
	}
	
	
	
	class NodeWithMin{
		public int value;
		public int min;
		
		
		public NodeWithMin(int value, int min) {
			super();
			this.value = value;
			this.min = min;
		}
	}
	
	
}


