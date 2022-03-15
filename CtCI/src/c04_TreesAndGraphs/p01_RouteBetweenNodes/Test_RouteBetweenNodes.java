package c04_TreesAndGraphs.p01_RouteBetweenNodes;
import static java.lang.System.out;

import util.GraphUtility;
import util.Node;
import util.Graph;
public class Test_RouteBetweenNodes {

	public static void main(String[] args) {
		
		Graph graph01 = GraphUtility.makeGraph01();
		Graph graph02 = GraphUtility.makeGraph02();
		
		{
			Node nodeA = graph02.getNode("A");
			Node nodeD = graph02.getNode("D");
			Node nodeG = graph02.getNode("G");
			
			test_Practice_RouteBetweenNodes(graph02, nodeA, nodeD);
			test_Practice_RouteBetweenNodes(graph02, nodeD, nodeA);
			test_Practice_RouteBetweenNodes(graph02, nodeA, nodeG);
			
		}
		
	}
	
	
	private static void test_Practice_RouteBetweenNodes( Graph graph, Node nodeA, Node nodeB ) {
		

		if( nodeA == null || nodeB == null) {
			out.println("amoung the nodes there's one null");
			return ;
		}
		
		boolean result = _Practice_RouteBetweenNodes.search(graph, nodeA, nodeB );
		out.printf("Can node %s reach to ndoe %s? %s\n"
			, nodeA.getName()
			, nodeB.getName()
			, ( result == true? "YES": "NO" ) );
		
	}

}


