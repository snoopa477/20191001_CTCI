package chap4_Trees_and_Graphs;

import java.util.*;

import static java.lang.System.out;

public class Problem7_Build_Order {

	public static void main(String[] args) {

		String[] projects = {"a", "b", "c", "d","e", "f"};
		String[][] dependencies = {{"a","d"}, {"f", "b"}, {"b","d"},
				{"f","a"}, {"d","c"}};
		
		Graph graph = new Graph();
		
		for( String project: projects) {
			graph.createNode(project);
		}
		
		for(String[] depedency : dependencies) {
			out.println("++++++++++++++++++++++++++++++++++++");
			out.println("dependency: " + depedency[0] + " " + depedency[1]);
			Node parent = graph.nodes.get(depedency[0]);
			Node child = graph.nodes.get(depedency[1]);
			
			graph.addEdge(parent, child);
			parent.getInfo();
			child.getInfo();
		}
		
		out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		graph.showNodesInfo();
		
		//String result[] = new String[projects.length];
		Set<String> result = new LinkedHashSet<String>();
		while( result.size() < projects.length) {
			ArrayList<String> nodesNoDependencies = 
					graph.getAllNodesNoDependencies();
			graph.updateChildrenNodes(nodesNoDependencies);
			
			result.addAll( nodesNoDependencies );
		}
		
		
		
		for(String elt: result) {
			System.out.print(elt + " ");
		}
		
	}
	
	public static class Graph{
		private HashMap<String,Node> nodes;
		
		public Graph() {
			nodes = new HashMap<String, Node>();
		}
		
		void createNode(String name) {
			if( ! nodes.containsKey(name) ) {
				nodes.put(name, new Node(name));
			}
		}
		
		void addEdge(Node parent, Node child) {
			parent.children.put(child.getName(), child);
			child.parents.put(parent.getName(), parent);
			
		}
		
		ArrayList<String> getAllNodesNoDependencies(){
			
			ArrayList<String> result = new ArrayList<>();
			
			for( String key : nodes.keySet() ) {
				Node node = nodes.get(key);
				if(node.isNoDependency()) {
					result.add(node.getName());
				}
			}
			
			return result;
		}
		
		void updateChildrenNodes(ArrayList<String> str_parents) {
			
			for(String str_parent: str_parents) {
				Node parent = nodes.get(str_parent);
				for(String str_child: parent.children.keySet()) {
					Node child = parent.children.get(str_child);
					child.parents.remove(str_parent);
				}
			}
			
		}
		
		public void showNodesInfo() {
			for(String key : nodes.keySet()) {
				nodes.get(key).getInfo();
			}
		}
		
		
	}
	
	
	private static class Node{
		HashMap<String,Node> children;
		HashMap<String,Node> parents;
		
		String name;
		
		public String getName() {
			return name;
		}

		public Node(String name) {
			children = new HashMap<String, Node>();
			parents = new HashMap<String, Node>();
			this.name = name;
		}
		
		public int getDependency() {
			
			return parents.size();
		}
		
		public boolean isNoDependency() {
			return getDependency() == 0;
		}
		
		public void getParentsInfo() {
			out.print("parent: ");
			for(String key: parents.keySet()) {
				out.print("[" + key + " " + parents.get(key).getName() + "] ");
			}
			out.println();
		}
		
		public void getChildrenInfo() {
			out.print("children: ");
			for(String key: children.keySet()) {
				out.print("[" + key + " " + children.get(key).getName() + "] ");
			}
			out.println();
		}
		
		public void getInfo() {
			out.println("------------------------");
			out.println("name: " + name + "; hascode: [" + hashCode() + "]");
			getParentsInfo();
			getChildrenInfo();
		}
		
		
	}
	
	static void print(HashSet<String> set) {
		
		for(String elt : set)	{
			System.out.print( elt + " ");
		}
		System.out.println("");
	}
	

}
