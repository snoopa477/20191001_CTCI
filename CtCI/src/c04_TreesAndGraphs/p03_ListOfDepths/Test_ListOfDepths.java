package c04_TreesAndGraphs.p03_ListOfDepths;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import util.MyTreeNode;
import util.MyTreeNodeUtility;

public class Test_ListOfDepths {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet( Arrays.asList("2") );
		
		if(options.contains("1")) {
			
			MyTreeNode root = MyTreeNodeUtility.makeTree01();
			ArrayList<ArrayList<MyTreeNode>> result = _Practice_ListOfDepths_01_preOrder.getListOfDepths(root);
			result.forEach( list -> 
				{ 
					list.forEach( node -> out.printf("%d ", node.data) );
					out.println(); 
				} );
			
		}
		
		
		if(options.contains("2")) {
			
			MyTreeNode root = MyTreeNodeUtility.makeTree01();
			ArrayList<ArrayList<MyTreeNode>> result = _Practice_ListOfDepths_02_BFS.getListOfDepths(root);
			result.forEach( list -> 
				{ 
					list.forEach( node -> out.printf("%d ", node.data) );
					out.println(); 
				} );
			
		}
		
	}

}


