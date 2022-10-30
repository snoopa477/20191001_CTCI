package c02_LinkedList.p02_ReturnKthToLast;
import static java.lang.System.out;

import java.util.StringJoiner;

import c02_LinkedList.p01_RemoveDups.RemoveDups_01_Buffer;
import util.LinkedListNode;
public class Test_ReturnKthToLast {

	public static void main(String[] args) {
		int[][] arrayOfKeys = {
				{2, 5, 4, 5, 2, 2, 6, 7},
				{43, 34, 43, 34}
		};
		
		
		{
			out.println("\n----------------------------_0202_00_ReturnKthToLast");
			for( int[] keys: arrayOfKeys ) {
				LinkedListNode list = makeList(keys);
				_0202_00_ReturnKthToLast obj = new _0202_00_ReturnKthToLast();
				obj.printKthToLast(list, 1);
			}
		}
		
		{
			out.println("\n----------------------------_0202_01_ReturnKthToLast");
			for( int[] keys: arrayOfKeys ) {
				LinkedListNode list = makeList(keys);
				_0202_01_ReturnKthToLast obj = new _0202_01_ReturnKthToLast();
				int k = 1;
				LinkedListNode result = obj.kthToLast(list, k);
				out.printf("%d to the last element is %d\n",
						k,
						result.data);
			}
		}
		
		{
			out.println("\n----------------------------_0202_02_ReturnKthToLast");
			for( int[] keys: arrayOfKeys ) {
				LinkedListNode list = makeList(keys);
				_0202_02_ReturnKthToLast obj = new _0202_02_ReturnKthToLast();
				int k = 1;
				LinkedListNode result = obj.nthToLast(list, k);
				out.printf("%d to the last element is %d\n",
						k,
						result.data);
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


