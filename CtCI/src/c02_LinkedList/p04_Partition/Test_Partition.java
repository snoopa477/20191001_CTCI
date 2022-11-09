package c02_LinkedList.p04_Partition;
import static java.lang.System.out;

import java.util.StringJoiner;

import util.LinkedListNode;
public class Test_Partition {

	public static void main(String[] args) {
		
		
		{
			out.println("\n - - -Partition_01_twoCollectorPointers - - -");
			LinkedListNode list = getList(3,5,8,5,10,2,1);
			int key = 5;
			showList(list);
			out.println("after partition by " + key);
			list = Partition_01_twoCollectorPointers.partition(list, key);
			showList(list);
			
		}
		
		
		{
			out.println("\n - - -Partition_02_DequeHeadTail - - -");
			LinkedListNode list = getList(3,5,8,5,10,2,1);
			int key = 5;
			showList(list);
			out.println("after partition by " + key);
			//WRONG: Don't forget
			//Partition_02_DequeHeadTail.partition(list, key);
			list = Partition_02_DequeHeadTail.partition(list, key);
			showList(list);
			
		}
		
	}
	
	
	
	public static LinkedListNode getList(int... keys) {
		
		LinkedListNode head = null;
		LinkedListNode tail = null;
		for( int key : keys) {
			
			//first time
			if( head == null ) {
				head = new LinkedListNode( key );
				tail = head;
			}
			//not first time creation 
			else {
				LinkedListNode newNode = new LinkedListNode( key );
				tail.next = newNode;
				tail = tail.next;
			}
		}
		return head;
	}
	
	
	
	public static void showList( LinkedListNode head ) {
		
		
		LinkedListNode current = head;
		
		StringJoiner sj = new StringJoiner(" -> ");
		
		while( current != null ) {
			sj.add( String.valueOf( current. data) );
			//WRONG: forget to add
			current = current.next;
		}
		
		out.println(sj.toString());
		
	}

}


