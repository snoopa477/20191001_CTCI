package c04_TreesAndGraphs.p12_PathsWithSum;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class Test_PathsWithSum {

	public static void main(String[] args) {
		
		MyTreeNode root = makeTree();
		//MyTreeNodeUtility.printBFSwithDetail(root);
		
		HashSet<String> options = new HashSet( Arrays.asList( "1" ) );
		if( options.contains("1") ) {
			out.println("- - - -PathsWithSum_01_Intuition");
			out.println( PathsWithSum_01_Intuition.countPathsWithGivenSum_UnderThisNode(root, 18) ); 
		}
		
		if( options.contains("2") ) {
			out.println("- - - -PathsWithSum_02_MultiOneLine_MapObject");
			out.println( PathsWithSum_02_MultiOneLine_MapObject.countPathsWithGivenSum(root, 18) ); 
		}
		
	}
	
	
	
	/*
	 level 0:
	 Node:10, L: 5, R: -3
	 
	 level 1:
	 Node: 5, L: 3, R: 12
	 Node:-3, L: X, R: 11
	 
	 level 2:
	 Node: 3, L: 3, R: -2
	 Node:12, L: X, R:  1
	 Node:11, L: X, R:  X
	 
	 level 3:
	 Node: 3, L: X, R:  X
	 Node:-2, L: X, R:  2
	 Node: 1, L: X, R:  X
	 
	 level 4:
	 Node: 2, L: X, R:  X
	 * */
	//A non BST tree
	public static MyTreeNode makeTree() {
		
		
		MyTreeNode nodeWithVal_10 =  new MyTreeNode(10);
		
		MyTreeNode nodeWithVal_05 =  new MyTreeNode( 5);
		MyTreeNode nodeWithVal_n3 =  new MyTreeNode(-3);
		
		MyTreeNode nodeWithVal_03 =  new MyTreeNode( 3);
		MyTreeNode nodeWithVal_12 =  new MyTreeNode(12);
		MyTreeNode nodeWithVal_11 =  new MyTreeNode(11);
		
		MyTreeNode nodeWithVal_03a = new MyTreeNode( 3);
		MyTreeNode nodeWithVal_n2 =  new MyTreeNode(-2);
		MyTreeNode nodeWithVal_01 =  new MyTreeNode( 1);
		
		MyTreeNode nodeWithVal_02 =  new MyTreeNode( 2);
		
		nodeWithVal_10.setChildren(nodeWithVal_05, nodeWithVal_n3);
		
		nodeWithVal_05.setChildren(nodeWithVal_03, nodeWithVal_12);
		nodeWithVal_n3.setChildren(null, nodeWithVal_11);
		
		nodeWithVal_03.setChildren(nodeWithVal_03a, nodeWithVal_n2);
		nodeWithVal_12.setChildren(null, nodeWithVal_01);
		
		nodeWithVal_n2.setChildren(null, nodeWithVal_02);
		
		return nodeWithVal_10;
	}

}


