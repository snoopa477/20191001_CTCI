package util;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Stack;
public class StackPrinter {
	
	public static void print(Stack<Integer> stack) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		while( stack.isEmpty() == false) {
			list.add(stack.pop());
		}
		
		for(int i = list.size() -1; i >= 0; i --) {
			int element = list.get(i);
			out.print(element + " ");
			stack.add(element);
		}
		out.println();
		
	}

}


