package c02_LinkedList.p06_Palindrome;

import static java.lang.System.out;

import util.LinkedListNode;

public class _0206_02_Palindrome {
	boolean isPalindrome(LinkedListNode head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}

	Result isPalindromeRecurse(LinkedListNode head, int length) {
		if (head == null || length == 0) { // Even number of nodes
			return new Result(head, true);
		} else if (length == 1) { // Odd number of nodes
			return new Result(head.next, true);
		}
		/* Recurse on sublist. */
		Result res = isPalindromeRecurse(head.next, length - 2);
		/*
		 * If child calls are not a palindrome, pass back up a failure .
		 */
		if (!res.result || res.node == null) {
			return res;
		}
		/* Check if matches corresponding node on other side. */
		res.result = (head.data == res.node.data);
		/* Return corresponding node. */
		res.node = res.node.next;
		return res;
	}

	int lengthOfList(LinkedListNode n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}
}
