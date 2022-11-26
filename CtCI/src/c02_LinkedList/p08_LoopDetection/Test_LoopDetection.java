package c02_LinkedList.p08_LoopDetection;
import static java.lang.System.out;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.StringJoiner;

import util.LinkedListNode;
public class Test_LoopDetection {
	
	public static boolean IS_DEBUG_CIRCLE = false;
	

	public static void main(String[] args) {
		
		out.println("++++ circle ++++");
		LinkedListNode circle = getListCicle(1,2,3,4,5,3);
		showListCicle(circle);
		
		LinkedListNode nonCicle = getListCicle(1,2,3,4,5,7,8);
		showListCicle(nonCicle);
		
		out.println("\n++++ LoopDetection_01_fastSlow ++++");
		LoopDetection_01_fastSlow.IS_DEBUG = false;
		
		showListCicle(circle);
		LinkedListNode beginningOfCircle = LoopDetection_01_fastSlow.findBeginningOfCircle(circle);
		out.println("beginningOfCircle " + Optional.ofNullable(beginningOfCircle));
		
		showListCicle(nonCicle);
		beginningOfCircle = LoopDetection_01_fastSlow.findBeginningOfCircle(nonCicle);
		out.println("beginningOfCircle " + Optional.ofNullable(beginningOfCircle));
		
		
		
	}
	
	
	
	//the list contains unique keys, meaning duplicate keys refers the same node, which makes circle
	public static LinkedListNode getListCicle(int... keys) {
		
		HashMap<Integer, LinkedListNode> keyToNode = new HashMap<>();
		
		LinkedListNode head = null;
		LinkedListNode tail = null;
		for( int key : keys) {
			
			//first time
			if( head == null ) {
				head = new LinkedListNode( key );
				keyToNode.put( key, head );
				tail = head;
			}
			//not first time creation 
			else {
				
				//make circle
				if( keyToNode.containsKey(key) ) {
					tail.next = keyToNode.get(key);
					tail = tail.next;
					//cannot further accept any keys otherwise it would get wrong( I guess) 
					return head;
				}
				
				LinkedListNode newNode = new LinkedListNode( key );
				//WRONG: forget to add
				keyToNode.put( key, newNode );
				tail.next = newNode;
				tail = tail.next;
			}
		}
		
		return head;
	}
	
	
	
	public static void showListCicle( LinkedListNode head ) {
		
		HashSet<LinkedListNode> visitedNodes = new HashSet<>();
		boolean isCircle = false;
		
		LinkedListNode current = head;
		
		StringJoiner sj = new StringJoiner(" -> ");
		
		while( current != null ) {
			
			if( IS_DEBUG_CIRCLE ) {
				out.println(current.hashCode() + " data: " + current.data);
			}
			
			//here comes the circle
			if(visitedNodes.contains(current)) {
				sj.add( String.valueOf( current. data) );
				isCircle = true;
				break;
			}
			
			visitedNodes.add(current);
			sj.add( String.valueOf( current. data) );
			//WRONG: forget to add
			current = current.next;
		}
		
		out.println( (isCircle? "circle:  ": "non-circle:  ") + sj.toString());
		
	}

}


