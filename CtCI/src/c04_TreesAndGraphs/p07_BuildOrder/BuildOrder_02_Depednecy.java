package c04_TreesAndGraphs.p07_BuildOrder;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;


public class BuildOrder_02_Depednecy {
	
	static final boolean IS_DEBUG = false;

	public static String[] buildOrder( String[] nodeNames, String[][] dependencies ) {
		
		Graph_02_Dependency graph = new Graph_02_Dependency( nodeNames, dependencies );
		//DETAIL: number of elements of orders equal to number of nodes
		Node_02_Dependency[] nodeOrders = new Node_02_Dependency[ nodeNames.length ];
		
		//DETAIL: index of right bound exclusive of an array
		IntegerHolder index_RightBound = new IntegerHolder();
		index_RightBound.value = 0;
		//DETAIL: a index where we going to calculate the node the pivot index points to
		IntegerHolder index_Pivot = new IntegerHolder();
		index_Pivot.value = 0;
		
		//ArrayList<Node_02_Dependency> zeroDependencyNodes;
		ArrayList<Node_02_Dependency> independent_Nodes;
		//PURPOSE: first time we scan every node in a graph to see if there's zero dependency node
		independent_Nodes = findIndependentNodes( graph.getNodes() );
		addNodesToOrder(nodeOrders, index_RightBound, independent_Nodes);
		
		//THINK_FURTHER: if indexPivot = indexRight , that means all the nodes are already visited and calculated; yet no new zero dependency node found -> end the task
		while( index_Pivot.value < index_RightBound.value ) {
			
			Node_02_Dependency current_Node = nodeOrders[ index_Pivot.value ];
			/* WRONG if I symbolically remove all nodes, which were found independent, because that would make certain node dependency to 0 all of a sudden, and in its ALL parents perspectives, the node is dependency is 0 to them, causing the node repeatedly added to result list. This is not correct.
			 * To correct this, we symbolically remove node one at a time, so there's only one parent that would see its child's dependency as 0*/
			removeNodeAndUpdateChildren( current_Node );
			//THINK_FURTHER: the reason the graph is not used but node children instead is if graph is used; then some node, which already be found would be found again. We only search for nodes that are recently affect.
			independent_Nodes = findIndependentNodes( current_Node.getChildren() );
			addNodesToOrder(nodeOrders, index_RightBound, independent_Nodes);
			index_Pivot.value++;
		}
		
		
		//THINK_FURTHER: there's cycle
		if( index_RightBound.value < nodeOrders.length ) {
			return null;
		}
		
		String[] buildOrder = new String[ nodeNames.length ];
		for( int i = 0; i < nodeOrders.length; i++ ) {
			buildOrder[i] = nodeOrders[i].getName();
		}
		
		
		return buildOrder;
	}
	
	
	
	//private static ArrayList<Node_02_Dependency> findZeroDependencyNodes( ArrayList<Node_02_Dependency> nodes ) {
	private static ArrayList<Node_02_Dependency> findIndependentNodes( ArrayList<Node_02_Dependency> nodes ) {
		
		ArrayList<Node_02_Dependency> list = null;
		boolean isFirstTime = true;
		
		for( Node_02_Dependency node: nodes ) {
			if( node.getDependency() == 0 ) {
				if( isFirstTime ) {
					list = new ArrayList<>();
					isFirstTime = false;
				}
				list.add( node );
			}
		}
		
		return list;
	}
	
	
	
	//private static void removeNodeByDecreasingChildrenDependency( Node_02_Dependency node ) {
	private static void removeNodeAndUpdateChildren( Node_02_Dependency node ) {
		//sybolically remove the node meaning doing nothing
		for( Node_02_Dependency child : node.getChildren() ) {
			child.dependencyDecreases();
		}
	}
	
	
	
	/** symbolically remove nodes from graph by decreasing each node's children's dependencies,
	 * this could possibly causing some node's dependency down to 0
	 */
	@Deprecated
	private static void symbolicallyRemoveNode( ArrayList<Node_02_Dependency> nodes ) {
		
		if( nodes == null ) {
			return;
		}
		
		for( Node_02_Dependency node: nodes ) {
			for( Node_02_Dependency child : node.getChildren() ) {
				child.dependencyDecreases();
			}
		}
	}
	
	
	
	private static void addNodesToOrder(Node_02_Dependency[] nodeOrders, IntegerHolder indexRight, ArrayList<Node_02_Dependency> nodes) {
		
		if( nodes == null ) {
			return;
		}
		
		for( Node_02_Dependency node: nodes ) {
			nodeOrders[ indexRight.value ] = node;
			indexRight.value++;
		}
	}
	
	
	
	private static void showDebugMessage( Graph_02_Dependency graph, Node_02_Dependency currentNode, Node_02_Dependency[] nodeOrders, IntegerHolder indexRight, ArrayList<Node_02_Dependency> nodes) {
		
		if( IS_DEBUG == false ) {
			return ;
		}
		
		out.println("----------------------------------");
		
		out.printf("all nodes: ");
		graph.getNodes().forEach( node ->{
			
			out.printf("{%s,%d}", node.getName(), node.getDependency());
			
		} );
		out.println();
		
		out.printf("currentNode {%s, %d}\n", currentNode.getName(), currentNode.getDependency());
		
		out.println("nodeOrders");
		if( nodeOrders.length > 0 ) {
			Arrays.asList( nodeOrders ).forEach( node -> {
				if( node != null ) {
					out.printf("{%s,%d} ", node.getName(), node.getDependency());
				}
				} );
		}
		else {
			out.println("no element yet");
		}
		out.println();
		
		out.printf("indexRight is %d \n", indexRight.value);
		
		out.println("nodes");
		if( nodes != null && nodes.size() > 0 ) {
			nodes.forEach(node -> out.printf("%s ", node.getName()) );
		}
		else {
			out.println("no element yet");
		}
		out.println();
		
	}
	
	
}



class IntegerHolder{
	public Integer value = 0;
}



