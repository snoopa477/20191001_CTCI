package c02_LinkedList.p02_ReturnKthToLast;

import static java.lang.System.out;

import util.LinkedListNode;

public class _0202_02_ReturnKthToLast {

	LinkedListNode nthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		/* Move pi k nodes into the list. */
		for (int i = 0; i < k; i++) {
			if (p1 == null)
				return null; // Out of bounds
			p1 = p1.next;
		}
		/*
		 * Move them at the same pace. When p1 hits the end, p2 will be at the right
		 * element .
		 */
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}
