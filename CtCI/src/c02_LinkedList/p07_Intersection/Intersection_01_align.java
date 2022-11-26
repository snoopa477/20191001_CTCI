package c02_LinkedList.p07_Intersection;
import static java.lang.System.out;
import util.LinkedListNode;


public class Intersection_01_align {
	
	public static LinkedListNode getIntersection( LinkedListNode head1, LinkedListNode head2 ) {
		
		if( head1 == null || head2 == null ) {
			return null;
		}
		
		/* REASONING:
		 * check if they have intersection.
		 * if they have common tail -> they have intersection; 
		 * otherwise they don't have intersection
		 */
		
		if( getTail(head1) != getTail(head2) ) {
			return null;
		}
		
		//reaching here meaning they have intersection
		
		/* given they have intersection
		 * if both list have same length and iterate together at the same time,
		 * the pointers will meet each other.
		 * The first meeting each other is the first intersection
		 */
		
		//PURPOSE: to meet the same length condition, trim the longer list to the same length as shorter one
		int len1 = getLength(head1);
		int len2 = getLength(head2);
		
		LinkedListNode headSameLen1 = len1 > len2?  forward(head1, len1 - len2): head1;
		LinkedListNode headSameLen2 = len1 > len2?  head2: forward(head1, len2 - len1);
		
		
		LinkedListNode currentSameLen1 = headSameLen1;
		LinkedListNode currentSameLen2 = headSameLen2;
		
		while( currentSameLen1 != currentSameLen2 ) {
			currentSameLen1 = currentSameLen1.next;
			currentSameLen2 = currentSameLen2.next;
		}
		
		return currentSameLen1;
	}
	
	
	
	private static LinkedListNode getTail( LinkedListNode head ) {
		
		if( head == null ) {
			return null;
		}
		
		LinkedListNode current = head;
		while( current.next != null ) {
			current = current.next;
		}
		
		return current;
	}
	
	
	
	private static int getLength( LinkedListNode head ) {
		
		if( head == null ) {
			return 0;
		}
		
		//DETAIL if it is height, the starting number is -1
		int length = 0;
		
		LinkedListNode current = head;
		while( current.next != null ) {
			length++;
			current = current.next;
		}
		
		
		return length;
	}
	
	
	
	private static LinkedListNode forward( LinkedListNode head, int num ) {
		
		LinkedListNode current= head;
		for( int i = 0; i < num; i++ ) {
			current = current.next;
		}
		
		return current;
	}
	

}


