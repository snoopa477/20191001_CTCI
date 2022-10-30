package c02_LinkedList.p01_RemoveDups;
import static java.lang.System.out;

import java.util.StringJoiner;
//import java.util.stream.Stream;

import util.LinkedListNode;
public class Test_RemoveDups {

	public static void main(String[] args) {
		
		int[][] arrayOfKeys = {
				{2, 5, 4, 5, 2, 2, 6, 7},
				{43, 34, 43, 34}
		};
		
		{
			out.println("\n----------------------------RemoveDups_01_Buffer");
			for( int[] keys: arrayOfKeys ) {
				LinkedListNode list = makeList(keys);
				showLinkedList( list );
				RemoveDups_01_Buffer.removeDuplicates( list );
				showLinkedList( list );
			}
		}
		
		
		{
			out.println("\n----------------------------RemoveDups_02_NoBuffer");
			for( int[] keys: arrayOfKeys ) {
				LinkedListNode list = makeList(keys);
				showLinkedList( list );
				RemoveDups_02_NoBuffer.removeDuplicates( list );
				showLinkedList( list );
			}
		}
		
	}
	
	
	
	private static LinkedListNode makeList(int[] keys) {
		
		if( keys == null || keys.length == 0 ) {
			return null;
		}
		
		//current set next to next node
		LinkedListNode current = new LinkedListNode( keys[0] );
		LinkedListNode head = current;
		//next points to newly created node
		LinkedListNode next = null;
		//Stream.of(keys).for
		for( int i = 1; i < keys.length; i++ ) {
			next = new LinkedListNode( keys[i] );
			current.setNext( next );
			
			//prepare for the next iteration
			current = next;
			next = current.next;
		}
		
		return head;
	}
	
	
	
	private static void showLinkedList(LinkedListNode head) {
		
		if( head == null ) {
			out.println("This is an empty string");
		}
		
		LinkedListNode current = head;
		StringJoiner sj = new StringJoiner("->");
		while( current != null ) {
			sj.add( String.format("%-4d ", current.data) );
			//WRONG: forgot to proceed the current, leading to infinite loop
			current = current.next;
		}
		
		out.println( sj.toString() );
	}
	
}



