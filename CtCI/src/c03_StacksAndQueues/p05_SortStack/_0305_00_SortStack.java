package c03_StacksAndQueues.p05_SortStack;

import static java.lang.System.out;

import util.MyStack;

public class _0305_00_SortStack {
	void sort(MyStack<Integer> s) {
		MyStack<Integer> r = new MyStack<Integer>();
		while (!s.isEmpty()) {
			/* Insert each element in s in sorted order into r. */
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		/* Copy the elements from r back into s. */
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
	}
}
