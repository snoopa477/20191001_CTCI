package c02_LinkedList.p01_RemoveDups;

import static java.lang.System.out;

import util.LinkedListNode;

public class _0201_01_RemoveDups {
	void deleteDups(LinkedListNode head) {
		LinkedListNode current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {

					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}

			current = current.next;
		}
	}
}
