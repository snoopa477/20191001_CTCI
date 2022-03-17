package c04_TreesAndGraphs._00_Practice;
import static java.lang.System.out;

import java.util.Arrays;

import util.MyTreeNode;
import util.MyTreeNodeUtility;

public class Test_MyTreeNode {

	public static void main(String[] args) {
		
		int[] inputs = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
		
		MyTreeNode root = MyTreeNodeUtility.makeTree(inputs);
		
		out.println("\n---MyTreeNodeUtility.printInOrder");
		MyTreeNodeUtility.printInOrder(root);
		
		out.println("\n---MyTreeNodeUtility.printBFS");
		MyTreeNodeUtility.printBFS(root);
		
		
		out.println();
		
		
		//REFERENCE: https://stackoverflow.com/questions/2607289/converting-array-to-list-in-java
		/*
		 * QUOTE:
		 In your example, it is because you can't have a List of a primitive type. In other words, List<int> is not possible.
		 * */
		//int[] dataToFind = { 10, 14, 15 };
		//<int[]> List<int[]> java.util.Arrays.asList(int[]... a)
		Integer[] dataToFind = { 10, 14, 100 };
		Arrays.asList( dataToFind )
			.forEach(elt -> out.printf("%d is found in the tree? %s\n"
				, elt, (root.findNodeByValue(elt) != null? "YES": "NO") ));
		
		
		out.println("\n--MyTreeNodeUtility.getHeightOfTree");
		out.println( MyTreeNodeUtility.getHeightOfTree(root) );
		
	}
}
