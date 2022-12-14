package c03_StacksAndQueues.p03_StackOfPlates;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class _0303_00_StackOfPlates {
	
	public int capacity; 
	
	ArrayList<Stack > stacks =  new ArrayList<Stack>();
	
	
	
	public _0303_00_StackOfPlates(int capacity) {
		super();
		this.capacity = capacity;
	}



	public void push(int v) { 
		Stack last = getLastStack(); 
		if (last != null && !last.isFull()) { // add to last stack 
			last.push(v); 
		} 
		else { // must create new stack 
			Stack stack = new Stack(capacity); 
			stack.push(v); 
			stacks.add(stack); 
		} 
		 
	} 
	
	
	
	public int pop() { 
		Stack last = getLastStack(); 
		
		if (last == null) {
			throw new EmptyStackException();
		}
		
		int v = last.pop(); 
		if (last.size == 0) 
			stacks.remove(stacks.size() - 1); 
		
		return v; 
	}


	

	private Stack getLastStack() {
		if (stacks.size() == 0) {
			return null; 
		}
		return stacks.get(stacks.size() - 1); 
	} 
	
	
	
	public class Stack { 
		
		private int capacity; 
		public Node top, bottom; 
		public int size = 0; 

		public Stack(int capacity) {
			this.capacity = capacity; 
		} 
		
		
		
		public boolean isFull() { 
			return capacity == size; 
		}

		
		
		public void join(Node above, Node below) { 
			if (below != null) below.above = above; 
			if (above != null) above.below = below; 
		} 

		public boolean push(int v) { 
			if (size >= capacity) 
				return false; 
			size++; 
			Node n = new Node(v) ; 
			if (size == 1) 
				bottom = n; 
			join(n, top) ; 
			top = n; 
			return true; 
		} 

		
		
		public int pop() { 
			//WRONG I think there's missing operation here, without this, it would cause wrong
			Node t = top; 
			top = top.below; 
			size--; 
			return t.value; 
		} 

		
		
		public boolean isEmpty() { 
			return size == 0; 
		} 

		
		
		public int removeBottom() { 
			Node b = bottom; 
			bottom = bottom.above; 
			if (bottom != null) bottom.below = null; 
			size--; 
			return b.value; 
		} 
	}

}


