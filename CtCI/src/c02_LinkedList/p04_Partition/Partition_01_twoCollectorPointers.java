package c02_LinkedList.p04_Partition;
import static java.lang.System.out;

import util.LinkedListNode;
public class Partition_01_twoCollectorPointers {
	
	
	//public static void partition( LinkedListNode head, int key ) {
	public static LinkedListNode partition( LinkedListNode head, int key ) {
		
		if( head == null ) {
			return null;
		}
		/**
		 * IMAGINE
		 * even though smallPart, largePart, and current linkedList are conceptually different
		 * , they share the same link list 
		 */
		LinkedListNode smallPart_Head = null;
		LinkedListNode smallPart_Tail = null;
		
		LinkedListNode largePart_Head = null;
		LinkedListNode largePart_Tail = null;
		
		LinkedListNode current = head;
		/**
		 * Imagine: 
		 * every node behind current is appended to either smallPart_Tail 
		 * or largePart_Tail, meaning they're handled and processed, so current moves on
		 */
		while( current != null ) {
			
			//current belongs to smallPart
			if( current.data < key ) {
				
				//first element to add smallPart_Head
				if( smallPart_Head == null ) {
					smallPart_Head = current;
					smallPart_Tail = smallPart_Head;
				}
				//otherwise, append node at tail
				else {
					smallPart_Tail.next = current;
					//update tail 
					smallPart_Tail = smallPart_Tail.next;
				}
			}
			//current belongs to largePart
			//if( current.data >= key )
			else {
				//first element to add largePart_Head
				if( largePart_Head == null ) {
					largePart_Head = current;
					largePart_Tail = largePart_Head;
				}
				//otherwise, append node at tail
				else {
					largePart_Tail.next = current;
					//update tail 
					largePart_Tail = largePart_Tail.next;
				}				
			}
			
			current = current.next;
		}
		
		
		smallPart_Tail.next = null;
		largePart_Tail.next = null;
		
		
		smallPart_Tail.next = largePart_Head;
		
		return smallPart_Head;
		
	}

}





