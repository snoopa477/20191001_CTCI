package c02_LinkedList.p02_ReturnKthToLast;

import static java.lang.System.out;

import util.LinkedListNode;

public class _0202_01_ReturnKthToLast {
	class Index {
		public int value = 0;
	}

	LinkedListNode kthToLast(LinkedListNode head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		LinkedListNode node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;
		if (idx.value == k) {
			return head;
		}
		return node;
	}
}
