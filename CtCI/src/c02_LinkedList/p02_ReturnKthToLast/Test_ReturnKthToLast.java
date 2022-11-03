package c02_LinkedList.p02_ReturnKthToLast;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
import java.util.StringJoiner;

import c02_LinkedList.p01_RemoveDups.RemoveDups_01_Buffer;
import util.LinkedListNode;
public class Test_ReturnKthToLast {

	public static void main(String[] args) {
		int[][] arrayOfKeys = {
				{2, 5, 4, 5, 2, 2, 6, 7},
				{43, 34, 43, 34}
		};
		
		
		HashSet<String> options = new HashSet<>( Arrays.asList(new String[] {"1", "2"} ) );
		
		{
			out.println("\n----------------------------ReturnKthToLast_01_boomerang");
			for( int[] keys: arrayOfKeys ) {
				LinkedListNode list = makeList02(keys);
				//out.println("h1");
				showLinkedList( list );
				//out.println("h2");
				
				int k = 5;
				ReturnKthToLast_01_boomerang.showKthToLast(list, k);
				k = 1;
				ReturnKthToLast_01_boomerang.showKthToLast(list, k);
				
			}
		}
		
		{
			out.println("\n----------------------------ReturnKthToLast_02_boomerang_returnMulti");
			for( int[] keys: arrayOfKeys ) {
				LinkedListNode list = makeList02(keys);
				showLinkedList( list );
				
				int k = 5;
				LinkedListNode result ;
				result = ReturnKthToLast_02_boomerang_returnMulti.getKthToLast(list, k);
				out.println( k + "th to the last node is " + (result != null? result.data: "X"));
				k = 1;
				result = ReturnKthToLast_02_boomerang_returnMulti.getKthToLast(list, k);
				out.println( k + "th to the last node is " + (result != null? result.data: "X"));
			}
		}
		
		{
			out.println("\n----------------------------ReturnKthToLast_03_peeker");
			for( int[] keys: arrayOfKeys ) {
				LinkedListNode list = makeList02(keys);
				showLinkedList( list );
				
				int k = 5;
				LinkedListNode result ;
				result = ReturnKthToLast_03_peeker.getKthToLast(list, k);
				out.println( k + "th to the last node is " + (result != null? result.data: "X"));
				k = 1;
				result = ReturnKthToLast_03_peeker.getKthToLast(list, k);
				out.println( k + "th to the last node is " + (result != null? result.data: "X"));
			}
		}
		
		
		
	}
	
	
	
	//I think this one is better
	private static LinkedListNode makeList02(int... keys) {
		
		LinkedListNode head = null;
		
		//WRONG: miss the index 0
		//for( int i = keys.length-1; i > 0; i-- ) {
		for( int i = keys.length-1; i >= 0; i-- ) {
			
			LinkedListNode newNode = new LinkedListNode(keys[i]);
			
			if( head == null ) {
				head = newNode;
			}
			else {
				//WRONG: it would cause infinite loop
				//newNode.next = newNode;
				newNode.next = head;
				head = newNode;
			}
		}
		
		return head;
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
			//out.println("luu " + current.data);
		}
		
		out.println( sj.toString() );
	}

}


