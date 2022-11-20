package c02_LinkedList.p06_Palindrome;
import static java.lang.System.out;

import util.LinkedListNode;
public class Palindrome_01_copyReverse {
	
	public static boolean checkPalindrome( LinkedListNode head ) {
		
		
		LinkedListNode reverseNode = copyReverse( head );
		
		//under the premise they have same length
		LinkedListNode current = head;
		LinkedListNode reverseCurrent = reverseNode;
		while( current != null ) {
			
			if( current.data != reverseCurrent.data ) {
				return false;
			}
			
			current = current.next;
			reverseCurrent = reverseCurrent.next;
		}
		
		return true;
	}
	
	
	
	private static LinkedListNode copyReverse( LinkedListNode head ) {
		
		LinkedListNode reverseHead = null;
		LinkedListNode current = head;
		while( current != null ) {
			
			LinkedListNode newNode = new LinkedListNode( current.data );
			//newNode, newHead, now it points to old head, which is current head
			newNode.next = reverseHead;
			reverseHead = newNode;
			
			current = current.next;
		}
		
		return reverseHead;
	}

}


