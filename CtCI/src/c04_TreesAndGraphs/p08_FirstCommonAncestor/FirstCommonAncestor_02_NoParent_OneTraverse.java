package c04_TreesAndGraphs.p08_FirstCommonAncestor;
import static java.lang.System.out;

import java.util.HashMap;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class FirstCommonAncestor_02_NoParent_OneTraverse {

	
	public static MyTreeNode getCommonAncestor( MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		BooleanHolder isA_inTree = new BooleanHolder( false );
		BooleanHolder isB_inTree = new BooleanHolder( false );
		containsNodesInTree( isA_inTree, isB_inTree, root, nodeA, nodeB );
		if( isA_inTree.value == false || isB_inTree.value == false ) {
			return null;
		}
		
		
		return getCommonAncestorHelper( root, nodeA, nodeB );
	}
	
	
	
	private static MyTreeNode getCommonAncestorHelper( MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		//MISTAKE: don't forget about the trivial case; they usually appear at first
		//DETAIL: the following is not preferred 
		//if( root == null || root == nodeA || root == nodeB ) return root; even though they have same if body, their logic is different
		//THINK_FURTHER: reaching here meaning along the whole path no other return statement is met
		if( root == null ) {
			return null;
		}
		
		if( root == nodeA ) {
			return nodeA;
		}
		
		if( root == nodeB ) {
			return nodeB;
		}
		
		BooleanHolder isA_inLeftTree = new BooleanHolder( false );
		BooleanHolder isB_inLeftTree = new BooleanHolder( false );
		containsNodesInTree( isA_inLeftTree, isB_inLeftTree, root.left, nodeA, nodeB );
		
		if( isA_inLeftTree.value == true && isA_inLeftTree.value == isB_inLeftTree.value ) {
			return getCommonAncestorHelper(root.left, nodeA, nodeB);
		}
		
		if( isA_inLeftTree.value == false && isA_inLeftTree.value == isB_inLeftTree.value ) {
			return getCommonAncestorHelper(root.right, nodeA, nodeB);
		}
		
		//REASONING Reaching here meaning isA_inLeftTree.value != isB_inLeftTree.value => diverge
		return root;
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
	
	
	
	//DETAIL: name consideration: isA_inTree, isNodeA_inTree, isContainingNode_A
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
			BooleanHolder isContainingNode_02 = new BooleanHolder( false );
			BooleanHolder isContainingNode_10 = new BooleanHolder( false );
			
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

	public BooleanHolder(boolean value) {
		this.value = value;
	}
	
	
}




