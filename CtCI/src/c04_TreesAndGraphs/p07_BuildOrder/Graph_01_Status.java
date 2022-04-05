package c04_TreesAndGraphs.p07_BuildOrder;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Graph_01_Status {
	
	private static final boolean IS_DEBUG = false;
	
	private ArrayList<Node_01_Status> nodes;
	private HashMap<String, Node_01_Status> nameToNodes;
	
	
	
	public Graph_01_Status() {
		this.nodes = new ArrayList<Node_01_Status>();
		this.nameToNodes = new HashMap<>();
	}
	
	
	
	public Graph_01_Status( String[] nodeNames, String[][] dependencies ) {
		this.nodes = new ArrayList<Node_01_Status>();
		this.nameToNodes = new HashMap<>();
		build( nodeNames, dependencies );
	}
	
	
	
	public void build( String[] nodeNames, String[][] dependencies ) {
		buildNodes( nodeNames );
		buildDependencies( dependencies );
	}
	
	
	
	private void buildNodes( String[] nodeNames ) {
		
		for( String name : nodeNames ) {
			
			if( nameToNodes.containsKey( name ) == false ) {
				Node_01_Status newNode = new Node_01_Status( name );
				nodes.add(newNode);
				if(IS_DEBUG) out.println("node: " + newNode.toString());
				nameToNodes.put( name, newNode );
			}
		}
	}
	
	
	
	private void buildDependencies( String[][] dependencies ) {
		
		for( String[] dependency: dependencies ) {
			
			String parent_NodeName = dependency[0];
			//MISTAKE: this would cause node points to itself
			//String child_NodeName = dependency[0];
			String child_NodeName = dependency[1];
			
			if( nameToNodes.containsKey(parent_NodeName) && nameToNodes.containsKey(child_NodeName)) {
				
				Node_01_Status parentNode = nameToNodes.get( parent_NodeName );
				Node_01_Status childNode = nameToNodes.get( child_NodeName );
				parentNode.addChild( childNode );
			}
		}
	}
	
	
	
	public void addNode( String name ) {
		
		if( nameToNodes.containsKey( name ) == false) {
			Node_01_Status newNode = new Node_01_Status(name);
			nodes.add(newNode);
			nameToNodes.put( name, newNode );
		}
	}
	
	
	
	public void addDepency( String parent_NodeName, String child_NodeName ) {
		
		if( nameToNodes.containsKey(parent_NodeName) && nameToNodes.containsKey(child_NodeName)) {
			Node_01_Status parentNode = nameToNodes.get( parent_NodeName );
			Node_01_Status childNode = nameToNodes.get( child_NodeName );
			parentNode.addChild( childNode );
		}
	}
	
	
	
	public void showAllNodes() {
		
		nodes.forEach( node -> 
			//MISTAKE: showing means print out
			//node.toString();
			out.println(node.toString()) );
	}
	
	
	
	public ArrayList<Node_01_Status> getAllNodes(){
		return nodes;
	}
	
	
	
	public Node_01_Status getNodeByName( String name ) {
		
		if( nameToNodes.containsKey( name ) ) {
			return nameToNodes.get( name );
		}
		else {
			return null;
		}
		
	}
	
	
	
	
}


