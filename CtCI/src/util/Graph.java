package util;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
public class Graph {
	private Node[] nodes;
	
	//REASONING: to access certain node
	private HashMap<String, Node> nameToNode;
	
	public Graph( Node[] nodes ) {
		this.nameToNode = new HashMap<>();
		this.nodes = nodes;
		setNameToNode();
	}
	
	public Graph( ArrayList<Node> nodes ) {
		this.nameToNode = new HashMap<>();
		this.nodes = nodes.toArray( new Node[]{} );
		//MISTAKE: forget this line
		setNameToNode();
	}

	public Node[] getNodes() {
		return nodes;
	}
	
	
	public Node getNode(String nodeName) {
		
		if( nameToNode.containsKey(nodeName) ) {
			return nameToNode.get(nodeName);
		}
		return null;
	}
	

	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
		setNameToNode();
	} 
	 
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes.toArray( new Node[]{} );
		setNameToNode();
	} 
	
	
	public void setAllUnvisited() {
		
		for(Node node: nodes) {
			node.setState( NodeStatus.Unvisited );
		}
	}
	
	
	private void setNameToNode() {
		
		for(Node node: nodes) {
			nameToNode.put(node.getName(), node);
		}
		
	}
	
	
	 
}


