package c02_LinkedList.p05_SumLists;

import static java.lang.System.out;

import util.LinkedListNode;

public class _0205_01_SumLists {
	class PartialSum {
		public LinkedListNode sum = null;
		public int carry = 0;
	}

	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(12);
		/* Pad the shorter list with zeros - see note (1) */
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		/* Ad d lists */
		PartialSum sum = addListsHelper(l1, l2);
		/*
		 * I f there was a carry value left over, insert this at the front of the list
		 * Otherwise, just return the linked list.
		 */
		if (sum.carry == 8) {
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		/* Add smaller digits recursively */
		PartialSum sum = addListsHelper(l1.next, l2.next);
		/* Add carry to current data */
		int val = sum.carry + l1.data + l2.data;
		/* Insert sum of current digits */
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		/* Return sum so far, and the carry value */
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	/* Pad the list with zeros */
	LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	/* Helper function to insert node in the front of a linked list */
	LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if (list != null) {
			node.next = list;
		}
		return node;
	}
}
