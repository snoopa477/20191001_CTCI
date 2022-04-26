package c04_TreesAndGraphs.p10_CheckSubtree;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class Test_CheckSubtree {

	public static void main(String[] args) {
		
		MyTreeNode bigTree = MyTreeNodeUtility.makeTree01();
		MyTreeNode subTree = makeSubTree();
		MyTreeNode nonSubTree01 = makeNonSubTree01();
		MyTreeNode nonSubTree02 = makeNonSubTree02();
		
		
		HashSet<String> options = new HashSet( Arrays.asList( "2" ) );
		
		if( options.contains("1") ) {
			
			out.println("test CheckSubtree_01_PreOrderString");
			
			out.printf("checkSubTree( bigTree, subTree ) : %s\n"
					, String.valueOf( CheckSubtree_01_PreOrderString.checkSubTree( bigTree, subTree ) ) );
			out.printf("checkSubTree( bigTree, nonSubTree01 ) : %s\n"
					, String.valueOf( CheckSubtree_01_PreOrderString.checkSubTree( bigTree, nonSubTree01 ) ) );
			
			out.printf("checkSubTree( bigTree, nonSubTree02 ) : %s\n"
					, String.valueOf( CheckSubtree_01_PreOrderString.checkSubTree( bigTree, nonSubTree02 ) ) );
			
		}
		
		if( options.contains("2") ) {
			out.println("test CheckSubtree_02_FirstCommonNodeCheck");
			
			out.printf("checkSubTree( bigTree, subTree ) : %s\n"
					, String.valueOf( CheckSubtree_02_FirstCommonNodeCheck.checkSubTree( bigTree, subTree ) ) );
			out.printf("checkSubTree( bigTree, nonSubTree01 ) : %s\n"
					, String.valueOf( CheckSubtree_02_FirstCommonNodeCheck.checkSubTree( bigTree, nonSubTree01 ) ) );
			out.printf("checkSubTree( bigTree, nonSubTree02 ) : %s\n"
					, String.valueOf( CheckSubtree_02_FirstCommonNodeCheck.checkSubTree( bigTree, nonSubTree02 ) ) );
			
		}
		
		
		out.println("end");
		
	}
	
	
	
	/*
	 level 0:
	 Node:12, L:10, R: 14
	 
	 level 1:
	 Node:10, L: 9, R: 11
	 Node:14, L:13, R: 15
	 
	 level 2:
	 Node: 9, L: x, R:  x
	 Node:11, L: x, R:  x
	 Node:13, L: x, R:  x
	 Node:15, L: x, R:  x
	 * */
	public static MyTreeNode makeSubTree() {
		
		MyTreeNode root = new MyTreeNode(12);
		
		Arrays.asList(10, 9, 11, 14, 15, 13)
			.forEach( key -> root.insertNodeInOrder(key) );
		
		return root;
	}
	
	
	
	/*
	 level 0:
	 Node:12, L:10, R: 14
	 
	 level 1:
	 Node:10, L: 9, R: 11
	 Node:14, L: X, R: 15
	 
	 level 2:
	 Node: 9, L: x, R:  x
	 Node:11, L: x, R:  x
	 Node:15, L: x, R:  x
	 * */
	public static MyTreeNode makeNonSubTree01() {
		
		MyTreeNode root = new MyTreeNode(12);
		
		Arrays.asList(10, 9, 11, 14, 15)
			.forEach( key -> root.insertNodeInOrder(key) );
		
		return root;
	}
	
	
	
	/*
	 level 0:
	 Node:12, L:10, R: 14
	 
	 level 1:
	 Node:10, L: 9, R: 11
	 Node:14, L: X, R: 15
	 
	 level 2:
	 Node: 9, L: x, R:  x
	 Node:11, L: x, R:  x
	 Node:15, L: x, R: 16
	 
	 level 3:
	 Node:16, L: x, R:  x
	 
	 * */
	public static MyTreeNode makeNonSubTree02() {
		
		MyTreeNode root = new MyTreeNode(12);
		
		Arrays.asList(10, 9, 11, 14, 15, 16)
			.forEach( key -> root.insertNodeInOrder(key) );
		
		return root;
	}


}


