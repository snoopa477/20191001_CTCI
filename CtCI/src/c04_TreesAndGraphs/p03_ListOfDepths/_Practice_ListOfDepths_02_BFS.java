package c04_TreesAndGraphs.p03_ListOfDepths;
import static java.lang.System.out;
import java.util.*;

import util.MyTreeNode;
public class _Practice_ListOfDepths_02_BFS {

	
	public static ArrayList<ArrayList<MyTreeNode>> getListOfDepths (MyTreeNode root ){
		
		if( root == null ) {
			return null;
		}
		
		ArrayList<ArrayList<MyTreeNode>> result = new ArrayList<>();
		
		
		//ArrayList<MyTreeNode> current_LevelListOfNodes = null;
		ArrayList<MyTreeNode> currentNodes = null;
		//ArrayList<MyTreeNode> next_LevelListOfNodes = null;
		ArrayList<MyTreeNode> children = null;
		
		currentNodes = new ArrayList<>();
		currentNodes.add( root );
		
		/* PURPOSE:
		 * add the current list of nodes to result
		 * for each node in current list, see if they have children? if they have any, put them in the next level list of nodes
		 * repeat the aforementioned process, until current list is empty
		 * */
		while( currentNodes != null && currentNodes.size() != 0 ) {
			
			result.add( currentNodes );
			
			//DETAIL: for each node in current list...
			for( MyTreeNode node : currentNodes ) {
				
				//PURPOSE: create a new list only if there exist any children and the list is non-existent
				if( (node.left != null || node.right != null) && children == null ) {
					children = new ArrayList<>();
				}
				
				if( node.left != null ) {
					children.add( node.left );
				}
				
				if( node.right != null ) {
					children.add( node.right );
				}
				
			}
			
			//PURPOSE: prepare for the next loop
			currentNodes = children;
			//REASONING since children become current nodes, current nodes don't have any children right now
			children = null;
		}
		
		return result;
	}
	
}



