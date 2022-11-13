package c02_LinkedList.p05_SumLists;
import static java.lang.System.out;

import java.util.StringJoiner;

import util.LinkedListNode;

public class Test_SumListsFollowup {

	public static final int TEN = 10;
	
	public static void main(String[] args) {
		
		int[] numbers = {45, 987};
		
		for(  int number: numbers) {
			LinkedListNode digitList = makeDigitList( number );
			out.println( geListStr(digitList) );
		}
		
		
		LinkedListNode digitList0 = makeDigitList( numbers[0] );
		LinkedListNode digitList1 = makeDigitList( numbers[1] );
		
		LinkedListNode digitList_sum = SumListsFollowup_01_boomerang.add(digitList0, digitList1);
		out.println( geListStr(digitList_sum) );
			
		
	}
	
	/**
	 * e.g. input: 987
	 * e.g. output: 9 -> 8 -> 7
	 * @param number
	 * @return
	 */
	public static LinkedListNode makeDigitList(int number) {
		
		LinkedListNode digitList_Head = null;
		
		while( number > 0 ) {
			int numInDigit = number %TEN;
			LinkedListNode digitNode = new LinkedListNode( numInDigit );
			
			if( digitList_Head == null ) {
				digitList_Head = digitNode;
			}
			else {
				digitNode.next = digitList_Head;
				digitList_Head = digitNode;
			}
			
			//numInDigit is consumed, prepare for next loop by moving it right by one digit
			number = number /TEN;
		}
		
		return digitList_Head;
	}
	
	
	
	public static String geListStr(LinkedListNode list) {
		
		LinkedListNode current = list;
		StringJoiner sj = new StringJoiner("->");
		
		while( current != null ) {
			sj.add(""+ current.data);
			current = current.next;
		}
		
		return sj.toString();
	}
}


