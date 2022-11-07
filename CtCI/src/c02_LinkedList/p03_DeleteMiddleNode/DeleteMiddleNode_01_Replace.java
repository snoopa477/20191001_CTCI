package c02_LinkedList.p03_DeleteMiddleNode;
import static java.lang.System.out;

import util.LinkedListNode;
public class DeleteMiddleNode_01_Replace {
	
	public static boolean remove( LinkedListNode current ) {
		
		//prerequisite to remove node
		if( current == null || current.next == null) {
			return false;
		}
		
		LinkedListNode next = current.next;
		
		/* PURPOSE:
		 * we delete target's 'data' by replacing the target's data with next's data
		 * we delete a node object  by circumventing the 'next' node
		 
		 * in user's view of point, the absence of target's data means deletion, 
		 * although the deleted object is next, target object still exists, holding a copy of 
		 * next obj's data 
		 */
		//THINK_FURTHER this is similar to Red Black Tree delete operation
		
		current.data = next.data;
		//DETAIL: if next.next is null, that means current is tail
		current.next = next.next;
		
		
		//temp
		return true;
	}
	

}


