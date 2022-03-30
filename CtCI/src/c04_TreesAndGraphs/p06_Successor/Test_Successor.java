package c04_TreesAndGraphs.p06_Successor;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import util.MyTreeNode;
import util.MyTreeNodeUtility;
public class Test_Successor {

	public static void main(String[] args) {
		HashSet<String> options = new HashSet( Arrays.asList("1", "2") );
		
		if(options.contains("1")) {
			out.println("-----------------test Successor_00");
			
			MyTreeNode root01 = MyTreeNodeUtility.makeTree01();
			for( int key = 1; key <= 15; key++ ) {
				MyTreeNode node = root01.findNodeByValue(key);
				MyTreeNode nodeSuccessor = Successor_00.getInOrderSuccessor( node );
				out.printf("the node, which value is %s, and its successor's value %s\n"
						, node == null? "x" : String.valueOf( node.data ) 
						, nodeSuccessor == null? "x" : String.valueOf( nodeSuccessor.data ) );
						//MISTAKE: check if null before access data
						//, node.data
						//, nodeSuccessor.data );
			}
		}
	}

}


