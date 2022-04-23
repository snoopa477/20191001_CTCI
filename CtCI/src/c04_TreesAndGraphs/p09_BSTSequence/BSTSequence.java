package c04_TreesAndGraphs.p09_BSTSequence;
import static java.lang.System.out;

import util.MyTreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {

	/* REASONING:
	 * a total sequences of making BST sequence is
	 * given a root,
	 * for each sequence 'l' from total sequences of making BST from left subtree,
	 * for each sequence 'r' from total sequences of making BST from right subtree,
	 * root combines with weaving( l, r ), which returns a collection of node keys from l and r*/
	public static ArrayList<LinkedList<Integer>> getMakingBSTSequences( MyTreeNode root ){
		
		if( root == null ) {
			
			ArrayList<LinkedList<Integer>> makingBSTSeqs = new ArrayList<>();
			makingBSTSeqs.add( new LinkedList<>() );
			
			/*WRONG consider there's a node containing zero children
			 * in this way, weave() is not going to be called since makingBSTSeqs doesn't have any element, which type is LinkedList<Integer>
			 * if weave() is not called, then the result is not generated
			 */
			//return new ArrayList<LinkedList<Integer>>();
			return makingBSTSeqs;
		}
		
		//DETAIL: "seq" is abbreviation for "sequence" 
		//DETAIL: the reason LinkedList is used, it serves as double linkedList: can either add or remove from either first or last position
		ArrayList<LinkedList<Integer>> makingBSTSeqs = new ArrayList<>();
		
		LinkedList<Integer> intermediateSeq = new LinkedList<>();
		intermediateSeq.add( root.data );
		
		ArrayList<LinkedList<Integer>> left_makingBSTSeqs = getMakingBSTSequences( root.left );
		ArrayList<LinkedList<Integer>> right_makingBSTSeqs = getMakingBSTSequences( root.right );
		
		for( LinkedList<Integer> left_seq : left_makingBSTSeqs ) {
			for( LinkedList<Integer> right_seq : right_makingBSTSeqs ) {
				weave( left_seq, right_seq, intermediateSeq, makingBSTSeqs );
			}
		}
		
		return makingBSTSeqs;
	}
	
	
	
	/*WRONG: we don't need parameter ArrayList<LinkedList<Integer>> result, because sub call's would return it instead. 
	 * Think it in another way, if we use result as parameter, then the result would store all the results from all sub functions, causing confusion
	 */
	//private static void getMakingBSTSequences( MyTreeNode root, ArrayList<LinkedList<Integer>> result ){ ... }
	
	
	/** given left_makingBSTSeq and right_makingBSTSeq, the result is stored with a collection of combination of these two sequence and remaining both left_makingBSTSeq and right_makingBSTSeq's elements' relative order.
	 * <br>for example. <br>given [A0, A1] and [B0, B1] the result is
	 * <br>[A0, A1, B0, B1]<br>[A0, B0, A1, B1]<br>[A0, B0, B1, A1]<br>[B0, A0, A1, B1]<br>[B0, A0, B1, A1]<br>[B0, B1, A0, A1] */
	private static void weave( LinkedList<Integer> left_makingBSTSeq, LinkedList<Integer> right_makingBSTSeq, LinkedList<Integer> intermediateSeq, ArrayList<LinkedList<Integer>> result ) {
		
		//PURPOSE: if one of the lists is empty, there's no weaving. Complete sequence consists of intermediate sequence and the remaining list
		if( left_makingBSTSeq.size() == 0 || right_makingBSTSeq.size() == 0 ) {
			
			LinkedList<Integer> theRemaining = left_makingBSTSeq.size() == 0? right_makingBSTSeq : left_makingBSTSeq;
			
			@SuppressWarnings("unchecked")
			LinkedList<Integer> completeSeq = (LinkedList<Integer>) intermediateSeq.clone();
			completeSeq.addAll( theRemaining );
			
			result.add( completeSeq );
			//THINK_FURTHER: intermediateSeq doesn't need to be reinstated because we directly add elements to complete sequence, remaining intermediateSeq intact
			return;
		}
		
		//PURPOSE update to such state that fits for the next call
		intermediateSeq.addLast( left_makingBSTSeq.removeFirst() );
		weave( left_makingBSTSeq, right_makingBSTSeq, intermediateSeq, result );
		//PURPOSE reinstate
		left_makingBSTSeq.addFirst( intermediateSeq.removeLast() );
		
		
		intermediateSeq.addLast( right_makingBSTSeq.removeFirst() );
		weave( left_makingBSTSeq, right_makingBSTSeq, intermediateSeq, result );
		right_makingBSTSeq.addFirst( intermediateSeq.removeLast() );
	}
	
}






