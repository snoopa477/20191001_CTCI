package c02_LinkedList.p08_LoopDetection;
import static java.lang.System.out;

import java.util.Optional;

import util.LinkedListNode;
public class LoopDetection_01_fastSlow {

	
	public static boolean IS_DEBUG = false;
	
	public static LinkedListNode findBeginningOfCircle(LinkedListNode head) {
		
		/**
		 * REASONING and PURPOSE:
		 * Step 1 
		 * given we have slow that moves 1 node in one iteration,
		 * and fast that moves 2 node in one iteration,
		 * if and only if there exists a circle, fast would outrun slow and catch up slow from the back
		 * ; in the mean time slow = fast.
		 * 
		 * Step 2
		 * after n iteration, fast is ahead slow by n nodes.
		 * Suppose slow takes m steps to go from start to beginning of circle, when slow arrives at
		 * the beginning, fast is ahead slow by m nodes.
		 * 
		 * To make fast catch up slow, it takes length(circle) - m iterations.
		 * Given fast catches up slow from behind, slow moves length(circle) - m nodes from the beginning of circle.
		 * Right now, slow only takes further m nodes to reach the circle, if we dispatch another slow(called slow2) 
		 * which starts at the starting point, slow and slow2 would meet at the beginning of the circle.
		 * 
		 */
		
		//PURPOSE step1 
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		
		//stop condition: slow== null || fast == null || slow == fast
		do {
		//WRONG the initial state already meet stop condition
		//while(  (slow != null && fast != null) && slow != fast  ) {
			slow = slow.next;
			fast = fast.next;
			//WRONG: forget to add
			if( fast != null ) {
				fast = fast.next;
			}
			
		}while(  (slow != null && fast != null) && slow != fast  );
		
		
		//this is not circle, end it
		if( slow == null || fast == null ) {
			return null;
		}
		
		/*reaching here meaning it's circle and fast meets slow,
		 * and the number of nodes slow requires to reach beginning of circle 
		 * equals to the number alternative slow goes from start to beginning of circle
		 * let them meet 
		 */
		//PURPOSE step2
		
		LinkedListNode slow2 = head;
		
		while( slow != slow2 ) {
			slow = slow.next;
			slow2 = slow2.next;
		}
		
		
		//they meet at the beginning of the circle
		return slow;
	}
	
}


