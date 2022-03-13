package c04_TreesAndGraphs._00_Practice;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.LinkedList;

import util.Graph;
import util.Node;
import util.NodeStatus;
public class _0400_GraphCreateAndDFS_BFS {

	public static void main(String[] args) {
		
		Graph graph01 = makeGraph01();
		out.println("DFS");
		DFS( graph01 );
		
		out.println("BFS");
		BFS( graph01 );
		
	}
	
	/*
	DFS
	0
	    1
	        3
	            2
	            4
	    5
	6
	
	BFS
	0
	1
	4
	5
	3
	4
	2
	6
	 * */
	public static  Graph makeGraph01() {
		
		ArrayList<Node> nodes = new ArrayList<>();
		
		Node node0 = new Node("0");
		nodes.add(node0);
		Node node1 = new Node("1");
		nodes.add(node1);
		Node node2 = new Node("2");
		nodes.add(node2);
		Node node3 = new Node("3");
		nodes.add(node3);
		Node node4 = new Node("4");
		nodes.add(node4);
		Node node5 = new Node("5");
		nodes.add(node5);
		Node node6 = new Node("6");
		nodes.add(node6);
		
		node0.setChildren( new Node[]{node1, node4, node5} );
		node1.setChildren( new Node[]{node3, node4} );
		node2.setChildren( new Node[]{node1} );
		node3.setChildren( new Node[]{node2, node4} );
		node4.setChildren( null );
		node5.setChildren( null );
		node6.setChildren( null );
		
		return new Graph( nodes );
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



