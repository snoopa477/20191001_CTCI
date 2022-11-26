package c02_LinkedList.p07_Intersection;
import static java.lang.System.out;

import java.util.Optional;
import java.util.StringJoiner;

import util.LinkedListNode;
public class Test_Intersection {

	public static void main(String[] args) {
		
		
		LinkedListNode list1 = getList(3,1,5,9,7,2,1);
		
		out.println("++++ test last N ++++");
		int len1 = getLength(list1);
		out.println("len is " + len1 );
		
		showList(list1);
		//WRONG
		for( int i = 0; i <= len1; i++ ) {
		//for( int i = 1; i <= len1; i++ ) {
			LinkedListNode lastNNode = getLastN(list1, i);
			//BAD
			//out.println("the last " + i + "th node is " + getLastN(list1, i).data );
			out.println("the last " + i + "th node is " 
				//+ Optional.ofNullable( String.valueOf( lastNNode.data ) ).orElse("Null"));
					+ Optional.ofNullable( lastNNode ) );
		}
		
		
		
		LinkedListNode list2 = appendToHead( getLastN(list1, 3), 4, 6) ;
		showList(list2);
		
		LinkedListNode list3 = getList(2,7,1,7,0);
		
		
		{
			out.println("\n++++ Intersection_01_align ++++");
			
			LinkedListNode intersection = Intersection_01_align.getIntersection(list1, list2);
			showList(list1);
			showList(list2);
			out.println(" this intersecion is " + Optional.ofNullable(intersection) );
			
			showList(list1);
			showList(list3);
			intersection = Intersection_01_align.getIntersection(list1, list3);
			out.println(" this intersecion is " + Optional.ofNullable(intersection) );
		}
		
		
		{
			out.println("\n++++ Intersection_02_allInOneTraverse ++++");
			
			LinkedListNode intersection = Intersection_02_allInOneTraverse.getIntersection(list1, list2);
			showList(list1);
			showList(list2);
			out.println(" this intersecion is " + Optional.ofNullable(intersection) );
			
			showList(list1);
			showList(list3);
			intersection = Intersection_01_align.getIntersection(list1, list3);
			out.println(" this intersecion is " + Optional.ofNullable(intersection) );
		}
		
		
		
	}
	
	
	
	private static class Boomerang{
		public int counter;
		public LinkedListNode node;
		
		public Boomerang(int counter, LinkedListNode node) {
			super();
			this.counter = counter;
			this.node = node;
		}
		
	}
	
	
	
	public static LinkedListNode getLastN( LinkedListNode head, int n ) {
		return getLastNBoomerang(head, n).node;
	}
	
	
	
	public static Boomerang getLastNBoomerang( LinkedListNode head, int n ) {
		
		//inversion point
		if( head == null ) {
			return new Boomerang( 0 , null);
		}
		
		
		//pre
		Boomerang boomerang = getLastNBoomerang(head.next, n);
		
		//post
		boomerang.counter++;
		
		
		//post-target case
		if( boomerang.counter == n ) {
			boomerang.node = head;
			return boomerang;
		}
		
		//post-default case
		return boomerang;
	}
	
	
	
	public static LinkedListNode appendToHead(LinkedListNode laterHead, int... keys ) {
		
		LinkedListNode formerHead = getList( keys );
		LinkedListNode formerTail = formerHead;
		while( formerTail.next != null ) {
			formerTail = formerTail.next;
		}
		
		formerTail.next = laterHead;
		
		return formerHead;
	}
	
	
	public static LinkedListNode getList(int... keys) {
		
		LinkedListNode head = null;
		LinkedListNode tail = null;
		for( int key : keys) {
			
			//first time
			if( head == null ) {
				head = new LinkedListNode( key );
				tail = head;
			}
			//not first time creation 
			else {
				LinkedListNode newNode = new LinkedListNode( key );
				tail.next = newNode;
				tail = tail.next;
			}
		}
		return head;
	}
	
	
	
	
	private static int getLength( LinkedListNode head ) {
		
		if( head == null ) {
			return 0;
		}
		
		//DETAIL if it is height, the starting number is -1
		int length = 0;
		
		LinkedListNode current = head;
		//WRONG: don't confuse with 'continue condition' and 'stop condition'
		//while( current.next != null ) {
		while( current != null ) {
			length++;
			current = current.next;
		}
		
		
		return length;
	}
	
	
	
	public static void showList( LinkedListNode head ) {
		
		LinkedListNode current = head;
		
		StringJoiner sj = new StringJoiner(" -> ");
		
		while( current != null ) {
			sj.add( String.valueOf( current. data) );
			//WRONG: forget to add
			current = current.next;
		}
		
		out.println(sj.toString());
		
	}

}


