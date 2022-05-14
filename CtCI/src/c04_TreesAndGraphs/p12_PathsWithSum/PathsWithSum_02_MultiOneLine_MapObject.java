package c04_TreesAndGraphs.p12_PathsWithSum;
import static java.lang.System.out;

import java.util.HashMap;

import util.MyTreeNode;
public class PathsWithSum_02_MultiOneLine_MapObject {

	public static int countPathsWithGivenSum( MyTreeNode root, int targetSum ) {
		
		return countPathsWithGivenSum( new HashMap<>(), root, 0, targetSum );
	}
	
	
	
	/**
	 * get the number of paths which value is equal to target sum; nodes that make path are descendants of the root 
	 * <br>path exists if two nodes are existent. 
	 * <br> if path consists of starting node s, and ending node e, then path value is value(node e) - value (node s);
	 * <br> however, if ending node is root, then starting node must be root as well, causing path value = 0
	 * 
	 * <br><h2>NAMING RULE</h2>
	 * <br>X: some node between root and current node
	 * <br>C: current node
	 * <br>R: root node
	 * <br>node relationship R ->... -> X -> ... -> C
	 */
	//RENAME. private static int countPathsWithGivenSum( HashMap<Integer, Integer> visitedSumFromRoot_to_count, MyTreeNode root, int currentSumFromRoot, final int targetSum ) {
	private static int countPathsWithGivenSum( HashMap<Integer, Integer> pathValRX_to_Count, MyTreeNode root, int pathVal_RC, final int targetSum ) {
		
		if( root == null ) {
			return 0;
		}
		
		//THINK_FURTHER: it is not quite obvious currentSum is changing over each call
		//this variable is qualified after the operation
		pathVal_RC += root.data;
		
		
		/* PURPOSE countPaths consists of three parts
		 * 1. the currentNode is either 0 or 1
		 * 2. gain 0 or more from oldNodes
		 * 3. collect descendant nodes result
		 */
		//for this current node: root
		int countPaths = 0;
		
		//PURPOSE part 1  the currentNode is either 0 or 1
		if( pathVal_RC == targetSum ) {
			countPaths += 1;
		}
		
		//RENAME. int possiblePathToCurrentSum = targetSum;
		
		//DETAIL assume there exists a path -- from some node to current node-- has such value = targetSum
		int likelyPathVal_XC = targetSum;
		
		//RENAME. int possibleVisitedSumFromRoot = currentSum - likelyPath;
		//DETAIL: get pathVal_RX so it can be used to lookup map object
		int likelyPathVal_RX = pathVal_RC - likelyPathVal_XC;
		

		//REASONING:check if pathVal_RX exist? if so, pathVal_XC exists as well
		//PURPOSE part 2. gain 0 or more from oldNodes
		if( pathValRX_to_Count.containsKey( likelyPathVal_RX ) ) {
			//number of likelyPathVal_RX = number of likelyPathVal_XC
			countPaths += pathValRX_to_Count.get( likelyPathVal_RX );
		}
		

		//PURPOSE part 3. collect descendant nodes result
		//IMAGINE now the current becomes part of old node
		//before calling sub function, update map object by considering current node change, because the following function are influenced by current node
		updateMapBy_AddingCount( pathValRX_to_Count, pathVal_RC );
		
		countPaths += countPathsWithGivenSum( pathValRX_to_Count, root.left, pathVal_RC, targetSum );
		countPaths += countPathsWithGivenSum( pathValRX_to_Count, root.right, pathVal_RC, targetSum );
		
		//after calling sub function, restore map object state by NOT considering current node change, because once current node ends, the current stack is destroyed and shifting to other node
		updateMapBy_DecreasingCount( pathValRX_to_Count, pathVal_RC );
		
		
		return countPaths;
	}
	
	
	
	private static void updateMapBy_AddingCount( HashMap<Integer, Integer> sumToCount, int sum ) {
		
		/* REASONING
		 * if non existent key -> count = 0; after added by 1, count = 1
		 * if existent key -> count >= 1; after added by 1, count >=2
		 */
		//process the existent value to get current value
		int addedCount = sumToCount.getOrDefault(sum, 0) + 1;
		sumToCount.put(sum, addedCount);
		
	}
	
	
	
	private static void updateMapBy_DecreasingCount( HashMap<Integer, Integer> sumToCount, int sum ) {
		
		/* THINK_FURTHER
		 * if non existent key -> count = 0; after decreased by 1, count = -1; HOWEVER, this case will not ever happen
		 * if existent key -> count >= 1; after decreased by 1, count >= 0; key with count = 0 will be deleted
		 */
		int decreasedCount = sumToCount.getOrDefault(sum, 0) - 1;
		
		if( decreasedCount == 0 ) {
			sumToCount.remove(sum);
		}
		
	}
	
}




