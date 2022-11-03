package c02_LinkedList.p02_ReturnKthToLast;
import static java.lang.System.out;

import util.LinkedListNode;
public class ReturnKthToLast_01_boomerang {
	
	
	public static void showKthToLast( LinkedListNode head, int k ) {
		
		int height = showKthToLastHelper(head, k);
		
		//if height < k, then there doesn't exist k th to last situation
		if( height < k ) {
			out.println("there exists no " + k + "th to last situation, because only "  + height + "nodes");
		}
		
	}
	
	
	
	/**
	 * print the message if the node is kth to the last node
	 * @param head
	 * @param n
	 * @return nth to last. For example, the last node returns 1; second last node returns 2
	 */
	/*
	 * THINK_FURTHER: there are two things we'd like to pass from subfunction to function:
	 * 1. the node that is kth to the last,
	 * 2. the number: kth to the last
	 * However, return key word only allows one thing to be passed, so the number kth to the last
	 * has high precedence over the node because without it, the node cannot be implied
	 * Therefore, the function can only 'show' the node, instead of 'getting' it  
	 */
	private static int showKthToLastHelper( LinkedListNode head, int k) {
		
		//for base case only
		if( head == null) {
			//PURPOSE: define the null has height 0
			return 0;
		}
		
		//DETAIL: splitting the line into two makes it understandable for me
		//int height = showKthToLastHelper( head.next, k) + 1;
		int oldHeight = showKthToLastHelper( head.next, k);
		/*REASONING: operate on sub function result is post-order, or boomerang. the caller's height
		 * is greater than the sub function's result by one 
		 */
		//height += 1;
		int currentHeight = oldHeight + 1;
		
		if( currentHeight == k ) {
			out.println("the " + k + " to the last node value is " + head.data );
		}
		
		return currentHeight;
	}

}


