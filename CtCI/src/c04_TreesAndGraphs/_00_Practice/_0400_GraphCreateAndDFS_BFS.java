package c04_TreesAndGraphs._00_Practice;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.LinkedList;

import util.Graph;
import util.GraphUtility;
import util.Node;
import util.NodeStatus;
public class _0400_GraphCreateAndDFS_BFS {

	public static void main(String[] args) {
		
		Graph[] graphs = new Graph[] {GraphUtility.makeGraph01(), GraphUtility.makeGraph02()};
		
		int counter = 1;
		for( Graph graph : graphs ) {
			out.printf("--------------------%d\n", counter);
			out.println("DFS");
			DFS( graph );
		
			out.println("BFS");
			BFS( graph );
			
			counter++;
		}
		
	}
	
	
	public static void DFS(Graph graph) {
		
		//PURPOSE: initialize
		graph.setAllUnvisited();
		
		for( Node node : graph.getNodes() ) {
			
			//PURPOSE: we iterate all nodes in a graph, guaranteeing nothing is missed, including isolated nodes
			/* REASONING: since every node is likely to be reached by other node.
			 * The current node we process might have been reached before; hence we use state to check
			 */
			//IMAGINE: like holding multiple bunches of grapes
			if( node.state == NodeStatus.Unvisited ) {
				DFS_helper(node, 0);
			}
		}
	}
	
	
	
	public static void DFS_helper(Node node, int layer) {
		
		/* REASONING: since every node is likely to be reached by other node.
		 * The current node we process might have been reached before; hence we use state to check
		 */
		if( node == null || node.state == NodeStatus.Visited ) {
			return ;
		}
		node.state = NodeStatus.Visited;
		
		//PURPOSE: print the current node
		for( int i = 0; i < layer; i++) {
			out.print("    ");
		}
		out.println(node.getName());
		
		
		Node[] adjacents = node.getAdjacent();
		//PURPOSE: we iterate all nodes in adjacents, guaranteeing nothing is missed 
		//MISTAKE: miss this line, this could be an isolated node (I coined as island)
		if( adjacents != null ) {
			for( Node adjacent : adjacents ) {
				DFS_helper(adjacent, layer + 1);
			}
		}
	}
	
	
	
	public static void BFS(Graph graph) {
		//PURPOSE: initialize
		graph.setAllUnvisited();
		
		//IMAGINE: like holding multiple bunches of grapes
		for( Node node: graph.getNodes() ) {
			
			//REASONING: visited means we already processed
			//IMAGINE: like holding multiple bunches of grapes
			if( node.state == NodeStatus.Unvisited ) {
				BFS_helper( node );
			}
		}
	}
	
	
	
	public static void BFS_helper(Node node) {
		
		if( node == null || node.state == NodeStatus.Visited ) {
			return ;
		}
		/* REPLACED
		node.state = NodeStatus.Visited;
		out.println(node.getName());
		*/
		//REASONING this queue, is our waiting line for the nodes to be processed. If empty, then no work is needed, ending the function
		LinkedList<Node> queue = new LinkedList<>();
		
		queue.addFirst(node);
		
		while( queue.isEmpty() == false ) {
			
			//DETAIL: this is how we decrease the size of queue
			//MISTAKE: first in first out is implemented by add in one side, remove from other side, not the same side
			//Node nodeFromQueue = queue.removeFirst();
			Node nodeFromQueue = queue.removeLast();
			//MISTAKE: don't forget this line
			nodeFromQueue.state = NodeStatus.Visited;
			out.println(nodeFromQueue.getName());
			
			Node[] adjacents = nodeFromQueue.getAdjacent();
			//check if this is isolated node (island)
			if( adjacents != null ) {
				for( Node adjacent : adjacents ) {
					//MISTAKE: don't forget this line. if you don't, then infinite loop awaits.
					if( adjacent.state == NodeStatus.Unvisited ) {
						queue.addFirst(adjacent);
					}//if
				}//for
			}//if
		}//while
		
	}
	
	
	
	
	
	
	
	
}



