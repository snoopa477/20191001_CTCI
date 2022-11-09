package c02_LinkedList.p04_Partition;
import static java.lang.System.out;

import util.LinkedListNode;
public class Partition_02_DequeHeadTail {

	//public static void partition( LinkedListNode head, int key ) {
	public static LinkedListNode partition( LinkedListNode head, int key ) {
		
		/**
		 * IMAGINE
		 * there exists a linked list ( we call it A ) which left side nodes' data are smaller than key,
		 * and right dies nodes' data larger than or equal to the key
		 * That list A coexist with current list
		 * even though they're conceptually different, they share the same link list
		 * as list A grows, current list shrinks; in other word, current list is converted to list A 
		 */
		
		if( head == null ) {
			return null;
		}
		
		LinkedListNode current = head;
		//put smaller nodes at left side
		LinkedListNode smallHead = current;;
		//put larger nodes at right side
		LinkedListNode largeTail = current;
		
		while( current != null ) {
			
			/*PURPOSE
			 * Chances are that the current node will be added to left side of list A by pointing 
			 * its next to list A's smallHead; if that's the case, we can no longer access current.next
			 * 
			 * Therefore, to prevent such situation, we need to backup the current.next first
			 */
			LinkedListNode next = current.next;
			
			
			if( current.data < key ) {
				//add current ot small partition
				current.next = smallHead;
				//update
				smallHead = current;
			}
			//current.data >= key
			else {
				//add current to large partition
				largeTail.next = current;
				largeTail = largeTail.next;
			}
			
			//proceed, prepare for next loop
			current = next;
		}
		
		
		largeTail.next = null;
		return smallHead;
		
	}
	
}


