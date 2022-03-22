package c04_TreesAndGraphs.p03_ListOfDepths;

import java.util.*;

import util.MyTreeNode;

import static java.lang.System.out;
public class _Practice_ListOfDepths_01_preOrder {
	

	public static ArrayList<ArrayList<MyTreeNode>> getListOfDepths( MyTreeNode root ){
		
		if( root == null ) {
			return null;
		}
		
		ArrayList<ArrayList<MyTreeNode>> result = new ArrayList<ArrayList<MyTreeNode>>();
		
		//PURPOSE: whenever we visit a level, add it to this variable. We need to know whether we've been to the same level before 
		HashSet<Integer> visitedLevels = new HashSet<>();
		
		getListOfDepths( root, 0, visitedLevels, result );
		
		return result;
	}
	
	
	
	private static void getListOfDepths( MyTreeNode root, int level, HashSet<Integer> visitedLevels, ArrayList<ArrayList<MyTreeNode>> listOfListOfNodes ) {
		
		//base case
		if( root == null ) {
			return;
		}
		
		ArrayList<MyTreeNode> listOfNodes;
		
		//REASONING: if we reach the level first time, then we will need new arraylist to hold the following nodes in this level.
		if( visitedLevels.contains(level) == false ) {
			listOfNodes = new ArrayList<>();
			listOfListOfNodes.add(listOfNodes);
			visitedLevels.add(level);
		}
		//REASONING: this is not the first time we reach to this level, we simply pull out the arraylist we've created before 
		else {
			//DETAIL: index = level
			listOfNodes = listOfListOfNodes.get( level );
		}
		
		
		//REASONING: adding node to list doesn't depend on any subtree, so it's pre-order
		listOfNodes.add( root );
		//THINK_FURTHER: calling function with argument children is somewhat similar to call recursion function with lower argument n-1, reaching to 0, the base case.
		getListOfDepths( root.left, level + 1, visitedLevels, listOfListOfNodes );
		getListOfDepths( root.right, level + 1, visitedLevels, listOfListOfNodes );
		
	}
	
}







