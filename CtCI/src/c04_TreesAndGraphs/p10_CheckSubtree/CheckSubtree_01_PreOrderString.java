package c04_TreesAndGraphs.p10_CheckSubtree;
import static java.lang.System.out;

import util.MyTreeNode;
public class CheckSubtree_01_PreOrderString {
	
	static final boolean IS_DEBUG_ON = false;
	
	final static String SEPARATOR = " ";
	
	public static boolean checkSubTree( MyTreeNode big_Tree, MyTreeNode small_Tree) {
		
		String preOrderString_BigTree = getPreOrderString( big_Tree );
		String preOrderString_SmallTree = getPreOrderString( small_Tree );
		
		if( IS_DEBUG_ON ) {
			out.printf("preOrderString_BigTree: %s\n", preOrderString_BigTree);
			out.printf("preOrderString_SmallTree: %s\n", preOrderString_SmallTree);
		}
		
		return preOrderString_BigTree.contains( preOrderString_SmallTree );
	}
	
	
	
	private static String getPreOrderString( MyTreeNode root ) {
		
		StringBuilder result= new StringBuilder();
		getPreOrderString(root, result);
		
		return result.toString();
	}
	
	
	
	//DETAIL: recursion iterative
	private static void getPreOrderString( MyTreeNode root, StringBuilder stringBuilder ) {
		
		if( root == null ) {
			stringBuilder.append("X");
			stringBuilder.append(SEPARATOR);
			return;
		}
		
		
		//DETAIL: process root
		stringBuilder.append( String.valueOf( root.data ) );
		stringBuilder.append(SEPARATOR);
		
		getPreOrderString( root.left, stringBuilder );
		getPreOrderString( root.right, stringBuilder );
		
	}
	
}


