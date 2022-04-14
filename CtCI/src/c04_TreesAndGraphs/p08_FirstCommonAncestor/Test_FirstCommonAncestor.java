package c04_TreesAndGraphs.p08_FirstCommonAncestor;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
import util.TreeNode;
public class Test_FirstCommonAncestor {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet( Arrays.asList( "2" ) );
		
		MyTreeNode tree01 = MyTreeNodeUtility.makeTree01();
		HashMap<String, MyTreeNode> graph01 = MyTreeNodeUtility.getValueToNode(tree01);
		
		MyTreeNode node04 = graph01.get("4");
		MyTreeNode node09 = graph01.get("9");
		MyTreeNode node12 = graph01.get("12");
		MyTreeNode node14 = graph01.get("14");
		MyTreeNode node99 = new MyTreeNode(99);
		
		
		if( options.contains("1") ) {
			
			out.println("FirstCommonAncestor_01_NoParent_TwoTraverse-------------");
			
			printTestingResult_FirstCommonAncestor_01_NoParent_TwoTraverse(tree01, node04, node09);
			printTestingResult_FirstCommonAncestor_01_NoParent_TwoTraverse(tree01, node14, node09);
			printTestingResult_FirstCommonAncestor_01_NoParent_TwoTraverse(tree01, node12, node09);
			printTestingResult_FirstCommonAncestor_01_NoParent_TwoTraverse(tree01, node14, node99);
		}
		
		
		if( options.contains("2") ) {
			
			out.println("FirstCommonAncestor_02_NoParent_OneTraverse-------------");
			
			printTestingResult_FirstCommonAncestor_02_NoParent_OneTraverse(tree01, node04, node09);
			printTestingResult_FirstCommonAncestor_02_NoParent_OneTraverse(tree01, node14, node09);
			printTestingResult_FirstCommonAncestor_02_NoParent_OneTraverse(tree01, node12, node09);
			printTestingResult_FirstCommonAncestor_02_NoParent_OneTraverse(tree01, node14, node99);
		}
		
		
	}
	
	
	
	private static void printTestingResult_FirstCommonAncestor_01_NoParent_TwoTraverse( MyTreeNode treeRoot, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		MyTreeNode resultNode = FirstCommonAncestor_01_NoParent_TwoTraverse.getCommonAncestor(treeRoot, nodeA, nodeB);
		
		out.printf("node w/ %s and node w/ %s 's common ancestor w/ %s\n"
				, nodeA != null ? String.valueOf( nodeA.data ) : "X"
				, nodeB != null ? String.valueOf( nodeB.data ) : "X"
				, resultNode != null ? String.valueOf( resultNode.data ) : "X"
				);
		
	}
	
	
	
	private static void printTestingResult_FirstCommonAncestor_02_NoParent_OneTraverse( MyTreeNode treeRoot, MyTreeNode nodeA, MyTreeNode nodeB ) {
		
		MyTreeNode resultNode = FirstCommonAncestor_02_NoParent_OneTraverse.getCommonAncestor(treeRoot, nodeA, nodeB);
		
		out.printf("node w/ %s and node w/ %s 's common ancestor w/ %s\n"
				, nodeA != null ? String.valueOf( nodeA.data ) : "X"
				, nodeB != null ? String.valueOf( nodeB.data ) : "X"
				, resultNode != null ? String.valueOf( resultNode.data ) : "X"
				);
	}

}







