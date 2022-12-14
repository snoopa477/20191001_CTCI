package c03_StacksAndQueues.p03_StackOfPlates;
import static java.lang.System.out;

import java.util.StringJoiner;
public class MyDoublyLinkList implements MyStack{
	
	//DETAIL: once it's set, it never changes
	private int capacity;
	//DETAIL: size is always 0 <= size <= capacity. if any operation try to break boundary, throw exception
	private int size;
	
	MyDoublyLinkListNode head;
	MyDoublyLinkListNode tail;
	
	
	public MyDoublyLinkList(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	public void pushToHead( int key ) throws Exception {
		
		//PURPOSE: push operation is not allowed
		if( size == capacity ) {
			throw new Exception("FullLinkList");
		}
		
		
		//THINK_FURTHER: this snippet of code is somehow similar to pop size == 1 case
		if( size == 0 ) {
			MyDoublyLinkListNode newNode = new MyDoublyLinkListNode(key);
			head = newNode;
			tail = newNode;
			size++;
			return ;
		}
		
		
		MyDoublyLinkListNode newNode = new MyDoublyLinkListNode(key);
		newNode.next = head;
		head.parent = newNode;
		head = newNode;
		
		size++;
	}
	
	
	
	public int popFromHead() throws Exception {
		
		if( size == 0 ) {
			throw new Exception("EmptyLinkList");
		}
		
		//CAREFUL this corner case
		//DETAIL: Somehow I don't want to mix this case with other general case
		if( size == 1 ) {
			
			int poppedValue = head.value;
			//They both points to the same node, which is gonna be abandoned
			//Since there's only one node, no room to move head; it just disappears
			head = null;
			tail = null;
			size--;
			return poppedValue;
		}
		
		int poppedValue = head.value;
		
//		head = head.next;
//		head.parent = null;
		
		//ALTERNATIVE: I'm familiar with this because I prefer changing head/tail at the end 
		MyDoublyLinkListNode newHead = head.next;
		//REASONING: garbage collector will kill the old head automatically
		newHead.parent = null;
		head = newHead;
		size--;
		
		return poppedValue;
	}
	
	
	
	//For demonstration purpose
	public void pushToTail( int key ) throws Exception {
		
		if( size == capacity ) {
			throw new Exception("FullLinkList");
		}
		
		if( size == 0 ) {
			MyDoublyLinkListNode newNode = new MyDoublyLinkListNode(key);
			head = newNode;
			tail = newNode;
			size++;
			return ;
		}
		
		MyDoublyLinkListNode newNode = new MyDoublyLinkListNode(key);
		tail.next = newNode;
		tail = newNode;
		
		size++;
	}
	
	
	
	public int popFromTail() throws Exception {
		
		if( size == 0 ) {
			throw new Exception("EmptyLinkList");
		}
		
		
		if( size == 1 ) {
			
			int poppedValue = head.value;
			head = null;
			tail = null;
			size--;
			return poppedValue;
		}
		
		int poppedValue = tail.value;
		
		/**
		 * DETAIL: it would be better to have picture in mind before coding 
		 */
		MyDoublyLinkListNode newTail = tail.parent;
		newTail.next = null;
		tail = newTail;
		
		size--;
		
		return poppedValue;
	}



	@Override
	public void push(int key) throws Exception {
		pushToHead(key);
	}

	
	
	@Override
	public int pop() throws Exception {
		return popFromHead();
	}


	
	@Override
	public int removeFromBottom() throws Exception{
		return popFromTail();
	}



	@Override
	public boolean isEmpty() {
		return size == 0;
	}



	@Override
	public boolean isFull() {
		return size == capacity;
	}

	
	
	public int peek() throws Exception {
		
		if( isEmpty() ) {
			throw new Exception("Empty stack");
		}
		
		return head.value;
		
	}
	
	
	
	public String toString( boolean isFromTail ) {
		
		StringJoiner sj = null;
		
		if( isFromTail ) {
			//arrow direction is based on head
			sj = new StringJoiner(" <- ");
			MyDoublyLinkListNode current = tail;
			while( current != null ) {
				sj.add( String.valueOf( current.value ) );
				current = current.parent;
			}
		}
		else {
			sj = new StringJoiner(" -> ");
			MyDoublyLinkListNode current = head;
			while( current != null ) {
				sj.add( String.valueOf( current.value ) );
				current = current.next;
			}
		}
		
		return sj.toString();
	}
	
	
	
	public String toString() {
		return toString( true );
	}
	
	
	
	/*
	from tail 1 <- 2 <- 3 <- 4 <- 5
	from head 5 -> 4 -> 3 -> 2 -> 1
	after pop, from tail 1 <- 2 <- 3 <- 4
	after popFromTail, from tail 2 <- 3 <- 4 
	 */
	public static void main(String[] args) throws Exception {
		
		MyDoublyLinkList linkList = new MyDoublyLinkList(5);
		
		linkList.push( 1 );
		linkList.push( 2 );
		linkList.push( 3 );
		linkList.push( 4 );
		linkList.push( 5 );
		
		out.println( "from tail " + linkList.toString( true ) );
		out.println( "from head " + linkList.toString( false ) );
		
		linkList.pop();
		out.println( "after pop, from tail " + linkList.toString( true ) );
		
		linkList.popFromTail();
		out.println( "after popFromTail, from tail " + linkList.toString( true ) );
		
	}

}





