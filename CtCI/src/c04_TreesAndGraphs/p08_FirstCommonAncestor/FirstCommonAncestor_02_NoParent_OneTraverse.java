package c04_TreesAndGraphs.p08_FirstCommonAncestor;
import static java.lang.System.out;

import java.util.HashMap;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class FirstCommonAncestor_02_NoParent_OneTraverse {

	
	
public static MyTreeNode getCommonAncestor( MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		if( containsNodeInTree(root, nodeA) == false || containsNodeInTree(root, nodeB) == false) {
			return null;
		}
		
		return getCommonAncestorHelper( root, nodeA, nodeB );
	}
	
	
	
	//PURPOSE: if both nodes are on the same side, we keep going deep until they diverge apart, and when it happens the root is the first common ancestor
	private static MyTreeNode getCommonAncestorHelper( MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		if( root == nodeA ) {
			return nodeA;
		}
		
		if( root == nodeB) {
			return nodeB;
		}
		
		//THINK_FURTHER: Under the premise both nodes in the whole tree( except for the root), If a node not in left subtree, it is must in right subtree 
		boolean isNodeA_inLeftTree = containsNodeInTree(root.left, nodeA);
		//boolean isNodeB_inLeftTree = containsNodeInTree(root.right, nodeB);
		boolean isNodeB_inLeftTree = containsNodeInTree(root.left, nodeB);
		
		//PURPOSE: if both nodes are on the same side, we keep going deep until they diverge apart
		if( isNodeA_inLeftTree == true && isNodeB_inLeftTree == true ) {
			return getCommonAncestor(root.left, nodeA, nodeB);
		}
		
		//REASONING: both nodes are on the right side
		if( isNodeA_inLeftTree == false && isNodeB_inLeftTree == false ) {
			return getCommonAncestor(root.right, nodeA, nodeB);
		}
		
		//THINK_FURTHER: reaching here meaning this is the first time both node 'diverge apart' at this root node, meaning the root node, common ancestor
		
		return root;
	}
	
	
	
	private static boolean containsNodeInTree( MyTreeNode root, MyTreeNode target ) {
		
		if( root == null) {
			return false;
		}
		
		if( root == target ) {
			return true;
		}
		
		
		boolean leftResult = containsNodeInTree(root.left, target);
		if( leftResult == true ) {
			return true;
		}
		
		boolean rightResult = containsNodeInTree(root.right, target);
		return rightResult; 
		
	}
	
	
	/* PURPOSE
	 * store two results into two variables: isContainingNode_A and isContainingNode_B without returning anything; it's sort of counter intuitive
	 */
	private static void containsNodesInTree( BooleanHolder isContainingNode_A, BooleanHolder isContainingNode_B, MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		isContainingNode_A.value = false;
		isContainingNode_B.value = false;
		
		//MISTAKE: typo, that would cause stackOverflow, and infinite call loop
		//containsNodesInTree(isContainingNode_A, isContainingNode_B, root, nodeA, nodeB);
		containsNodesInTreeHelper(isContainingNode_A, isContainingNode_B, root, nodeA, nodeB);
	}
	
	//isA_inTree
	//isNodeA_inTree
	//isContainingNode_A
	
	//private static void containsNodesInTreeHelper( BooleanHolder isContainingNode_A, BooleanHolder isContainingNode_B, MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB ) {
	private static void containsNodesInTreeHelper( BooleanHolder isA_inTree, BooleanHolder isB_inTree, MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		if( root == null ) {
			return;
		}
		
		
		//PURPOSE: mission accomplishes, so we can do cut-off
		/*THINK_FURTHER: why is this the only condition we can cut-off?
		 a node NOT in a tree 'so far' is a temporary state; the state is confirmed when the whole tree is searched, which means reaching to null node
		 ; At that point, if a node still NOT in a tree; then it is really the final state.  
		 However, a node in a tree is final state regardless of reaching bottom or not
		 When all nodes are confirmed, we can return*/
		if( isA_inTree.value && isB_inTree.value ) {
			return;
		}
		

		if( root == nodeA ) {
			isA_inTree.value = true;
		}
		
		
		if( root == nodeB ){
			isB_inTree.value = true;
		}
		
		
		containsNodesInTreeHelper( isA_inTree, isB_inTree, root.left, nodeA, nodeB );
		if( isA_inTree.value && isB_inTree.value ) {
			return;
		}
		containsNodesInTreeHelper( isA_inTree, isB_inTree, root.right, nodeA, nodeB );
	}
	
	
	
	public static void main(String[] args) {
		
		//PURPOSE: test containsNodesInTree
		MyTreeNode root01 = MyTreeNodeUtility.makeTree01();
		HashMap<String, MyTreeNode> valueToNode = MyTreeNodeUtility.getValueToNode( root01 );
		MyTreeNode node02 = valueToNode.get("2");
		MyTreeNode node04 = valueToNode.get("4");
		MyTreeNode node06 = valueToNode.get("6");
		MyTreeNode node08 = valueToNode.get("8");
		MyTreeNode node10 = valueToNode.get("10");
		
		{
			BooleanHolder isContainingNode_02 = new BooleanHolder();
			isContainingNode_02.value = false;
			BooleanHolder isContainingNode_10 = new BooleanHolder();
			isContainingNode_10.value = false;
			
			containsNodesInTree(isContainingNode_02, isContainingNode_10, node04, node02, node10);
			out.printf("\nfor tree node /w %s \nIs node /w %s in it? %s \nIs node /w %s in it? %s"
					, node04 != null ? String.valueOf( node04.data ) : "X"
					, node02 != null ? String.valueOf( node02.data ) : "X"
					, isContainingNode_02.value
					, node10 != null ? String.valueOf( node10.data ) : "X"
					, isContainingNode_10.value
					);
		}
		
		
		
	}
	
}



class BooleanHolder{
	public boolean value;
}




