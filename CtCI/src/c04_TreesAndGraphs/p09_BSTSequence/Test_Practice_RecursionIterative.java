package c04_TreesAndGraphs.p09_BSTSequence;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.LinkedList;
public class Test_Practice_RecursionIterative {
	
	private static final boolean IS_DEBUG_ON = false;

	public static void main(String[] args) {
		
		ArrayList<String> result01 = weaveCount(2, 2);
		out.println( result01 );
		out.println();
		
		result01 = weaveCount(3, 2);
		out.println( result01 );
		
		ArrayList<LinkedList<String>> result02 = weaveList(2,2);
		for( LinkedList<String> sequnce : result02 ) {
			out.println(sequnce);
		}
		
		
	}
	
	
	
	private static ArrayList<String> weaveCount(int countA, int countB) {
		
		ArrayList<String> result = new ArrayList<>();
		weaveCount( countA, countB, "", result );
		
		return result;
	}
	
	
	
	/* COMPARE the sub function call looks intuitive: argument is less than the caller's, and don't have to reinstate the argument, since they passed by value */
	private static void weaveCount(int countA, int countB, String intermediateString, ArrayList<String> result) {
	
		//PURPOSE: the bottom is reached, reap the final form of intermediate result
		//THINK_FURTHER: this condition would never be met, cuz we only update count one at a time
		/*
		if( countA == 0 && countA == countB ) {
			result.add( intermediateString );
			return ;
		}*/
		
		//WRONG: I forget to consider the following condition... that cause infinite calling loop
		if( countA == 0 ) {
			//PURPOSE: Consume the remaining without further calling
			while( countB > 0 ) {
				intermediateString += "B";
				countB--;
			}
			result.add( intermediateString );
			return;
		}
		
		
		if( countB == 0 ) {
			while( countA > 0 ) {
				intermediateString += "A";
				countA--;
			}
			result.add( intermediateString );
			return;
		}
		
		weaveCount( countA -1, countB, intermediateString + "A", result );
		weaveCount( countA, countB -1, intermediateString + "B", result );
	}
	
	
	
	private static ArrayList<LinkedList<String>> weaveList(int countA, int countB) {
		
		LinkedList<String> listA = new LinkedList<>();
		LinkedList<String> listB = new LinkedList<>();
		LinkedList<String> intermediateSequence = new LinkedList<>();
		ArrayList<LinkedList<String>> result = new ArrayList<>();
		
		for( int i = 0; i < countA; i++ ) {
			listA.add( "A" + i);
		}
		
		for( int i = 0; i < countB; i++ ) {
			listB.add( "B" + i);
		}
		
		weaveList( listA, listB, intermediateSequence, result);
		
		return result;
	}
	
	
	
	/* COMPARE the sub function doesn't look intuitive: you cannot see argument list's size() changing
	 * also, need to deliberately reinstate the argument list once the sub function ends 
	 */
	private static void weaveList(LinkedList<String> listA, LinkedList<String> listB, LinkedList<String> intermediateSequence, ArrayList<LinkedList<String>> result) {

		//PURPOSE: simply use up the remaining list in this call
		if( listA.size() == 0 || listB.size() == 0 ) {
			
			LinkedList<String> theRemaining = listA.size() == 0 ? listB : listA;
			
			//DETAIL: this is not so good, because after this operation, gotta restore its original state
			
			for( int i = 0; i < theRemaining.size(); i++) {
				intermediateSequence.add( theRemaining.get(i) );
			}
			
			
			//QUESTION: why clone returns type of Object?
			//LinkedList<String> theCopied = intermediateSequence.clone();
			@SuppressWarnings("unchecked")
			LinkedList<String> theCopied = (LinkedList<String>) intermediateSequence.clone();
			
			result.add( theCopied );
			
			for( int i = 0; i < theRemaining.size(); i++) {
				intermediateSequence.removeLast() ;
			}
			
			return;
		}
		
		
		//prepare argument for sub function
		intermediateSequence.addLast( listA.removeFirst() );
		weaveList( listA, listB, intermediateSequence, result);
		//reinstate the argument
		listA.addFirst( intermediateSequence.removeLast() );
		
		
		intermediateSequence.addLast( listB.removeFirst() );
		weaveList( listA, listB, intermediateSequence, result);
		listB.addFirst( intermediateSequence.removeLast() );
		
	}
	

}







