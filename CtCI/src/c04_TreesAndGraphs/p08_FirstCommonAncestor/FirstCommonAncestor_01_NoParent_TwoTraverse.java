package c04_TreesAndGraphs.p08_FirstCommonAncestor;
import static java.lang.System.out;

import java.util.HashMap;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class FirstCommonAncestor_01_NoParent_TwoTraverse {
	
	

	//public static MyTreeNode getCommonAncestor( MyTreeNode root, MyTreeNode node01, MyTreeNode node02 ) {
	public static MyTreeNode getCommonAncestor( MyTreeNode root, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		//DETAIL: this is not the backbone logic; it is more like a premise we need to make sure before we dive into the main logic
		//PURPOSE if either of the nodes is not in the same tree, then of course they have no common ancestor
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
		//MISTAKE: typo. so it's important to write down the purpose before coding; it makes easy to debug such nuance
		//boolean isNodeB_inLeftTree = containsNodeInTree(root.right, nodeB);
		boolean isNodeB_inLeftTree = containsNodeInTree(root.left, nodeB);
		
		//PURPOSE: if both nodes are on the same side, we keep going deep until they diverge apart
		if( isNodeA_inLeftTree == true && isNodeB_inLeftTree == true ) {
			//DETAIL: we cannot decide in this layer; we delegate the problem to next layer, and this layer's answer depends upon ( equal to, to be precise) the next layer  
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
		
		//THINK_FURTHER: it is as effective as 'return containsNode(root.left, target) || containsNode(root.right, target)
		//since there's cut-off
		
		//THINK_FURTHER: this is even worse... no cut-off
		/*
		boolean leftResult = containsNode(root.left, target);
		boolean rightResult = containsNode(root.right, target);
		
		return leftResult || rightResult;
		*/
		
		//return  containsNode(root.left, target) || containsNode(root.right, target);
	}
	
	
	
	
	public static void main(String[] args) {
		
		//PURPOSE: test containsNodeInTree
		MyTreeNode root01 = MyTreeNodeUtility.makeTree01();
		HashMap<String, MyTreeNode> valueToNode = MyTreeNodeUtility.getValueToNode( root01 );
		
		String[] inputs = {"1", "3", "10", "17", "18"};
		
		for( String input: inputs ) {
			
			/*
			MyTreeNode node = valueToNode.containsKey( input )? 
					valueToNode.get( input )
					: new MyTreeNode( input );
			*/
			
			MyTreeNode node;
			if( valueToNode.containsKey( input ) ) {
				out.println("get from map");
				node = valueToNode.get( input );
			}
			else {
				out.println("get from new instance");
				node = new MyTreeNode( Integer.parseInt(input) );
			}
					
			out.printf("is node with value %s in the tree? %s\n", input, containsNodeInTree(root01, node));
			
			
		}
		
		//DETAIL: not until I print all the map, don't I found I had typo in getValueHelper method
		valueToNode.forEach( (key, node) -> out.printf("%s, %s\n", key, node.toString()) );
		
	}
	
	
	
}


