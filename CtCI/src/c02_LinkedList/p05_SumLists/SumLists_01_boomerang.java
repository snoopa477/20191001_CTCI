package c02_LinkedList.p05_SumLists;
import static java.lang.System.out;
import util.LinkedListNode;


/* least Significant digit -> significant digit
 *   X <- 4 <- 5 
 *   9 <- 8 <- 7
 * +)
 * ----------------
 */
public class SumLists_01_boomerang {
	
	public static final int ZERO = 0;
	public static final int TEN = 10;
	
	public static LinkedListNode add(  LinkedListNode operand1, LinkedListNode operand2 ) {
		
		return getNewNodeAfterAddition( operand1, operand2, 0 );
	}
	

	private static LinkedListNode getNewNodeAfterAddition( LinkedListNode operand1, LinkedListNode operand2, int carry ) {
		
		//WRONG
		//base case, or inversion point
		//REASONING: would call subcall only if both nodes exist
		//WRONG: if operand1 == null, however, operand2 = 9 and carry is 1, that is not the end
		//if( operand1 == null || operand2 == null ) {
//		if( carry == 0 && ( operand1 == null || operand2 == null ) ) {
//			int value1 = getValue(operand1);
//			int value2 = getValue(operand2);
//			int sumOfThisDigit = value1 + value2 + carry;
//			
//			/*REASONING if sumOfThisDigit > 0, convert this to node; else, since
//			 * we don't represent any 0 in preceding digit -> don't make any node
//			 */
//			if( sumOfThisDigit != ZERO ) {
//				//require two nodes to represent 2 digits
//				if( sumOfThisDigit >= TEN ) {
//					LinkedListNode node = new LinkedListNode( sumOfThisDigit % TEN);
//					LinkedListNode nextNode = new LinkedListNode( sumOfThisDigit / TEN);
//					node.setNext(nextNode);
//					return node;
//				}
//				//only require one node to represent 1 digit 
//				else {
//				return new LinkedListNode( sumOfThisDigit );
//				}
//			}
//			else {
//				return null;
//			}			
//			
//		}
		
		
		/* REASONING: When do we go back? 
		 * a destination digit value = operand1.data + opreand2.data + carry
		 * 0 1 1 1 0 -carry
		 * 0 0 9 9 9 -operand1.data
		 * 0 0 0 0 1 -opreand2.data
		 * ------------
		 * 0 1 0 0 0 -destination
		 * 
		 * destination value is zero ( carry is not taken out yet ) 
		 * only if both operand.data = 0 and carry = 0;
		 * since we don't have node that has zero value, 
		 * it is both operands are null and carry = 0 actually.
		 * 
		 * when destination value is 0, we can imply that a digit right of it is 
		 * most significant digit, and since we don't create any node that has value 0
		 * simply return null and go back.
		 */
		
		if( operand1 == null && operand2 == null && carry == 0 ) {
			return null;
		}
		
		
		//WRONG
		//REASONING: there's no way operand1 nor operand2 would be null
		//for this digit i, the value before carry is taken for the next digit i + 1
		//int sumOfThisDigit = operand1.data + operand2.data + carry;
		
		int sumOfThisDigit = getValue( operand1 ) + getValue( operand2 ) + carry;
		
		LinkedListNode node = new LinkedListNode( sumOfThisDigit % TEN);
		
		//from more significant digit
		//LinkedListNode nextNode = getNewNodeAfterAddition( operand1.next, operand2.next, sumOfThisDigit / TEN );
		LinkedListNode nextNode = getNewNodeAfterAddition( next( operand1 ), next( operand2 ), sumOfThisDigit / TEN );
		node.setNext(nextNode);
		
		
		return node;
	}
	
	
	
	private static int getValue( LinkedListNode operand ) {
		
		if( operand != null ) {
			return operand.data;
		}
		return 0;
	}
	
	
	
	private static LinkedListNode next( LinkedListNode operand ) {
		
		if( operand == null ) {
			return null;
		}
		return operand.next;
	}
	
	
	
}


