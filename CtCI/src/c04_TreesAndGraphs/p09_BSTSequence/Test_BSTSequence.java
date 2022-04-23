package c04_TreesAndGraphs.p09_BSTSequence;
import static java.lang.System.out;

import util.MyTreeNode;
import util.MyTreeNodeUtility;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test_BSTSequence {

	public static void main(String[] args) {
		
		 MyTreeNode root04 = MyTreeNodeUtility.makeTree04();
		 MyTreeNodeUtility.printBFSwithDetail( root04 );
		 
		 ArrayList<LinkedList<Integer>> seqs = BSTSequence.getMakingBSTSequences( root04 );
		 
		 for( LinkedList<Integer> seq: seqs ) {
			 out.println(seq);
		 }
		
		 out.println("end");
	}

}


