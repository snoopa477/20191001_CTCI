package c04_TreesAndGraphs.p12_PathsWithSum;
import static java.lang.System.out;

import util.MyTreeNode;
public class PathsWithSum_01_Intuition {

	//PURPOSE: use this function to traverse every node in the tree; in other words, for each node, it calls its own countPathsWithGivenSum_FromThisNode, starting with currentSum 0
	public static int countPathsWithGivenSum_UnderThisNode( MyTreeNode root, int targetSum ) {
		
		int resultFrom_Root = countPathsWithGivenSum_FromThisNode( root, 0, targetSum );
		
		int resultFrom_LeftTree = countPathsWithGivenSum_UnderThisNode( root.left, targetSum );
		int resultFrom_RightTree = countPathsWithGivenSum_UnderThisNode( root.right, targetSum );
		
		int result = resultFrom_Root + resultFrom_LeftTree + resultFrom_RightTree;
		return result;
	}

	
	
	//DETAIL: about argument, it's recursion iterative with primitive type, so we don't need to restore the state before calling next sub function 
	/* EXAMPLE
	 * given we have such tree: 
	 * 2 _> 5 _> 4 _> [5] _> -2 _> 2 _> -2 _> 2 _> 3
	 * and we're already at node with data 5
	 * and suppose currentSum is 16, targetSum is 16; then 
	 * f( node w/ data 5, 16, 16 ) is 1 + 2 = 3
	 * 
	 * suppose the current node is at the following picture:
	 * 2 _> 5 _> 4 _> 5 _> [-2] _> 2 _> -2 _> 2 _> 3
	 * f( such node, 14, 16  ) = 0 + 2( the result from the next example) = 2 
	 * 
	 * 2 _> 5 _> 4 _> 5 _> -2 _> [2] _> -2 _> 2 _> 3
	 * f( such node, 16, 16  ) = 1 + 1 = 2 
	 * 
	 * 2 _> 5 _> 4 _> 5 _> -2 _> 2 _> [-2] _> 2 _> 3
	 * f( such node, 14, 16  ) = 0 + 1 = 1
	 * 
	 * 2 _> 5 _> 4 _> 5 _> -2 _> 2 _> -2 _> [2] _> 3
	 * f( such node, 16, 16  ) = 1 + 0 = 1
	 * 
	 * 2 _> 5 _> 4 _> 5 _> -2 _> 2 _> -2 _> 2 _> [3]
	 * f( such node, 19, 16  ) = 0 + 0 = 0
	 */
	private static int countPathsWithGivenSum_FromThisNode( MyTreeNode root, int currentSum, int targetSum ) {
		
		if( root == null ) {
			//null node definitely has nothing to match target sum
			return 0;
		}
		
		//DETAIL: the variable name is qualified after this operation
		currentSum += root.data;
		
		//for this node
		int waysMatchingSum = 0;
		
		//THINK_FURTHER: check currentSum, which involved current node => every node would do the same thing
		if( currentSum == targetSum ) {
			waysMatchingSum += 1;
		}
		
		//REVIEW recursion: Assuming each sub call already has answer
		//THINK_FURTHER: it's not obvious to see the difference between currentSum at this line and calling function; see the whole execution flow could tell instead
		int waysMatchingSum_left = countPathsWithGivenSum_FromThisNode( root.left, currentSum, targetSum );
		int waysMatchingSum_right = countPathsWithGivenSum_FromThisNode( root.right, currentSum, targetSum );
		
		waysMatchingSum += waysMatchingSum_left + waysMatchingSum_right;
		
		return waysMatchingSum;
	}
	
}


