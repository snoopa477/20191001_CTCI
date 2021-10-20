package c04_TreesAndGraphs.p01_RouteBetweenNodes;

import static java.lang.System.out;

import java.util.LinkedList;

import util.Graph;
import util.Node;

public class _0401_00_RouteBetweenNodes {
	enum State {
		Unvisited, Visited, Visiting;
	}

	boolean search(Graph g, Node start, Node end) {
		if (start == end)
			return true;
		// operates as Queue
		LinkedList<Node> q = new LinkedList<Node>();
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst(); // i.e., dequeue()
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}

				}

				u.state = State.Visited;
			}
		}
		return false;
	}
}
