package c10_SortingAndSearching.p10_RankFromStream.textbook;
import static java.lang.System.out;

public class _Practice_RankNode {
	
	private int nodeValue;
	//number of nodes of current nodes of left subtree
	private int numberOfLeftNodes;
	private _Practice_RankNode leftNode;
	private _Practice_RankNode rightNode;
	
	
	public _Practice_RankNode(int nodeValue) {
		this.nodeValue = nodeValue;
		numberOfLeftNodes = 0;
	}
	public int getNumberOfLeftNodes() {
		return numberOfLeftNodes;
	}
	public void setNumberOfLeftNodes(int numberOfLeftNodes) {
		this.numberOfLeftNodes = numberOfLeftNodes;
	}
	public _Practice_RankNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(_Practice_RankNode leftNode) {
		this.leftNode = leftNode;
	}
	public _Practice_RankNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(_Practice_RankNode rightNode) {
		this.rightNode = rightNode;
	}
	
	
	
	/**
	 *  This function is used for building a tree from a sequence of integers 
	 */
	public void insert(int key) {
		
		//WRONG: the question ask for the number of nodes that are less than or equal to key
		//if( nodeValue <= key ) {
		if( nodeValue < key ) {
			
			//CAUTION: compared to print tree in-order, you cannot simply call rightNOde.insert(key) BEFORE inspecting whether the current node is null. 
			if( rightNode != null ) {
				rightNode.insert(key);
			}
			else {
				rightNode = new _Practice_RankNode(key);
			}
			//THINK_FURTHER: the right subtree size++; in this scenario we do nothing
			
		}
		// if( key <= nodeValue )
		else {
			
			if( leftNode != null ) {
				leftNode.insert(key);
			}
			else {
				leftNode = new _Practice_RankNode(key);
			}
			//PURPOSE: since the left subtree size is increased, we take note at current node, so we don't have to travel the whole left subtree to get the size of it
			numberOfLeftNodes++;
		}
	}
	
	
	
	public int getRank(int key) {
		
		if( key == nodeValue ) {
			return numberOfLeftNodes;
		}
		else if( key < nodeValue ) {
			
			//PURPOSE: the node that contains key must lies in leftSubtree only if leftSubtree exists; else, such node is non-existent.
			//CAUTION: compared to print tree in-order, you cannot simply call leftNode.getRank() BEFORE inspecting whether the current node is null.
			if( leftNode == null ) {
				return -1;
			}
			
			//THINK_FURTHER we already considered right subtree, and it contributes nothing to rank, so we do nothing
			//DETAIL: move left, and call sub function
			return leftNode.getRank(key);
		}
		//if( nodeValue < key)
		else {
			
			if( rightNode == null ) {
				return -1;
			}
			
			//move right
			//int result = rightNode.getRank(key);
			//DETAIL: more precise naming
			int resultFromRightTree = rightNode.getRank(key);
			
			//WRONG if you missed the line. if the sub function returns -1, meaning the node 
			//THINK_FURTHER if you missed this line, it would return [result] + 1 + numberOfLeftNodes
			if( resultFromRightTree == -1 ) {
				return -1;
			}
			
			//PURPOSE F(currentNode) = F(rightNode) + #(currentNode) + currentNode's left tree size
			return resultFromRightTree + 1 + numberOfLeftNodes; 
		}
		
	}
	
}


