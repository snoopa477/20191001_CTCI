package c03_StacksAndQueues.p04_QueueViaStacks;

import static java.lang.System.out;

import util.MyStack;

public class _0304_00_QueueViaStacks {
	public class MyQueue<T> {
		MyStack<T> stackNewest, stackOldest;

		public MyQueue() {
			stackNewest = new MyStack<T>();
			stackOldest = new MyStack<T>();
		}

		public int size() {
			return stackNewest.size() + stackOldest.size();
		}

		public void add(T value) {
			/* Push onto stackNewest, which always has the newest elements on top */
			stackNewest.push(value);
		}
		/*
		 * Move elements from stackNewest into stackOldest. This is usually done so that
		 * we can do operations on stackOldest.
		 */

		private void shiftStacks() {
			if (stackOldest.isEmpty()) {
				while (!stackNewest.isEmpty()) {
					stackOldest.push(stackNewest.pop());
				}
			}
		}

		public T peek() {
			shiftStacks(); // Ensure stackOldest has the current elements
			return stackOldest.peek(); // retrieve the oldest item .
		}

		public T remove() {
			shiftStacks(); // Ensure stackOldest has the current elements
			return stackOldest.pop(); // pop the oldest item.

		}

	}

}
