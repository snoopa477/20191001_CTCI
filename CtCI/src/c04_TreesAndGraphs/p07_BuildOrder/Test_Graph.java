package c04_TreesAndGraphs.p07_BuildOrder;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class Test_Graph {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet( Arrays.asList( "2" ) );
		
		String[] projects01 = { "A", "B", "C", "D", "E", "F", "G" };
		String[][] dependnecies01 = { 
				{"F", "C"}, { "F", "A" }, { "F", "B" }, { "C", "A" }
				, { "B", "A" }, { "B", "E" }, { "A", "E" }, { "D", "G" } };
		
		String[] projects02 = { "A", "B", "C", "D", "E", "F" };
		String[][] dependnecies02 = { 
				{"F", "A"}, { "F", "B" }, { "A", "D" }, { "B", "D" }
				, { "D", "C" } };
		
		if( options.contains("1") ) {
			out.println("test Graph_01_Status");
			Graph_01_Status graph01 = new Graph_01_Status(projects01, dependnecies01);
			out.println("graph01.showAllNodes();");
			graph01.showAllNodes();
	
			graph01.addNode("H");
			graph01.addDepency("H", "G");
			
			out.println("graph01.showAllNodes();\n"
					+ "graph01.addNode(\"H\");\n"
					+ "graph01.addDepency(\"H\", \"G\");");
			graph01.showAllNodes();
			
			
			Node_01_Status nodeA = new Node_01_Status("A");
			Node_01_Status nodeB = new Node_01_Status("B");
			nodeA.addChild( nodeB );
			out.print(nodeA.toString());
		}
		
		if( options.contains("2") ) {
			out.println("test Graph_02_Dependency");
			Graph_02_Dependency graph01 = new Graph_02_Dependency(projects01, dependnecies01);
			out.println("graph01.toString()");
			
			out.println(graph01.toString());
			
			/*
			graph01.addNode("H");
			graph01.addDepency("H", "G");
			
			out.println("graph01.showAllNodes();\n"
					+ "graph01.addNode(\"H\");\n"
					+ "graph01.addDepency(\"H\", \"G\");");
			graph01.showAllNodes();
			*/
			
			Node_01_Status nodeA = new Node_01_Status("A");
			Node_01_Status nodeB = new Node_01_Status("B");
			nodeA.addChild( nodeB );
			out.print(nodeA.toString());
		}
		
		
		
	}

}


