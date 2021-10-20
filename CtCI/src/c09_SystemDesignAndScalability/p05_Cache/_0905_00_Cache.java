package c09_SystemDesignAndScalability.p05_Cache;

import static java.lang.System.out;

import java.util.HashMap;

import util.Node;

public class _0905_00_Cache {
	public static int MAX_SIZE = 10;
	public Node head, tail;
	public HashMap<String, Node> map;
	public int size = 0;

	public _0905_00_Cache() {
		map = new HashMap<String, Node>();
	}

	/* Moves node to front of linked list */
	public void moveToFront(Node node) {
		/* … */ }

	public void moveToFront(String query) {
		/* … */}

	/* Removes node from linked list */
	public void removeFromLinkedList(Node node) {
		/* … */ }

	/* Gets results from cache, and updates linked list */
	public String[] getResults(String query) {
		if (!map.containsKey(query))
			return null;
		Node node = map.get(query);
		moveToFront(node); // update freshness
		return node.results;
	}

	/* Inserts results into linked list and hash */
	public void insertResults(String query, String[] results) {
		if (map.containsKey(query)) { // update values
			Node node = map.get(query);
			node.results = results;
			moveToFront(node); // update freshness
			return;
		}
		Node node = new Node(query, results);
		moveToFront(node);
		map.put(query, node);
		if (size > MAX_SIZE) {
			map.remove(tail.query);
			removeFromLinkedList(tail);
		}
	}
}
