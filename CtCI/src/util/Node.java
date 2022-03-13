package util;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class Node {
	
	private String name;
	public NodeStatus state;
	private Node[] children;

	
	public Node(String name) {
		this.name = name;
		this.state = NodeStatus.Unvisited;
	}

	
	public Node(String name, Node[] children) {
		this.name = name;
		this.children = children;
		this.state = NodeStatus.Unvisited;
	}

	
	public Node(String name, ArrayList<Node> children) {
		this.name = name;
		this.children = children.toArray(new Node[0]);
		;
		this.state = NodeStatus.Unvisited;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public NodeStatus getState() {
		return state;
	}

	
	public void setState(NodeStatus state) {
		this.state = state;
	}

	
	public Node[] getChildren() {
		return children;
	}
	
	
	public Node[] getAdjacent() {
		return children;
	}

	
	public void setChildren(Node[] children) {
		this.children = children;
	}

	
}




