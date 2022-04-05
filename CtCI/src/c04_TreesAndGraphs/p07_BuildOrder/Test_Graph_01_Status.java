package c04_TreesAndGraphs.p07_BuildOrder;
import static java.lang.System.out;

import java.util.ArrayList;
public class Test_Graph_01_Status {

	public static void main(String[] args) {
		
		String[] projects01 = { "A", "B", "C", "D", "E", "F", "G" };
		String[][] dependnecies01 = { 
				{"F", "C"}, { "F", "A" }, { "F", "B" }, { "C", "A" }
				, { "B", "A" }, { "B", "E" }, { "A", "E" }, { "D", "G" } };
		
		String[] projects02 = { "A", "B", "C", "D", "E", "F" };
		String[][] dependnecies02 = { 
				{"F", "A"}, { "F", "B" }, { "A", "D" }, { "B", "D" }
				, { "D", "C" } };
		
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

}


