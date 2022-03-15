package util;
import static java.lang.System.out;

import java.util.ArrayList;
public class GraphUtility {

	/*
	DFS
	0
	    1
	        3
	            2
	            4
	    5
	6
	
	BFS
	0
	1
	4
	5
	3
	4
	2
	6
	 * */
	public static  Graph makeGraph01() {
		
		ArrayList<Node> nodes = new ArrayList<>();
		
		Node node0 = new Node("0");
		nodes.add(node0);
		Node node1 = new Node("1");
		nodes.add(node1);
		Node node2 = new Node("2");
		nodes.add(node2);
		Node node3 = new Node("3");
		nodes.add(node3);
		Node node4 = new Node("4");
		nodes.add(node4);
		Node node5 = new Node("5");
		nodes.add(node5);
		Node node6 = new Node("6");
		nodes.add(node6);
		
		node0.setChildren( new Node[]{node1, node4, node5} );
		node1.setChildren( new Node[]{node3, node4} );
		node2.setChildren( new Node[]{node1} );
		node3.setChildren( new Node[]{node2, node4} );
		node4.setChildren( null );
		node5.setChildren( null );
		node6.setChildren( null );
		
		return new Graph( nodes );
	}
	
	
	/*
	DFS
	A
	    B
	        C
	            E
	                D
	                F
	G
	H
	    I
	        J
	        
	BFS
	A
	B
	C
	E
	D
	F
	G
	H
	I
	J 
	 * 
	 */
	public static  Graph makeGraph02() {
		
		ArrayList<Node> nodes = new ArrayList<>();
		
		Node nodeA = new Node("A");
		nodes.add(nodeA);
		Node nodeB = new Node("B");
		nodes.add(nodeB);
		Node nodeC = new Node("C");
		nodes.add(nodeC);
		Node nodeD = new Node("D");
		nodes.add(nodeD);
		Node nodeE = new Node("E");
		nodes.add(nodeE);
		Node nodeF = new Node("F");
		nodes.add(nodeF);
		Node nodeG = new Node("G");
		nodes.add(nodeG);
		Node nodeH = new Node("H");
		nodes.add(nodeH);
		Node nodeI = new Node("I");
		nodes.add(nodeI);
		Node nodeJ = new Node("J");
		nodes.add(nodeJ);
		
		
		nodeA.setChildren( new Node[]{nodeB} );
		nodeB.setChildren( new Node[]{nodeC} );
		nodeC.setChildren( new Node[]{nodeE} );
		nodeD.setChildren( new Node[]{nodeB} );
		nodeE.setChildren( new Node[]{nodeD, nodeF} );
		nodeF.setChildren( null );
		nodeG.setChildren( null );
		nodeH.setChildren( new Node[]{nodeI, nodeG} );
		nodeI.setChildren( new Node[]{nodeG, nodeJ} );
		nodeJ.setChildren( new Node[]{nodeI} );
		
		return new Graph( nodes );
	}
	
}


