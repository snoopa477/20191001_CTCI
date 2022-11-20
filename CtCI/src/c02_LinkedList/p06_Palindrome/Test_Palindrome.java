package c02_LinkedList.p06_Palindrome;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

import util.LinkedListNode;
public class Test_Palindrome {
	
	public static void main( String[] args) {
	
		LinkedListNode list1234321 = getList(1,2,3,4,3,2,1);
		LinkedListNode list1234329 = getList(1,2,3,4,3,2,9);
		LinkedListNode list1221 = getList(1,2,2,1);
		LinkedListNode list1222 = getList(1,2,2,2);
		ArrayList<LinkedListNode> listOfLists = new ArrayList<>(
				Arrays.asList(list1234321,
						list1234329, 
						list1221, 
						list1222)
			);
		
		out.println("+++++ Palindrome_01_copyReverse ++++++");
		{
			Palindrome_02_stack.IS_DEBUG = false;
			for( LinkedListNode list : listOfLists ) {
				out.println(" - - - - -");
				showList(list);
				out.println("is this palindrome? " + Palindrome_01_copyReverse.checkPalindrome(list));
				
			}
		}
		
		
		//Palindrome_02_stack
		out.println("+++++ Palindrome_02_stack ++++++");
		{
			Palindrome_02_stack.IS_DEBUG = false;
			for( LinkedListNode list : listOfLists ) {
				out.println(" - - - - -");
				showList(list);
				out.println("is this palindrome? " + Palindrome_02_stack.checkPalindrome(list));
				
			}
		}
		
		
		//Palindrome_03_halfBoomerang
		out.println("+++++ Palindrome_03_halfBoomerang ++++++");
		{
			Palindrome_03_halfBoomerang.IS_DEBUG = false;
			
			for( LinkedListNode list : listOfLists ) {
				out.println(" - - - - -");
				showList(list);
				out.println("is this palindrome? " + Palindrome_03_halfBoomerang.checkPalindrome(list));
				
			}
			
		}
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


