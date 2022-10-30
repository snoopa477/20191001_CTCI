package c02_LinkedList.p01_RemoveDups;
import static java.lang.System.out;

import java.util.HashSet;

import util.LinkedListNode;



public class RemoveDups_01_Buffer {
	

	public static void removeDuplicates( LinkedListNode head ) {
		
		HashSet<Integer> visitedValues = new HashSet<>();
		
		//DETAIL: use two pointers
		//under the premise no parent node, 'prev' serve as assistant of current, 
		//left next to current by one node
		LinkedListNode prev = null;
		//check the value
		LinkedListNode current = head;
		
		//iterate through the link list
		//WRONG: even the last node has to be considered
		//while( current.next != null ) {
		while( current != null ) {
			
			
			//if duplicate, remove the current node by circumventing the current, resulting in GC 
			if( visitedValues.contains( current.data ) ) {
				//removing
				prev.next = current.next;
				/*REASONING, now prev points to a node that is not pointed by current; 
				 * the property 'left to current' is not held. Fix it by re-assign current
				 */
				//X:prepare for the next iteration
				current = current.next;
				
				//THINK_FURTHER why doesn't prev follow up to current? Removing
			}
			//since it is first visit and is visited, add this to the set
			else {
				visitedValues.add( current.data );
				
				//prepare for the next iteration
				//DETAIL: if prev wants to follow up current by one step, then prev moves before current does
				//THINK_FURTHER: in other perspective, they maintain the property: 'left to current by one node'
				prev = current;
				current = current.next;
			}
			
			
		}
		
	}
	
}


