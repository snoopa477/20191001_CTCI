package c02_LinkedList.p06_Palindrome;
import static java.lang.System.out;

import util.LinkedListNode;
public class Palindrome_03_halfBoomerang {

	public static boolean IS_DEBUG = false;
	/**
	 * the realResult.currentResult = 
	 * 	compareResultFromHeight0 &
	 * 	compareResultFromHeight1 &
	 * 	compareResultFromHeight2 & ...    
	 * 
	 * compareResult is the compare with current node and symmetric node
	 */
	private static class RealResult{
		boolean currentResult = true;
		LinkedListNode symmetricNode = null;
		
		public RealResult(LinkedListNode symmetricNode) {
			super();
			this.symmetricNode = symmetricNode;
		}
	}
	
	
	public static boolean checkPalindrome( LinkedListNode head ) {
		
		int height = getHeight(head);
		if( IS_DEBUG ) out.println("the height is " + height );
		RealResult realResult = checkPalindrome( head, height );
		
		return realResult.currentResult;
	}
	
	
	/**
	 * 
	 * height  3    1     -1  
	 * list    1 -> 2 -> {[3]} -> 4
	 * 
	 * height  4    2     0 
	 * list    1 -> 2 -> [3] -> {4} -> 5
	 *  
	 *  []: slow
	 *  {} symmetric node
	 */
	
	/**
	 * notice that the post: each return of function means iteration from 
	 * last element of first half list to first element of first half list.
	 * each element of first half list compares with its symmetric node, which is at the second half list.
	 * @param head
	 * @return symmetric node
	 */
	public static RealResult checkPalindrome( LinkedListNode head, int fastPointerHeight ) {
		
		//base case, inversion point
		/*REASONING if list has even number, fast's height is -1 when slow at
		 * the next node of the last element in first half,
		 * which is first element of second half, symmetric to last of first half
		 */
		if( fastPointerHeight == -1 ) {
			return new RealResult( head );
		}
		
		/*REASONING if list has odd number, fast's height is 0 when slow at
		 * the next node of the last element in first half,
		 * which is the middle. 
		 * to get first element of second half, move by one node
		 */
		if( fastPointerHeight == 0 ) {
			return new RealResult( head.next );
		}
		
		//PRE
		//get to the inversion point
		RealResult result = checkPalindrome(head.next, fastPointerHeight -2 );
		
		if( IS_DEBUG ) out.println("head.data: " + head.data + ", result.symmetricNode.data " + result.symmetricNode.data);
		//POST
		//Now, compare current node and symmetric node
		if( result.currentResult == false ) {
			//one is false and it is not palindrome, forget about remaining calculation
			return result;
		}
		
		if( result.symmetricNode.data == head.data ) {
			//so far, past result is true, and current result is ok; prepare for next iteration
			result.symmetricNode = result.symmetricNode.next;
		}
		else {
			//one is false and it is not palindrome, forget about remaining preparation
			result.currentResult = false;
		}
		
		return result;
	}
	
	
	
	public static int getHeight( LinkedListNode head ) {
		
		if( head == null ) {
			return -1;
		}
		
		//WRONG
		//int height = 0;
		int height = -1;
		LinkedListNode current = head;
		while( current != null) {
			height++;
			current = current.next;
		}
		
		return height;
	}
	
}


