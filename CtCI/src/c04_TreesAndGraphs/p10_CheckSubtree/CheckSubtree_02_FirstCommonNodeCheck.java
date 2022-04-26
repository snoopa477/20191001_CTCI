package c04_TreesAndGraphs.p10_CheckSubtree;
import static java.lang.System.out;

import util.MyTreeNode;
public class CheckSubtree_02_FirstCommonNodeCheck {
	
	
	public static boolean checkSubTree( MyTreeNode big_TreeRoot, MyTreeNode small_TreeRoot ) {
		return compareSmallTraverseBig( big_TreeRoot, small_TreeRoot );
	}
	
	
	
	private static boolean compareSmallTraverseBig( MyTreeNode big_TreeRoot, MyTreeNode small_TreeRoot ) {
		
		if( big_TreeRoot == null && small_TreeRoot == null) {
			return true;
		}
		
		if( big_TreeRoot == null) {
			return false;
		}
		
		//boolean result = false;
		boolean compareResult = false;
		//PURPOSE: if two roots' value are the same, start comparing the following subtrees to see if they match
		if( big_TreeRoot.data == small_TreeRoot.data ) {
			compareResult = compareTwoTrees( big_TreeRoot, small_TreeRoot );
		}
		//PURPOSE: if we found bigTree contains smallTree => no need to traverse further
		if( compareResult == true ) {
			return true;
		}
		
		//REASONING: if A || B || C ... if A true, then the result is true without further calculating; to be efficient, we check each logic component if true before proceeding further calculation
		//PURPOSE: under the premise we don't find containing relationship, keep traversing
		compareResult = compareSmallTraverseBig( big_TreeRoot.left, small_TreeRoot );
		if( compareResult == true ) {
			return true;
		}
		
		
		compareResult = compareSmallTraverseBig( big_TreeRoot.right, small_TreeRoot );
		return compareResult;
	}



	private static boolean compareTwoTrees(MyTreeNode rootA, MyTreeNode rootB) {
		
		if( rootA == null && rootB == null ) {
			return true;
		}
		
		if( rootA == null || rootB == null) {
			return false;
		}
		
		//THINK_FURTHER under the premise both trees are existent and we process the following: 
		
		/*REASONING: if two tree matches => root.datas are the same && leftTree returning true && leftTree returning true for every nodes; 
		 however, in each call we only focus the root and its left/right subtree's result 
		 */
		
		//REASONING: if A && B && C ... if A false, then the result is false without further calculating; to be efficient, we check each logic component if false before proceeding further calculation
		if( rootA.data != rootB.data ) {
			return false;
		}
		
		
		boolean compareResult = compareTwoTrees( rootA.left, rootB.left );
		if( compareResult == false ) {
			return false;
		}
		
		
		compareResult = compareTwoTrees( rootA.right, rootB.right );
		//MISTAKE typo
		//return false;
		return compareResult;
	}
	
	
}









