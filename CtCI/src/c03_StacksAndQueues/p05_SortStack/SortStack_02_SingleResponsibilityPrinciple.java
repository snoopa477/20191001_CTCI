package c03_StacksAndQueues.p05_SortStack;
import static java.lang.System.out;

import util.MyStack;
public class SortStack_02_SingleResponsibilityPrinciple {
public static void sort( MyStack<Integer> sourceStack ) {
		
		MyStack<Integer> sortedDescStack = new MyStack<>();
		
		/**
		 * in each iteration we consume the peek() of sourceStack, 
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
		 * sortedDescStack	:   1   3  [5]
		 * 
		 * temp:			:  
		 * sourceStack		:   7  10 
		 * sortedDescStack	:   1   3  [5][ 8  12]

		 */
		while( sourceStack.isEmpty() == false ) {
			
			int topFromSource = sourceStack.pop();
			
			/*PURPOSE: temporarily removes elements that are larger than elementFormSource, 
			 * setting them aside at sourceStack
			 * 
			 * After putting topFromSource to sortedDescStack, put them back
			 * Together they integrate into a new sorted desc elements
			 */
			int numberOfElementsFromSorted = 0;
			while( sortedDescStack.isEmpty() == false 
				&& topFromSource < sortedDescStack.peek() ) {
				
				sourceStack.push( sortedDescStack.pop() );
				numberOfElementsFromSorted++;
			}
			
			sortedDescStack.push( topFromSource );
			
			//PURPOSE: put them back
			for( int i=0; i< numberOfElementsFromSorted; i++) {
				sortedDescStack.push( sourceStack.pop() );
			}
			
			//WRONG: don't wrong sequence
			//sortedDescStack.push( topFromSource );
		}
		
		
		MyStack<Integer> sortedStack = sourceStack;
		while( sortedDescStack.isEmpty() == false ) {
			sortedStack.push( sortedDescStack.pop() );
		}
		
	}
}


