package c02_LinkedList.p02_ReturnKthToLast;

import static java.lang.System.out;

import util.LinkedListNode;

public class _0202_00_ReturnKthToLast {
	int printKthToLast(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
	}
}
