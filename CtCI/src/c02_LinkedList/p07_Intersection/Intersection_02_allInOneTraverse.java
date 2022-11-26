package c02_LinkedList.p07_Intersection;
import static java.lang.System.out;

import util.LinkedListNode;
public class Intersection_02_allInOneTraverse {
	
	
	//private static class TailAndLength{
	private static class CompositeInfo{
		LinkedListNode tail;
		int length ;
		
		public CompositeInfo(LinkedListNode tail, int length) {
			this.tail = tail;
			this.length = length;
		}
	}
	
	
	
	public static LinkedListNode getIntersection( LinkedListNode head1, LinkedListNode head2 ) {
		
		//BETTER: if head1 == null => tail is null as well
		if( head1 == null || head2 ==null ) {
			return null;
		}
		
		
		CompositeInfo info1 = getCompositeInfo( head1 );
//		if( info1.tail == null ) {
//			return null;
//		}
		
		CompositeInfo info2 = getCompositeInfo( head2 );
//		if( info2.tail == null ) {
//			return null;
//		}
		
		
		if( info1.tail != info2.tail ) {
			return null;
		}
		
		
		int len1 = info1.length;
		int len2 = info2.length;
		
		LinkedListNode headSameLen1 = len1 > len2?  forward(head1, len1 - len2): head1;
		LinkedListNode headSameLen2 = len1 > len2?  head2: forward(head1, len2 - len1);
		
		
		LinkedListNode currentSameLen1 = headSameLen1;
		LinkedListNode currentSameLen2 = headSameLen2;
		
		while( currentSameLen1 != currentSameLen2 ) {
			currentSameLen1 = currentSameLen1.next;
			currentSameLen2 = currentSameLen2.next;
		}
		
		return currentSameLen1;
	}
	
	
	//PURPOSE: One traverse, get all information we need to deal with this problem
	private static CompositeInfo getCompositeInfo( LinkedListNode head ) {
		
		//TailAndLength tailAndLength = new TailAndLength();
		//DETAIL: making it more intuitive
		CompositeInfo compositeInfo = new CompositeInfo(null, 0);
		
		if( head == null ) {
			return compositeInfo;
		}
		
		LinkedListNode current = head;
		while( current.next != null ) {
			compositeInfo.length++;
			current = current.next;
		}
		compositeInfo.tail = current;
		
		
		return compositeInfo;
	}
	
	
	
	private static LinkedListNode forward( LinkedListNode head, int num ) {
		
		LinkedListNode current= head;
		for( int i = 0; i < num; i++ ) {
			current = current.next;
		}
		
		return current;
	}
}


