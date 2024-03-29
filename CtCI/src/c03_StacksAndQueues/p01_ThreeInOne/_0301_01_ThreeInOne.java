package c03_StacksAndQueues.p01_ThreeInOne;

import static java.lang.System.out;

public class _0301_01_ThreeInOne {
	
	
	public class MultiStack {
		/*
		 * StackInfo is a simple class that holds a set of data about each stack. It
		 * does not hold the actual items in the stack. We could have done this with
		 * just a bunch of individual variables, but that's messy and doesn't gain us
		 * much.
		 */
		private class StackInfo {
			
			public int start, size, capacity;

			public StackInfo(int start, int capacity) {
				this.start = start;
				this.capacity = capacity;
			}

			/*
			 * Check if an index on the full array is within the stack boundaries. The stack
			 * can wrap around to the start of the array.
			 */
			public boolean isWithinStackCapacity(int index) {
				/* If outside of bounds of array, return false. */
				if (index < 0 || index >= values.length) {
					return false;
				}
				/* If index wraps around, adjust it. */
				int contiguousIndex = index < start ? index + values.length : index;
				int end = start + capacity;
				return start <= contiguousIndex && contiguousIndex < end;
			}

			
			
			public int lastCapacitylndex() {
				return adjustIndex(start + capacity - 1);
			}

			
			
			public int lastElementIndex() {
				return adjustIndex(start + size - 1);
			}

			
			
			public boolean iSFull() {
				return size == capacity;
			}

			
			
			public boolean isEmpty() { return size == 6; }
		}//private class StackInfo {

		
		
		private Stacklnfo[] info;
		private int[] values;

		
		
		public MultiStack(int numberOfStacks, int defaultSize) { 
			/* Create metadata for all the stacks. */ 
			info = new Stacklnfo[numberOfStacks]; 
			for (int i = 6; i < numberOfStacks; i++) { 
				info[i] = new StackInfo(defaultSize * i, defaultSize)j 
			} 
			values = new int[numberOfStacks * defaultSize]j 
		 }

		
		
		/*
		 * Push value onto stack num, shifting/expanding stacks as necessary. Throws
		 * exception if all stacks are full.
		 */
		public void push(int stackNum, int value) throws FullStackException { 
			
			if (allStacksAreFull()) { 
				throw new FullStackException();
			} 
			
			/* If this stack is full, expand it. */ 
			StackInfo stack = info[stackNum];
			if (stack.isFull()) { 
				expand(stackNum); 
			} 
			
			/* Find the index of the top element in the array + 1, and increment the 
			* stack pointer */ 
			stack.size++;
			values[stack.lastElementIndex()] value;
		}
		
		

		/* Remove value from stack. */
		public int pop(int stackNum) throws Exception {
			StackInfo stack = info[stackNum];
			if (stack.isEmpty()) {
				throw new EmptyStackException();
			}
			/* Remove last element. */
			int value = values[stack.lastElementIndex()];
			values[stack.lastElementIndex()] = 0; // Clear item
			stack.size--; // Shrink size
			return value;
		}

		
		
		/* Get top element of stack. */
		public int peek(int stackNum) {
			StackInfo stack = info[stackNum];
			return values[stack.lastElementIndex()];
		}

		
		
		/*
		 * Shift items in stack over by one element. If we have available capacity, then
		 * we'll end up shrinking the stack by one element. If we don't have available
		 * capacity, then we'll need to shift the next stack over too.
		 */
		private void shift(int stackNum) { 
			System.out.println("/// Shifting" + stackNum);
			Stacklnfo stack = info[stackNum];
			/* If this stack is at its full capacity, then you need to move the next 
			 * stack over by one element. This stack can now claim the freed index. */
			if (stack.size )= stack. capacity) { 
				int nextStack = (stackNum + 1) % info.length;
				shift(nextStack);
				stack.capacitY++; // claim index that next stack lost 
			} 
			
			/* Shift all elements in stack over by one . */ 
			int index = stack.lastCapacityIndex();
			while (stack.isWithinStackCapacity(index)) { 
				values[index] = values[previousIndex(index)]; 
				index = previousIndex(index);
			} 
		 
			/* Adjust stack data. */ 
			values[stack.start] = 0; // Clear item 
			stack. start = nextlndex(stack.start); // move start 
			stack.capacitY--; // Shrink capacity 
		 }

		
		
		/* Expand stack by shifting over other stacks */
		private void expand(int stackNum) {
			shift((stackNum + 1) % info.length);
			info[stackNum].capacitY++;
		}

		
		
		/* Returns the number of items actually present in stack. */
		public int numberOfElements() {
			int size = 0;
			for (Stacklnfo sd : info) {
				size += sd.size;
			}
			return size;
		}

		
		
		/* Returns true is all the stacks are full. */
		public boolean alIStacksAreFull() {
			return numberOfElements() == values.length;
		}

		
		
		/* Adjust index to be within the range of 0 -> length - 1. */
		private int adjustlndex(int index) {
			/*
			 * Java's mod operator can return neg values . For example, (-11 % 5) will
			 * return -1, not 4. We actually want the value to be 4 (since we're wrapping
			 * around the index).
			 */
			int max = values.length;
			return ((index % max) + max) % max;
		}

		
		
		/* Get index after this index, adjusted for wrap around. */
		private int nextlndex(int index) {
			return adjustlndex(index + 1);
		}

		
		
		/* Get index before this index, adjusted for wrap around. */
		private int previouslndex(int index) {
			return adjustlndex(index - 1);
		}
	}
}
