package util;
import static java.lang.System.out;

import java.util.ArrayList;
public class Graph {
	private Node[] nodes;
	
	public Graph( Node[] nodes ) {
		this.nodes = nodes;
	}
	
	public Graph( ArrayList<Node> nodes ) {
		this.nodes = nodes.toArray( new Node[]{} );
	}

	public Node[] getNodes() {
		return nodes;
	}

	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	} 
	 
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes.toArray( new Node[]{} );
	} 
	
	
	public void setAllUnvisited() {
		
		for(Node node: nodes) {
			node.setState( NodeStatus.Unvisited );
		}
	}
	 
}


