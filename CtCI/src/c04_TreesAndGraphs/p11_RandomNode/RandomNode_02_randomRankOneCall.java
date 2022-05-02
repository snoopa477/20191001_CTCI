package c04_TreesAndGraphs.p11_RandomNode;
import static java.lang.System.out;

import java.util.Random;
public class RandomNode_02_randomRankOneCall {

	public int data;
	public RandomNode_02_randomRankOneCall left;
	public RandomNode_02_randomRankOneCall right;
	public int size;
	
	
	
	public RandomNode_02_randomRankOneCall(int data) {
		this.data = data;
		left = null;
		right = null;
		//itself count as one
		size = 1;
	}
	
	
	
	public void insertInOrder( int key ) {
		
		if( key <= data ) {
			
			if( left != null ) {
				left.insertInOrder( key );
			}
			else {
				left = new RandomNode_02_randomRankOneCall( key );
			}
		}
		// data < key, key is at the left side
		else {
			
			if( right != null ) {
				right.insertInOrder( key );
			}
			else {
				right = new RandomNode_02_randomRankOneCall( key );
			}
		}
		

		size++;
	}
	
	
	
	public RandomNode_02_randomRankOneCall getRandomNode() {
		
		//DETAIL: convert from [0, size) to [1, size]; rank starts from leftmost node with value 1
		int pickedRank = ( new Random() ).nextInt( size ) + 1;
		
		return getRandomNode( pickedRank );
	}
	
	
	
	public RandomNode_02_randomRankOneCall getRandomNode(int pickedRank) {
		
		int leftMaxRank = left != null? left.size : 0;
		
		if( leftMaxRank + 1 == pickedRank ) {
			return this;
		}
		else if( pickedRank <= leftMaxRank ) {
			//REASONING: the leftTree pickedRank = root pickedRank, because we skip nothing
			return left.getRandomNode( pickedRank );
		}
		// leftMaxRank < pickedRank
		else {
			//REASONING: the rightTree pickedRank = root pickedRank - leftMaxRank -1, because we skip left tree and root 
			return right.getRandomNode( pickedRank - leftMaxRank -1 );
		}
	}
	

}


