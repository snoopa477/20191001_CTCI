package c04_TreesAndGraphs.p04_CheckBalanced;
import static java.lang.System.out;

import util.MyTreeNode;
public class CheckBalanced_02_TwoTasksOneTraverse {
	
	public static boolean checkBalanced( MyTreeNode root ) {
		
		int heightOrInvalidity = getHeightOrInvalidity( root );
		
		if( heightOrInvalidity != Validity.Invalid.value ) {
			return true;
		}
		else {
			return false;
		}
		
	}
	

	
	/**
	 * @return value that greater than or equal to 0 means the tree is balanced; the value is its height.
	 * <br> However, value that is less than 0 means it is <b>NOT</b> balanced.
	 */
	private static int getHeightOrInvalidity( MyTreeNode root ) {
		
		if( root == null ) {
			return 0;
		}
		
		//out.printf("root %d\n", root.data);
		
		int heightOrInvalidity_leftTree = getHeightOrInvalidity( root.left );
		//PURPOSE: check if we can cut off: if we have imbalanced subtree, then no further computation, because we can suggest that the current node ( and its ancestor ) holding this imbalanced subtree is also imbalanced
		if( heightOrInvalidity_leftTree == Validity.Invalid.value ) {
			return Validity.Invalid.value;
		}
		
		int heightOrInvalidity_rightTree = getHeightOrInvalidity( root.right );
		if( heightOrInvalidity_rightTree == Validity.Invalid.value ) {
			return Validity.Invalid.value;
		}
		
		//THINK_FURTHER: reaching here meaning the aforementioned variables are all heights, instead of invalidities.
		int height_leftTree = heightOrInvalidity_leftTree;
		int height_rightTree = heightOrInvalidity_rightTree;
		
		if( Math.abs(height_leftTree - height_rightTree ) > 1) {
			return Validity.Invalid.value;
		}
		
		int height = Math.max(height_leftTree, height_rightTree) + 1;
		
		return height;
	}
	
	
}



enum Validity{
	
	Invalid(-1);
	
	Validity(int i) {
		//WRONG if you don't assign anything to field value
		this.value = i;
	}

	int value;
	
}






