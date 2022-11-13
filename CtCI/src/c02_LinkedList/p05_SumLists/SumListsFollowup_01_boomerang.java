package c02_LinkedList.p05_SumLists;
import static java.lang.System.out;

import util.LinkedListNode;

/*Significant digit -> least significant digit
*   0 -> 4 -> 5 
*   9 -> 8 -> 7
* +)
* ----------------
*/
public class SumListsFollowup_01_boomerang {
	
	public static final int ZERO = 0;
	public static final int TEN = 10;
	
	private static class CarryWrapper{
		int value = 0;
	}
	
	public static LinkedListNode add( LinkedListNode operand1, LinkedListNode operand2 ) {
		
		//PURPOSE: alignment
		int len1 = getLength(operand1);
		int len2 = getLength(operand2);
		if( len1 > len2 ) {
			operand2 = leftPadWithZero(operand2, Math.abs(len1 - len2));
		}
		else if( len1 < len2 ){
			operand1 = leftPadWithZero(operand1, Math.abs(len1 - len2));
		}
		
		
		CarryWrapper carryWrapper = new CarryWrapper();
		LinkedListNode sumList = getNewNodeAfterCall(operand1, operand2, carryWrapper );
		/*PURPOSE: final check if 'current' most significant digit node has non-zero carry;
		 * if so, carry becomes the 'real' most sigificant digit node
		 */
		if( carryWrapper.value > 0 ) {
			//WRONG
			//sumList.setNext( new LinkedListNode( carryWrapper.value ) );
			
			LinkedListNode mostSignificantDigitNode = new  LinkedListNode( carryWrapper.value );
			mostSignificantDigitNode.setNext(sumList);
			return mostSignificantDigitNode;
		}
		
		return sumList;
		
	}
	
	
	
	private static LinkedListNode getNewNodeAfterCall( LinkedListNode operand1, LinkedListNode operand2, CarryWrapper carryWrapper ) {
		
		//under the premise that list of opreand1 and operand2 have same length; when one is null the other must be null
		if( operand1 == null ) {
			return null;
		}
		
		//from less significant digit, along with carryWrapper
		LinkedListNode newNode = getNewNodeAfterCall(operand1.next, operand2.next, carryWrapper);
		
		//sumOfThisDigit for this digit
		int sumOfThisDigit = operand1.data + operand2.data + carryWrapper.value;
		//convert to node
		LinkedListNode node = new LinkedListNode( sumOfThisDigit %TEN );
		//IMAGINE: leftover?
		//update wrapper corresponding to this layer
		carryWrapper.value = sumOfThisDigit / TEN;
		node.setNext(newNode);
		
		return node;
	}
	
	
	
	private static int getLength( LinkedListNode node ) {
		
		int len = 0;
		
		while( node != null ) {
			len++;
			node = node.next;
		}
		return len;
	}
	
	
	
	private static LinkedListNode leftPadWithZero( LinkedListNode node, int numberOfZero ) {
		
		LinkedListNode head = node;
		
		for( int i = 0; i < numberOfZero; i++) {
			LinkedListNode nodeZero = new LinkedListNode( 0 );
			nodeZero.setNext(head);
			head = nodeZero;
		}
		
		return head;
	}

}


