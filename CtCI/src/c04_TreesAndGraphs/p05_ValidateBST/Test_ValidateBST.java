package c04_TreesAndGraphs.p05_ValidateBST;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class Test_ValidateBST {
public static void main(String[] args) {
		
		HashSet<String> options = new HashSet( Arrays.asList("1", "2") );
		
		if(options.contains("1")) {
			out.println("-----------------test ValidateBST_01_Definition");
			List<MyTreeNode> roots = Arrays.asList( MyTreeNodeUtility.makeTree02(), MyTreeNodeUtility.makeTree03() );
			
			roots.forEach( root -> {
				boolean result = ValidateBST_01_Definition.checkBST(root);
				out.printf("is tree a BST? %s\n", result? "Yes": "No");
			} );
		}
		
	}
}


