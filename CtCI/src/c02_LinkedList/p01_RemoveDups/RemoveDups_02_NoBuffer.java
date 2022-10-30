package c02_LinkedList.p01_RemoveDups;
import static java.lang.System.out;

import util.LinkedListNode;
public class RemoveDups_02_NoBuffer {
	
	//REASONING: compared to way01, without buffer -> no stored previous results to use, gotta re-calculate every iteration
	public static void removeDuplicates( LinkedListNode head ) {
		
		//this would be the target to be compared
		LinkedListNode pivot = head;
		
		/*THINK_FURTHER: consider the view scope of pivot: it can see nodes that follow behind it; 
		 * it cannot see nodes that precede it; however, these nodes are already processed.
		 */
		/* DETAIL: while( pivot != null ) is unnecessary 
		 * because at the last node -- in another viewpoint-- 
		 * duplication at least requires two nodes, which is impossible for such condition
		 */
		/*REASONING: if linkedList's length unchanged, it won't get exception; however,
		 * if linkedList length changes, the last element will be deleted before pivot moves to
		 * , and pivot will moves to null => using this if statement cause error   
		 */
		//java.lang.NullPointerException
		//while( pivot.next != null ) {
		while( pivot != null ) {
			
			//THINK_FURTHER: I prefer function over direct code because it focuses on decoupling
			removeDuplicatesHelper( pivot );
			pivot = pivot.next;
		}
		
	}
 
	
	
	private static void removeDuplicatesHelper(LinkedListNode uniqueNode) {
		
		LinkedListNode current = uniqueNode.next;
		LinkedListNode prev = uniqueNode;
		
		if( current == null ) {
			return;
		}
		
		
		while( current != null ) {
			
			if( current.data != uniqueNode.data ) {
				//remove to remain uniqueness
				prev = current;
				current = current.next;
			}
			else {
				prev.next = current.next;
				current = current.next;
			}
		}
		
	}
}





