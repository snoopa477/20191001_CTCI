package c02_LinkedList.p05_SumLists;

import util.LinkedListNode;
import static java.lang.System.out;

public class SumListsFollowup_02_globalPackage {
	
	public static final int ZERO = 0;
	public static final int TEN = 10;

	
	/**
	 * This class serves as a sum wrapper, being accessed through out function stack
	 * 
	 * if a number looks like this: 1 0 0 0
	 * this could be represented as 
	 * 1 -> 0 -> 0 -> 0 
	 * carry = 1
	 * partial sum is 0 -> 0 -> 0
	 * 
	 * we call it real when paritalSum combined with carry
	 */
	 private static class RealSum{
		LinkedListNode paritalSumNode;
		int carry;
		
		public RealSum() {
			paritalSumNode = null;
			carry = 0;
		}

		public LinkedListNode getRealSum() {
			if( carry > 0 ) {
				LinkedListNode carryNode = new LinkedListNode( carry );
				carryNode.next = paritalSumNode;
				return carryNode;
			}
			else {
				return paritalSumNode;
			}
		}
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
		
		RealSum realSum = new RealSum();
		addToRealsum(operand1, operand2, realSum);
		
		return realSum.getRealSum();
	}
	
	
	
	public static void addToRealsum( LinkedListNode operand1, LinkedListNode operand2 , RealSum realSum) {
		
		if( operand1 == null && operand2 == null ) {
			return;
		}
		
		//WRONG: forget to add
		addToRealsum(operand1.next, operand2.next, realSum);
		
		//REASONING: since both operands are aligned, they both exist
		int digitSum = operand1.data + operand2.data + realSum.carry;
		
		//can only accommodate 0-9, other will be stroed in carry  
		LinkedListNode digitSumNode = new LinkedListNode( digitSum % TEN );
		int carry = digitSum / TEN;
		
		//update realSum
		//REASONING: by far the local most significant digit, be the head
		digitSumNode.next = realSum.paritalSumNode;
		realSum.paritalSumNode = digitSumNode;
		realSum.carry = carry;
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


