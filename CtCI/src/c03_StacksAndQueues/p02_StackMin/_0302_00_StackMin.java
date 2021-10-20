package c03_StacksAndQueues.p02_StackMin;

import static java.lang.System.out;

import util.MyStack;

public class _0302_00_StackMin {
	public class StackWithMin extends MyStack<NodeWithMin> {
		public void push(int value) {
			int newMin = Math.min(value, min());
			super.push(new NodeWithMin(value, newMin));
		}

		public int min() {
			if (this.isEmpty()) {
				return Integer.MAX_VALUE; // Error value
			} else {
				return peek().min;
			}
		}
	}

	class NodeWithMin {
		public int value;
		public int min;

		public NodeWithMin(int v, int min) {
			value = v;
			this.min = min;
		}
	}
}
