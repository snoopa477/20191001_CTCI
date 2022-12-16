package c03_StacksAndQueues.p02_StackMin;
import static java.lang.System.out;

import java.util.EmptyStackException;

import util.MyStack;
/* Example:
 * stack:		5  6  3  7  5  3
 * minStack:	5  3  3
 */
public class StackMin_03_sharedMin {
	
	/*
	 * IMAGINE: 
	 * if there exists a element, which is pushed to stack and minStack at the same time,
	 * in other perspective, stack.peek() == minStack.peek(), both stacks refers to the same element
	 * 
	 * In other words, two same values refers to same thing, instead of different things
	 */
	private MyStack<Integer> stack;
	private MyStack<Integer> minStack;
	
	
	public StackMin_03_sharedMin() {
		//WRONG if I miss this when I push: java.lang.NullPointerException
		this.stack = new MyStack<>();
		this.minStack = new MyStack<>();
	}



	public void push( int key ) {
		
		stack.push( key );
		
		/*PURPOSE: To alleviate the problem of duplication from stackMin_01 and 02, 
		 only push element to minStack when there's variation of Min
		 */ 
		
		//WRONG if I miss this: when first push I have 0 sized stack -> java.util.EmptyStackException
		int currentMin = minStack.isEmpty() == false?  minStack.peek() : Integer.MAX_VALUE;
		/*REASONING: should be <= instead of <
		 * Otherwise, given we have
		 * stack:		5(t1) 3(t2) 3(t3)
		 * minStack:	5(t1) 3(t2)
		 * 
		 * pop() of minStack: 3(t2), along with pop of stack: 3(t3)
		 * stack:		5(t1) 3(t2) 
		 * minStack:	5(t1) 
		 * 
		 * the stack of 3(t3) pops out minStack of 3(t2), which is should be belongs to stack of 3(t2)
		 * Now stack of 3(t2) doesn't have corresponding minStack of 3(t2) to pop.
		 * 
		 */
		if( key <= currentMin ) {
			minStack.push( key );
		}
	}
	
	
	
	public int pop() {
		
		if( stack.isEmpty() ) {
			throw new EmptyStackException();
		}
		
		int poppedValue = stack.pop();
		
		//PURPOSE: update minStack
		int currentMin = minStack.peek();
		//PURPOSE: same value refers to same element
		if( poppedValue == currentMin ) {
			minStack.pop();
		}
		
		return poppedValue;
	}
	
	
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	
	
	public int peek() {
		return stack.peek();
	}
	
	
	
	public int min() {
		return minStack.peek();
	}
	

}


