package c02_LinkedList.p04_Partition;

import static java.lang.System.out;

import util.LinkedListNode;

public class _0204_01_Partition {
	LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node at head. */
				node.next = head;
				head = node;
			} else {
				/* Insert node at tail . */
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		// The head has changed, so we need to return it to the user.
		return head;
	}
}
