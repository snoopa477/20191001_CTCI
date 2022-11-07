package c02_LinkedList.p03_DeleteMiddleNode;
import static java.lang.System.out;

import java.util.StringJoiner;

import util.LinkedListNode;
public class Test_DeleteMiddleNode {

	public static void main(String[] args) {
		
		LinkedListNode list123456 = getList(1,2,3,4,5,6);
		int deleteKey = 3;
		LinkedListNode nodeDeleteKey = search(list123456, deleteKey);
		showList(list123456);
		out.println("after deletion of this node data" + deleteKey );
		DeleteMiddleNode_01_Replace.remove(nodeDeleteKey);
		
		showList(list123456);
		
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
	
	
	
	//DETAIL: this is somehow similar to Red Black Tree search
	public static LinkedListNode search( LinkedListNode head, int key) {
		
		LinkedListNode current = head;
		while( current != null ) {
			if( current.data == key ) {
				return current;
			}
			current = current.next;
		}
		
		return null;
	}

}


