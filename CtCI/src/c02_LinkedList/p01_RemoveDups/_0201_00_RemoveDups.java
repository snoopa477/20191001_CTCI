package c02_LinkedList.p01_RemoveDups;

import static java.lang.System.out;

import java.util.HashSet;

import util.LinkedListNode;

public class _0201_00_RemoveDups {
	void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
}
