package c02_LinkedList.p06_Palindrome;
import static java.lang.System.out;

import java.util.Stack;

import util.LinkedListNode;
public class Palindrome_02_stack {

	
	public static boolean IS_DEBUG = false;
	
	public static boolean checkPalindrome( LinkedListNode head ) {
		
		
		/* PURPOSE: 
		 * 1. first half is stored in stack
		 * 
		 * 2. when iterating second half, each element in second half is compared with
		 * popped element from stack, which is the reverse first half.
		 * 
		 */
		
		/* GENERAL_IDEA
		 * using fast and slower pointer to reach the middle point, separating two halves
		 * at the meantime, store each element in first half to stack
		 * 
		 * DETAIL: stop right after the X:middle point O: the last element of first half 
		 * for even number
		 * 1 - 2 - 3 - 4
		 * 1 - 2 - [3] - 4 - {X}
		 * 
		 * for odd number 
		 * 1 - 2 - 3 - 4 - 5
		 * 1 - 2 - [3] - 4 - {5}
		 * 
		 * [] is slow, {} is fast, X is null
		 */
		
		//collector
		LinkedListNode slow = head;
		//seeker
		LinkedListNode fast = head;
		Stack<LinkedListNode> reverseFirstHalf = new Stack<>();
		
		while( !(fast == null || fast.next == null) ) {
			reverseFirstHalf.add(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		
		/*PURPOSE: compare each element in stack with second half; however
		 * , we need to check whether 'slow' is at the first element of second half
		 */
		
		/* if list has EVEN number of nodes, the 'slow' stops right after last element 
		 * of first half, and that is the first element of second half, so it is at 
		 * the right position; that means we do nothing
		 *  
		 * if fast is null, the list has even number
		 * 
		 * if list has ODD number of nodes, the 'slow' stops right after last element 
		 * of first half, and that is at the MIDDLE of list. We need to move 'slow'
		 * by one node to the position where the first element of second half 
		 * 
		 * if 'fast' is not null, the list has odd number
		 */
		
		//the list has odd number, move 'slow' by one node, so it is at first element of 2nd half
		if( fast != null ) {
			slow = slow.next;
		}
		
		//REASONING: reaching here meaning 'slow' at first element of second half
		//PURPOSE: compare each element in stack with second half; however
		LinkedListNode current = slow;
		
		//THINK_FURTHER: reaching here meaning iterating time of current = size of stack, so no worry pop out when 0 size
		while( current != null ) {
			int poppedData = reverseFirstHalf.pop().data;
			if( IS_DEBUG ) out.println("current.data :" + current.data + ", reverseFirstHalf.pop(): " + poppedData);
			if( current.data != poppedData ) {
				return false;
			}
			//WRONG forget to add
			current = current.next;
		}

		
		return true;
	}
	
	
	
}


