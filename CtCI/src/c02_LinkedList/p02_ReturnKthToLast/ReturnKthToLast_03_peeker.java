package c02_LinkedList.p02_ReturnKthToLast;
import static java.lang.System.out;

import util.LinkedListNode;
public class ReturnKthToLast_03_peeker {

	
	
	public static LinkedListNode getKthToLast( LinkedListNode head, int k ) {
		
		LinkedListNode current = head;
		
		//PURPOSE: keep distance from current by K nodes
		LinkedListNode peekAheadByK = head;
		for( int i = 0; i < k; i++ ) {
			
			/**
			 * REASONING: if k > length of nodes, then no answer for this question: null
			 * and that will also lead to the situation where null node attempt to go further
			 * e.g. 
			 * k = 4
			 * node length = 3
			 * node: 1 2 3 
			 * pointer is denoted by [] 
			 * node: 1 2 3 X [X]
			 * 
			 * return null before the program throws NullPointerException
			 */
			//DETAIL: spot the nuances that both nulls serve different meaning
			if( peekAheadByK == null ) {
				return null;
			}
			peekAheadByK = peekAheadByK.next;
		}
		
		/*PURPOSE:Under the premise both pointers keep same distance, push peekAheadByK to null,
		 * the current points to the answer: K th to the last 
		 */
		while( peekAheadByK != null ) {
			peekAheadByK = peekAheadByK.next;
			current = current.next;
		}
		
		return current;
	}
	
	
}


