package c03_StacksAndQueues.p02_StackMin;

import static java.lang.System.out;

import util.MyStack;

public class _0302_01_StackMin {
	public class StackWithMin2 extends MyStack<Integer> {
		MyStack<Integer> s2;

		public StackWithMin2() {
			s2 = new MyStack<Integer>();
		}

		public void push(int value) {
			if (value <= min()) {
				s2.push(value);
			}
			super.push(value);
		}

		public Integer pop() {
			int value = super.pop();
			if (value == min()) {
				s2.pop();
			}
			return value;
		}

		public int min() {
			if (s2.isEmpty()) {
				return Integer.MAX_VALUE;
			} else {
				return s2.peek();
			}
		}
	}
}
