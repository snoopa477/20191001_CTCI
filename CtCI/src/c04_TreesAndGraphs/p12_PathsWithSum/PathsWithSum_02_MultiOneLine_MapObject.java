package c04_TreesAndGraphs.p12_PathsWithSum;
import static java.lang.System.out;

import java.util.HashMap;

import util.MyTreeNode;
public class PathsWithSum_02_MultiOneLine_MapObject {

	public static int countPathsWithGivenSum( MyTreeNode root, int targetSum ) {
		
		//temp 
		return 0;
	}
	
	
	
	/**
	 * When referring sum, it means the sum from root node to either old/previous or current node
	 * 
	 * @param oldSum_to_Count, old sum means counted sum from root node
	 * @param root
	 * @param currentSum, counted from root node
	 * @param targetSum
	 * @return
	 */
	//private static int countPathsWithGivenSum( HashMap<Integer, Integer> visitedSumFromRoot_to_count, MyTreeNode root, int currentSumFromRoot, final int targetSum ) {
	private static int countPathsWithGivenSum( HashMap<Integer, Integer> oldSum_to_Count, MyTreeNode root, int currentSum, final int targetSum ) {
		
		if( root == null ) {
			return 0;
		}
		
		//THINK_FURTHER: it is not quite obvious currentSum is changing over each call
		//this variable is qualified after the operation
		currentSum += root.data;
		
		
		/* EXPLAIN
		 * countPaths consists of three parts
		 * 1. the currentNode is either 0 or 1
		 * 2. gain 0 or more from oldNodes
		 * 3. collect descendant nodes result
		 */
		//for this current node: root
		int countPaths = 0;
		
		//PURPOSE part 1  the currentNode is either 0 or 1
		if( currentSum == targetSum ) {
			//this sum count as one
			countPaths += 1;
		}
		
		//RENAME. int possiblePathToCurrentSum = targetSum;
		/*THINK_FURTHER: 
		 * targetSum might be the path, starting with the previous node, and ending with current node.
		 * if this is the case, the likely sum--which equals to currentSum - likelyPath -- would exist;
		 * in other words, it can be found in the oldSum_to_Count map
		 */
		int likelyPath = targetSum;
		
		//RENAME. int possibleVisitedSumFromRoot = currentSum - likelyPath;
		int likelySum = currentSum - likelyPath;
		
		/*PURPOSE: if the map object actually contains such key -> likely sum exists 
		 * -> there exists a path(likelyPath) starting with some node to current node, which equals to TARGETSUM, preceded by likely sum
		 */
		//PURPOSE part 2. gain 0 or more from oldNodes
		if( oldSum_to_Count.containsKey( likelySum ) ) {
			//number of likelyPath = number of likely sum 
			countPaths += oldSum_to_Count.get( likelySum );
		}
		

		//PURPOSE part 3. collect descendant nodes result
		
		//before calling sub function, update map object by considering current node change, because the following function are influenced by current node
		updateMapBy_AddingCount( oldSum_to_Count, currentSum );
		
		countPaths += countPathsWithGivenSum( oldSum_to_Count, root.left, currentSum, targetSum );
		countPaths += countPathsWithGivenSum( oldSum_to_Count, root.right, currentSum, targetSum );
		
		//after calling sub function, restore map object state by NOT considering current node change, because once current node ends, the current stack is destroyed and shifting to other node
		updateMapBy_DecreasingCount( oldSum_to_Count, currentSum );
		
		
		return countPaths;
	}
	
	
	
	private static void updateMapBy_AddingCount( HashMap<Integer, Integer> sumToCount, int sum ) {
		
		/* EXPLAIN
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






