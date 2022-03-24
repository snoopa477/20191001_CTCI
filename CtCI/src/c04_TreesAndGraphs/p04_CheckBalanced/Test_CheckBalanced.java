package c04_TreesAndGraphs.p04_CheckBalanced;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class Test_CheckBalanced {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet( Arrays.asList("1", "2") );
		
		if(options.contains("1")) {
			out.println("-----------------test CheckBalanced_01_TwoTasksTwoTraverses");
			List<MyTreeNode> roots = Arrays.asList( MyTreeNodeUtility.makeTree01(), MyTreeNodeUtility.makeTree02() );
			
			roots.forEach( root -> {
				boolean result = CheckBalanced_01_TwoTasksTwoTraverses.checkBalanced(root);
				out.printf("is tree balanced? %s\n", result? "Yes": "No");
			} );
		}
		
		if(options.contains("2")) {
			out.println("-----------------test CheckBalanced_02_TwoTasksOneTraverse");
			List<MyTreeNode> roots = Arrays.asList( MyTreeNodeUtility.makeTree01(), MyTreeNodeUtility.makeTree02() );
			
			roots.forEach( root -> {
				boolean result = CheckBalanced_02_TwoTasksOneTraverse.checkBalanced(root);
				out.printf("is tree balanced? %s\n", result? "Yes": "No");
			} );
		}
		
	}
}


