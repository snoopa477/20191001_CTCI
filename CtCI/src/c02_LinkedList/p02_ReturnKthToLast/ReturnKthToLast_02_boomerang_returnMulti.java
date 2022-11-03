package c02_LinkedList.p02_ReturnKthToLast;
import static java.lang.System.out;

import util.LinkedListNode;
public class ReturnKthToLast_02_boomerang_returnMulti {
	
	/**
	 * To remedy the problem stated from way01: there can only be one thing to pass from sub function
	 * to function. This time we'd like to pass two things
	 * 1. kth to last node
	 * 2. the number kth to last
	 * 
	 *  we put kth to last node in return keyword since this is answer to the question
	 *  the other is put in HeightWrapper object, which is 'shared' among all function in call stacks, 
	 *  freeing us the problem of locality of a variable
	 */
	//WRONG, why
	//public class HeightWrapper{
	public static class HeightWrapper{
		public int height;
		
		//just want to enhance readability
		public HeightWrapper() {
			height = 0;
		}
	}
	
	
	
	public static LinkedListNode getKthToLast( LinkedListNode head, int k ) {
		
		HeightWrapper heightWrapper = new HeightWrapper(); 
		return getKthToLastHelper(head, k, heightWrapper);
		
	}



	private static LinkedListNode getKthToLastHelper( LinkedListNode head, int k, HeightWrapper heightWrapper) {
	
		//for base case only
		if( head == null) {
			//the commented line is the case's actual operation; however the height initialized value is same as 0 
			//heightWrapper.height = 0;
			
			/*PURPOSE null node is not within the boundary of the problem: kth to last. 
			 * Unless k = -1. So we we return null
			*THINK_FURTHER: or, we can interpret the null as we set default answer as not found
			*, and it could be replaced by the real answer
			*/
			return null;
		}
		

		LinkedListNode node = getKthToLastHelper( head.next, k, heightWrapper);
		//operation's after sub call, meaning post-order
		/*DETAIL: spot the nuances that the left side is the new value for this function; 
		 * the right side is the value for sub function,
		 * even though the share the same name
		 * 
		 */
		heightWrapper.height = heightWrapper.height + 1; 
		
		//for the specifice case
		if( heightWrapper.height == k ) {
			return head;
		}
		
		/*DETAIL: for common cases, just pass the result from sub function's result
		 * , which is either null ( not found ) or the answer
		 */
		return node;
	}
}


