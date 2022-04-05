package c04_TreesAndGraphs.p07_BuildOrder;
import static java.lang.System.out;
import java.util.*;

public class BuildOrder_01_Status {
	
	static final boolean IS_DEBUG = false;
	
	
	public static  String[] buildOrder( String[] nodeNames, String[][] dependencies ) {
		
		Graph_01_Status graph = new Graph_01_Status( nodeNames, dependencies );
		ArrayList<Node_01_Status> nodes = graph.getAllNodes();
		
		//PURPOSE: we calculate and put intermediate result into this variable
		Stack<Node_01_Status> reverseBuildOrder = new Stack<>();
		//Boolean hasCycle = false;
		BooleanHolder hasCycle = new BooleanHolder();
		hasCycle.value = false;
		
		//PURPOSE: collect intermediate result to stack only if there's no cycle
		/* QUESTION: does it matter for root or subtree get called first?
		 * No in this scenario, because it is post-order. 
		 * If root get called first, subtree's answer is put into stack first and then root's answer in one single call.
		 * If subtree get called first, subtree's answer is put into stack before putting root's answer into stack at the following call.
		 * In either case, as long as subtree's answer put into stack before root's; then it's correct.
		 */
		for( Node_01_Status node: nodes ) {
			
			//PURPOSE: if encountering with processing nodes, meaning there's cycle. Threre's no build order in a graph with cycle
			if( node.getStatus() == Node_01_Status.Status.PROCESSING ) {
				return null;
			}
			
			//PURPOSE: only process those unvisited nodes
			//THINK_FURTHER: it's like calling each root of grapes
			if( node.getStatus() == Node_01_Status.Status.UNVISITED ) {
				if( IS_DEBUG ) { out.println("before calling collectNodesPostorder the node is " + node.getName()); }
				collectNodesPostorder( hasCycle, reverseBuildOrder, node);
			}
		}
		
		
		if( hasCycle.value ) {
			//DETAIL: null cannot be used in forEach
			//return null;
			return new String[] {};
		}
		
		
		//PURPOSE: put answers to array
		String[] buildOrder = new String[reverseBuildOrder.size()];
		/*WRONG: F D G C null null null
		 I thought several reasons that cause null
		 1. some nodes are being collected to memory garbage and freed
		 2. some nodes are set as null
		 I inspected collectNodesPostorder for 30 minutes and find nothing
		 
		 Then I realize stack.pop() would decrease its own size, and index is moving
		 suppose stack initial size is 7, index is 0
		 then after 3 pops(), stack size is 4, index is 3
		 4th pops(): stack size is 3, index is 4, the for loops end, and there's remaining in stack
		 
		*/
		/*
		for( int i = 0; i < reverseBuildOrder.size(); i++ ) {
			buildOrder[i] = reverseBuildOrder.pop().getName();
		}*/
		
		
		int index = 0;
		while( reverseBuildOrder.isEmpty() == false ) {
			buildOrder[index] = reverseBuildOrder.pop().getName();
			index++;
		}
		
		
		return buildOrder;
	}
	
	
	
	/** 
	 * put intermediate result into reverseBuildOrder
	 * @param reverseBuildOrder
	 * @param root
	 */
	//COMPARE to textbook, I'd prefer not to return boolean because return has something to do with method's meaning, and returning hasCycle or not is not the whole meaning of the method
	//IMAGINE: this might the first time you visit the node
	
	//WRONG: Boolean is immutable; that would cause always false even there's cycle. use wrapper class instead
	//REFERENCE: https://stackoverflow.com/questions/36649522/java-boolean-value-not-changing-in-called-method
	//private static void collectNodesPostorder( Boolean hasCycle, Stack<Node_01_Status> reverseBuildOrder, Node_01_Status root ) {
	private static void collectNodesPostorder( BooleanHolder hasCycle, Stack<Node_01_Status> reverseBuildOrder, Node_01_Status root ) {
		
		//DETAIL: in our Node's implementation, it has no null children so this case would not be met.
		if( root == null ) {
			return;
		}
		
		
		//PURPOSE: quit collecting and cut off once there's cycle found
		if( hasCycle.value ) {
			return;
		}

		
		//PURPOSE: first encounter with cycle
		if( root.getStatus() == Node_01_Status.Status.PROCESSING ) {
			hasCycle.value = true;
			return;
		}
		
		
		if( root.getStatus() == Node_01_Status.Status.DONE ) {
			return;
		}
		
		//PURPOSE: when start any operation, set the status (like entering lock's critical section
		root.setStatus( Node_01_Status.Status.PROCESSING );
		
		//IMAGINE: this is similar to binary tree: F(root.left), F(root.right)
		for( Node_01_Status child : root.getChildren() ) {
			collectNodesPostorder( hasCycle, reverseBuildOrder, child);
		}
		//WRONG: uncaught exception error, because I missed right brace, and that means I should insist good code styling.
		//THINK_FURTHER: getting error in such sensitive place, would let people suspect  there's serious logically wrong bug; however, in this case it is just syntax error.  
		//if( IS_DEBUG ) { out.println("node is now be added to stack " + root != null? root.getName() : "null");
		if( IS_DEBUG ) { out.println("node is now be added to stack " +( root == null? "null" : root.getName() ) );}
		
		//post order
		reverseBuildOrder.add( root );
		//IMAGINE: (like leaving lock's critical section
		root.setStatus( Node_01_Status.Status.DONE );
	}
	
	

}


//QUESTION: why do I sometimes put class definition within, and sometimes put outside of a class
class BooleanHolder{
	public Boolean value = false;
}


