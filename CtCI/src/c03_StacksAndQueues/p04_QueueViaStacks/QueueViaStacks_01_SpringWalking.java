package c03_StacksAndQueues.p04_QueueViaStacks;
import static java.lang.System.out;

import util.MyStack;
public class QueueViaStacks_01_SpringWalking {
	
	public static boolean IS_DEBUG = false;

	private MyStack<Integer> stackForAdd;
	private MyStack<Integer> stackForRemoval;
	private int size;
	
	
	
	public QueueViaStacks_01_SpringWalking() {
		stackForAdd = new MyStack<>();
		stackForRemoval = new MyStack<>();
		size = 0;
	}
	
	
	
	public void add( int key ) {
		stackForAdd.push( key );
		size++;
	}
	
	
	/**
	 * given that
	 *  stackForAdd		: t2 t3 t4
	 *  stackForRemoval	: t1
	 *  
	 *  remove(): t1
	 *  stackForAdd		: t2 t3 t4
	 *  stackForRemoval	: [t1] 
	 *  
	 *  remove(): t2
	 *  stackForAdd		: t2 t3 t4
	 *  stackForRemoval	:
	 *  
	 *  stackForAdd		:
	 *  stackForRemoval	: t4 t3 [t2]
	 *  
	 */
	public int remove() {
		
		if( stackForRemoval.isEmpty() ) {
			shiftFromAddToRemoval();
		}
		
		size--;
		return stackForRemoval.pop();
	}



	private void shiftFromAddToRemoval() {
		
		if( IS_DEBUG ) out.println("shiftFromAddToRemoval()");
		
		while( stackForAdd.isEmpty() == false ) {
			stackForRemoval.push( stackForAdd.pop() );
		}
	}
	
	
	
	public int peek() {
		
		if( stackForRemoval.isEmpty() ) {
			shiftFromAddToRemoval();
		}
		
		return stackForRemoval.peek();
	}
	
	
	
	public int size() {
		return size;
	}
	
	
}



