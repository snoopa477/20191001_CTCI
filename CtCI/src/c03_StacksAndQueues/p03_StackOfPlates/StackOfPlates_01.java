package c03_StacksAndQueues.p03_StackOfPlates;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.StringJoiner;
/**
 * This class is served as a collection of stacks manager, responsible of
 * 0. pick which stack to operate on 
 * 1. creating a new stack and add to collection when first element or the last stack is full
 * 2. deleting the last stack when pop(), causing the last stack's size 0 
 * 
 * The operation within a stack is MyStack's responsibility
 */
public class StackOfPlates_01 {
	
	//WRONG if private is used, the subclass can't use this variable
	protected ArrayList<MyStack> stacks;
	protected int capacityForEachStack;
	
	
	public StackOfPlates_01(int capacityForEachStack) {
		this.capacityForEachStack = capacityForEachStack;
		this.stacks = new ArrayList<MyStack>();
	}



	public void push( int key ) throws Exception {
	
		if( stacks.size() == 0 || getLastStack().isFull()) {
			stacks.add( new MyDoublyLinkList(capacityForEachStack) );
		}
		
		//This is merged to if statement
//		MyStack lastStack = getLastStack();
//		if( lastStack.isFull() ) {
//			stacks.add( new MyDoublyLinkList(capacityForEachStack)  );
//		}
		
		//REASONING: reaching here nor is it null or full
		MyStack lastStack = getLastStack();
		lastStack.push( key );
		
	}
	
	
	
	public int pop() throws Exception {
		
		if( stacks.size() == 0 ) {
			throw new Exception();
		}
		
		MyStack lastStack = getLastStack();
		int poppedValue = lastStack.pop();
		
		if( getLastStack().isEmpty() ) {
			stacks.remove( stacks.size() -1 );
		}
		
		//WRONG: the sequence is wrong
//		if( getLastStack().isEmpty() ) {
//			stacks.remove( stacks.size() -1 );
//		}
//		
//		//REASONING: reaching here nor is it null or full
//		MyStack lastStack = getLastStack();
		
//		return lastStack.pop();
		
		return poppedValue;
	}
	
	
	
	public int peek() throws Exception {
		
		if( stacks.size() == 0 ) {
			throw new Exception();
		}
		
		return getLastStack().peek();
	}
	
	
	
	private MyStack getLastStack() throws Exception {
		
		if( stacks.size() == 0 ) {
			throw new Exception("no stacks to get");
		}
		
		return stacks.get( stacks.size() -1 );
	}
	
	
	
	//for debug purpose
	public String toString() {
		
		out.println("+- +- +-");
		
		StringJoiner sj = new StringJoiner("\n");
		
		for( int i = 0; i < stacks.size(); i++ ) {
			
			MyStack stack = stacks.get(i);
			sj.add( i + " th stack: " + stack );
		}
		
		return sj.toString();
	}
	
	
	/*
	+- +- +-
	0 th stack: 1 <- 2 <- 3
	1 th stack: 4
	+- +- +-
	0 th stack: 1 <- 2 <- 3
	1 th stack: 4 <- 5 <- 6
	2 th stack: 7 <- 8
	+- +- +-
	0 th stack: 1 <- 2 <- 3
	1 th stack: 4 <- 5 <- 6
	+- +- +-
	0 th stack: 1 <- 2 <- 3
	1 th stack: 4 <- 5
 
	 */
	public static void main(String[] args) throws Exception {
		
		StackOfPlates_01 stackOfPlates = new StackOfPlates_01(3);
		
		stackOfPlates.push(1);
		stackOfPlates.push(2);
		stackOfPlates.push(3);
		stackOfPlates.push(4);
		
		out.println( stackOfPlates );
		
		stackOfPlates.push(5);
		stackOfPlates.push(6);
		stackOfPlates.push(7);
		stackOfPlates.push(8);
		
		out.println( stackOfPlates );
		
		stackOfPlates.pop();
		stackOfPlates.pop();
		
		out.println( stackOfPlates );
		
		stackOfPlates.pop();
		
		out.println( stackOfPlates );
		
	}

}


