package c03_StacksAndQueues.p05_SortStack;
import static java.lang.System.out;

import util.MyStack;
public class SortStack_01_onlyByOtherStack {

		
	public static void sort( MyStack<Integer> sourceStack ) {
		
		MyStack<Integer> sortedDescStack = new MyStack<>();
		
		//MY OPINION: one operation deals with two situations; I feel a bit complicated
		/**
		 * in each iteration we consume the peek() of sourceStack, 
		 * or the elements from sortedDescStack, which are temporarily stored in sourceStack, 
		 * viewed as a part of sourceStack, being processed with the same policy.
		 * 
		 * the consumed element from sourceStack becomes part of sortedDescStack 
		 * 
		 * e.g. 
		 * sourceStack		:   7  10  [5]
		 * sortedDescStack	:   1   3   8  12
		 * 
		 * temp:			:  [5]
		 * sourceStack		:   7  10 [12   8]
		 * sortedDescStack	:   1   3
		 * 
		 * temp:			:  
		 * sourceStack		:   7  10 [12   8]
		 * sortedDescStack	:   1   3 [5]
		 * 
		 * - - 
		 * [x]				: null, dummy element
		 * temp:			:  
		 * sourceStack		:   7  10  12  [8]
		 * sortedDescStack	:   1   3   5  [x]
		 * 
		 * temp:			:  [8]  
		 * sourceStack		:   7  10  12  [x]
		 * sortedDescStack	:   1   3   5
		 * 
		 * temp:			:  
		 * sourceStack		:   7  10  12  [x]
		 * sortedDescStack	:   1   3   5  [8]
		 */
		while( sourceStack.isEmpty() == false ) {
			
			//int temp;
			int topFromSource = sourceStack.pop();
			
			/*PURPOSE: temporarily removes elements that are larger than elementFormSource, 
			 * setting them aside at sourceStack
			 * 
			 * After putting topFromSource to sortedDescStack, put them back
			 * Together they integrate into a new sorted desc elements
			 */
			while( sortedDescStack.isEmpty() == false 
				&& topFromSource < sortedDescStack.peek() ) {
				
				sourceStack.push( sortedDescStack.pop() );
			}
			
			sortedDescStack.push( topFromSource );
		}
		
		
		MyStack<Integer> sortedStack = sourceStack;
		while( sortedDescStack.isEmpty() == false ) {
			sortedStack.push( sortedDescStack.pop() );
		}
		
	}
		

}


