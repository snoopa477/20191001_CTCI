package c04_TreesAndGraphs.p10_CheckSubtree;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.LinkedList;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class Test_ReconstructTreeByString {

	public static void main(String[] args) {
		
		String preOrderString = "1 2 4 X X X 3 X X";
		LinkedList<String> preOrderSequence = new LinkedList<String> (Arrays.asList( preOrderString.split(" ") ) );
		
		MyTreeNode root = makeTreeByPreorderString( preOrderSequence );
		
		MyTreeNodeUtility.printBFSwithDetail( root );
		
	}
	
	
	
	public static MyTreeNode makeTreeByPreorderString( LinkedList<String> sequence ) {
		
		if( sequence.size() == 0 ) {
			return null;
		}
		
		String potentialRootKey = sequence.removeFirst();
		if( "X".equals(potentialRootKey) ) {
			return null;
		}
		
		MyTreeNode root = new MyTreeNode(  Integer.valueOf( potentialRootKey ) );
		makeAppendChildNode( sequence, root, true );
		makeAppendChildNode( sequence, root, false );
		
		return root;
	}
	
	
	//PURPOSE: in each call we focus on potential child node rather than root, under the premise that there's existing parent. 
	//DETAIL: it's recursion iterative, each call would consume one element from sequence
	//OPINION: I came up with a better understanding name after finishing the implementation part. How queer
	//private static void makeTreeByPreorderString( LinkedList<String> sequence, MyTreeNode parent, boolean isChildLeft ) {
	private static void makeAppendChildNode( LinkedList<String> sequence, MyTreeNode parent, boolean isChildLeft ) {
		
		if( sequence.size() == 0 ) {
			return;
		}
		
		
		String potentialChildNodeKey = sequence.removeFirst();
		if( "X".equals(potentialChildNodeKey) ) {
			return;
		}
		
		
		MyTreeNode child = new MyTreeNode( Integer.valueOf( potentialChildNodeKey ) );
		
		if( isChildLeft ) {
			parent.left = child;
		}
		else {
			parent.right = child;
		}
		child.parent = parent;
		
		makeAppendChildNode( sequence, child, true );
		makeAppendChildNode( sequence, child, false );
		
	}

}




