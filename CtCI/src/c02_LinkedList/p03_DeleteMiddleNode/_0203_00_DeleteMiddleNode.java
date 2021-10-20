package c02_LinkedList.p03_DeleteMiddleNode;

import static java.lang.System.out;

import util.LinkedListNode;

public class _0203_00_DeleteMiddleNode {
	boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
}
