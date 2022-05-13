package c04_TreesAndGraphs.p12_PathsWithSum;

import static java.lang.System.out;

import java.util.HashMap;

import util.TreeNode;

public class _0412_01_PathsWithSum {

	int countpathsWithSum(TreeNode root, int targetSum) {
		return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}

	
	
	int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null)
			return 0; // Base case
		/* Count paths with sum ending at the current node. */
		runningSum += node.data;
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);
		/*
		 * If runningSum equals targetSum, then one additional path starts at root. Add
		 * in this path .
		 */
		if (runningSum == targetSum) {
			totalPaths++;
		}
		/* Increment pathCount, recurse, then decrement pathCount. */
		incrementHashTable(pathCount, runningSum, 1); // Increment pathCount
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
		incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount
		return totalPaths;
	}

	
	
	void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		if (newCount == 0) { // Remove when zero to reduce space usage
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}
}
