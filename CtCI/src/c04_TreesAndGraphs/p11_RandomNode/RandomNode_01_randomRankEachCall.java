package c04_TreesAndGraphs.p11_RandomNode;
import static java.lang.System.out;
import java.util.Random;

public class RandomNode_01_randomRankEachCall {

	public int data;
	public RandomNode_01_randomRankEachCall left;
	public RandomNode_01_randomRankEachCall right;
	public int size;
	
	
	
	public RandomNode_01_randomRankEachCall(int data) {
		super();
		this.data = data;
		left = null;
		right = null;
		//itself count as one
		size = 1;
	}
	
	
	
	public void insertInOrder( int key ) {
		
		//PURPOSE: determine the key is at the left or right of the node by comparing node's data
		//DETAIL: data means this.data, not left.data nor right.data
		if( key <= data ) {
			
			if( left != null ) {
				//THINK_FURTHER: each call would go deeper, closer to the leaf
				//DETAIL: if targetSide already has a node, ask the same question to targetSide
				left.insertInOrder( key );
			}
			else {
				//DETAIL: insertion successfully
				left = new RandomNode_01_randomRankEachCall( key );
			}
		}
		// data < key, key is at the left side
		else {
			
			if( right != null ) {
				right.insertInOrder( key );
			}
			else {
				right = new RandomNode_01_randomRankEachCall( key );
			}
		}
		
		/* WRONG: 
		RandomNode_01_randomIdxEveryTime targetSide =  key <= data ? left : right;
		if( targetSide != null ) {
			targetSide.insertInOrder( key );
		}
		else {
			targetSide = new RandomNode_01_randomIdxEveryTime( key );
		}*/
		
		
		// each insertion by either new TreeNode or insertInOrder() would increase root's size
		size++;
	}
	
	
	
	/* REASONING:
	 * given the probability of node getting picked is evenly distributed
	 * If left group has m nodes, right group has n nodes
	 * , then the probability of left group picked (left.getRandomNode() is called ) is m / ( 1 + m + n )
	 * , and the probability of right group picked (right.getRandomNode() is called ) is n / ( 1 + m + n )
	 */
	public RandomNode_01_randomRankEachCall getRandomNode( ) {
		
		
		//TIP: to write clean code, don't use the mixture of index and rank; just pick one and use it all along
		//DETAIL: rank start with 1; rank starts from leftmost node
		int random_Rank = (new Random()).nextInt( size ) + 1;
		
		//WRONG: given leftTreeMax_Index 0,  cannot differentiate between null left or left with size 1 
		//int leftTreeMax_Index = left != null ? left.size -1 : 0;
		int leftTreeMax_Rank = left != null ? left.size : 0;
		
		if( random_Rank == leftTreeMax_Rank + 1 ) {
			return this;
		}
		else if( random_Rank <= leftTreeMax_Rank ) {
			//THINK_FURTHER: each call would go deeper, closer to the leaf
			//THINK_FURTHER: under the premise size and insertInOrder work properly, we don't need to check left is null before calling left.getRandomNode()
			return left.getRandomNode();
		}
		else {
			return right.getRandomNode();
		}
	}
	

}





