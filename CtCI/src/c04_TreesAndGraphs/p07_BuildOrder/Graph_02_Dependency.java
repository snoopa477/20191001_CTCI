package c04_TreesAndGraphs.p07_BuildOrder;
import java.util.ArrayList;
import java.util.HashMap;
import static java.lang.System.out;
/**
 * User would use this class to build nodes, and then manage all of them.
 * <br>Managing nodes means
 * <li> access certain node by name
 * <li> get all the nodes
 */
//THINK_FURTHER: User would not know the class Node_02_Depency; for them, they simply call node's name
public class Graph_02_Dependency {

	//Question: could we simply use nameToNodes, replacing nodes functionality?
	private ArrayList<Node_02_Dependency> nodes;
	//Use this to access node by name, and can check whether we already has such node when building
	private HashMap<String, Node_02_Dependency> nameToNodes;
	
	
	
	public Graph_02_Dependency() {
		nodes = new ArrayList<>();
		nameToNodes = new HashMap<>();
	}
	
	
	public Graph_02_Dependency( String[] nodeNames, String[][] dependencies ) {
		nodes = new ArrayList<>();
		nameToNodes = new HashMap<>();
		build( nodeNames, dependencies );
	}
	
	
	
	public void build( String[] nodeNames, String[][] dependencies ) {
		
		//PURPOSE: create nodes, and register them to graph
		/*THINK_FURTHER
		 * It's the responsibility of a node to construct itself, and add dependency
		 * It's the responsibility of a graph to register a new node to its ArrayList and HashMap, if the incoming node name is not repeated
		 */
		for( String nodeName : nodeNames ) {
			if( nameToNodes.containsKey(nodeName) == false ) {
				Node_02_Dependency newNode = new Node_02_Dependency( nodeName );
				nodes.add( newNode );
				nameToNodes.put( nodeName, newNode );
			}
		}
		
		
		//PURPOSE: add dependency, if noth nodes are existing
		for( String[] dependency : dependencies ) {
			
			String parent_NodeName = dependency[0];
			String child_NodeName = dependency[1];
			
			if( nameToNodes.containsKey(parent_NodeName) && nameToNodes.containsKey(child_NodeName)) {
				Node_02_Dependency parent_Node = nameToNodes.get(parent_NodeName);
				Node_02_Dependency child_Node = nameToNodes.get(child_NodeName);
				parent_Node.addChild( child_Node );
			}
		}
	}
	
	
	
	public ArrayList<Node_02_Dependency> getNodes() {
		return nodes;
	}
	
	
	
	public Node_02_Dependency getNodeByName(String name) {
		
		if( nameToNodes.containsKey(name) ) {
			return nameToNodes.get(name);
		}
		return null;
	}
	
	
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		nodes.forEach( node -> stringBuilder.append(node.toString() + "\n") );
		return stringBuilder.toString();
	}
	
	
}


