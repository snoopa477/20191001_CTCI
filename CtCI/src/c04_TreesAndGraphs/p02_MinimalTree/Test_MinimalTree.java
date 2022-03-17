package c04_TreesAndGraphs.p02_MinimalTree;
import static java.lang.System.out;

import util.MyArrays;
import util.MyTreeNode;
import util.MyTreeNodeUtility;

public class Test_MinimalTree {

	public static void main(String[] args) {
		
		int[][] sortedInputs = {
			{1,2,3},
			{1,2,3,4,5},
			{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}
		};
		
		
		for( int[] sortedInput : sortedInputs ) {
			
			MyTreeNode root = _Practice_MinimalTree.makeMinimalTree( sortedInput );
			MyArrays.print(sortedInput);
			out.println();
			out.println( MyTreeNodeUtility.getHeightOfTree(root) );
			
		}
		
	}

}


