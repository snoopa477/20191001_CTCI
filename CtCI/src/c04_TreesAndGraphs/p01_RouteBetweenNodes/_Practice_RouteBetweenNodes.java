package c04_TreesAndGraphs.p01_RouteBetweenNodes;
import static java.lang.System.out;

import java.util.LinkedList;

import util.Graph;
import util.Node;
import util.NodeStatus;
public class _Practice_RouteBetweenNodes {

	public static boolean search(Graph graph, Node nodeA, Node nodeB) {
		
		graph.setAllUnvisited();
		
		//DETAIL: working queue, any node that is adjacent will be added. it's like traverse subgraph, starting from nodeA
		LinkedList<Node> queue = new LinkedList<>();
		queue.addFirst(nodeA);
		
		//DETAIL: it's similar to BFS traverse. more like subGraph traverse
		while( queue.isEmpty() == false ) {
			
			//THINK_FURTHER: anyNode ( including first Node, nodeA) will be treated equally
			Node currentNode = queue.removeLast();
			//WRONG if I forget to mark node as visited -> if there's cycle, then it's inifite loop
			currentNode.setState(NodeStatus.Visited);
			
			if( currentNode == nodeB ) {
				//DETAIL: no need to further exploration
				return true;
			}
			
			Node[] adjacents = currentNode.getAdjacent();
			if( adjacents != null ) {
				for( Node adjacent : adjacents ) {
					//PURPOSE: ready for the next loop, only for unvisited node. visited node means it is processed before
					if( adjacent.state == NodeStatus.Unvisited ) {
						queue.add( adjacent );
					}
				}
			}
			
		}
		
		//THINK_FURTHER empty queue means exploration completes yet no NodeB -> not found
		return false;
	}
	
	
}


