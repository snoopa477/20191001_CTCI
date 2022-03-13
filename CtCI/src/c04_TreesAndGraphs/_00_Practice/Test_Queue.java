package c04_TreesAndGraphs._00_Practice;
import static java.lang.System.out;

import java.util.LinkedList;
public class Test_Queue {

	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<>();
		
		String[] elements = {"C", "A", "T"};
		
		out.println("addFirst");
		for(String element : elements ) {
			out.printf("%s ", element);
			queue.addFirst(element);
		}
		out.println();
		
		
		out.println("show all elements in the queue");
		while( queue.isEmpty() == false ) {
			out.printf("%s ", queue.removeLast());
		}
		out.println();
		
		
	}

}


