package util;
import static java.lang.System.out;
public class MyTreeNode {

	public int data;
	
	//PURPOSE: size of elements in both left and right subtree.
	//DETAIL: whenever a new node is passing through, size increases. Just like zoo gate counter 
	private int size;
	
	public int getSize() {
		return size;
	}

	
	//IMAGINE: the parent looks like the trunk of a tree; left and right looks like roots of a tree
	public MyTreeNode left, right, parent;


	
	public MyTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.size = 0;
	}
	
	
	
	public MyTreeNode(int data, MyTreeNode left, MyTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
		left.parent = this;
		right.parent = this;
		this.size = 0;
	}
	
	
	
	public MyTreeNode(int data, MyTreeNode parent) {
		this.data = data;
		this.parent = parent;
		this.left = null;
		this.right = null;
		this.size = 0;
	}
	
	
	
	public void setChildren( MyTreeNode left, MyTreeNode right ) {
		this.left = left;
		this.right = right;
	}
	
	
	
	/*PURPOSE: create a new node to either left or right side.
	 * If the chosen side already exists a node, pass down the same task to that node, until there's a side having no node
	 * */
	//public void insertNode( int key ) {
	public void insertNodeInOrder( int key ) {
		
		if( key < data ) {
			if( left == null ) {
				//THINK_FURTHER so in the following insert, this node has left, which is not null
				left = new MyTreeNode( key, this );
				//THINK_FURTHER no more calls, the task ends.
				left.parent = this;
			}
			else {
				left.insertNodeInOrder( key );
			}
		}
		//data <= key
		else {
			if( right == null ) {
				right = new MyTreeNode( key, this );
			}
			else {
				right.insertNodeInOrder( key );
				right.parent = this;
			}
		}
		
		size++;
	}
	
	
	
	//REASONING: if there exists a node that has such key, then there must exists the path, consisting left and right, and the searching path is exactly the same as the path, no deviation
	//REASONING: null node iff the end of the searching path, meaning all nodes don't have such value -> not found
	public MyTreeNode findNodeByValue( int key ) {
		if( data == key ) {
			return this;
		}
		else if( data < key ) {
			if( right == null ) {
				return null;
			}
			else {
				//DETAIL: well it's right node's business; finding out the result is not the responsibility of the current node.
				//right.findNodeByValue( key );
				//PURPOSE: current nodes result is right node's result (dependency?), so return is added
				return right.findNodeByValue( key );
			}
		}
		//key < data
		else {
			if( left == null ) {
				return null;
			}
			else {
				return left.findNodeByValue( key );
			}
		}
	}
	
	
	
	@Override 
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append( String.format("{data=%d, size=%d, leftValue=%s, rightValue=%s, parentValue=%s}"
				,data
				,size
				,left != null? String.valueOf(left.data): "NULL" 
				,right != null? String.valueOf(right.data): "NULL" 
				,parent != null? String.valueOf(parent.data): "NULL") );
		
		return sb.toString();
	}
	
	
}


