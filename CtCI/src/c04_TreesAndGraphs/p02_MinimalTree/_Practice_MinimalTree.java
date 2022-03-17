package c04_TreesAndGraphs.p02_MinimalTree;
import static java.lang.System.out;

import util.MyTreeNode;
public class _Practice_MinimalTree {

	public static MyTreeNode makeMinimalTree(int[] sortedArr) {
		
		//return the root node of the tree, like holding a bunch of grapes by one root grape
		return makeMinimalTreeNode(sortedArr, 0, sortedArr.length -1 );
	}
	
	
	
	//DETAIL: left, right, sortedArr. they're similar to merge
	//private static void makeMinimalTree(MyTreeNode root, int[] sortedArr, int left, int right) {
	private static MyTreeNode makeMinimalTreeNode(int[] sortedArr, int left, int right) {
		
		if( left > right ) {
			return null;
		}
		
		//MISTAKE: forget to put /2. that's why having concept in mind matters
		//int mid = left + (right - left);
		int mid = left + (right - left) /2 ;
		//REASONING: to have minimal tree, separate two trees half, choose the median of value, which locates at the middle position in an sorted array
		int key = sortedArr[mid];
		
		//pre-order?
		MyTreeNode root = new MyTreeNode(key);
		//index mid is used
		root.left = makeMinimalTreeNode(sortedArr, left, mid -1 );
		root.right = makeMinimalTreeNode(sortedArr, mid + 1, right );
		
		return root;
	}
	
}


