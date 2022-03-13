package c04_TreesAndGraphs.p01_RouteBetweenNodes;

import static java.lang.System.out;

import java.util.LinkedList;

import util.Graph;
import util.Node;
import util.NodeStatus;

public class _0401_00_RouteBetweenNodes {

	boolean search(Graph g, Node start, Node end) {
		if (start == end)
			return true;
		// operates as Queue
		LinkedList<Node> q = new LinkedList<Node>();
		for (Node u : g.getNodes()) {
			u.state = NodeStatus.Unvisited;
		}
		start.state = NodeStatus.Visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst(); // i.e., dequeue()
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == NodeStatus.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = NodeStatus.Visiting;
							q.add(v);
						}
					}

				}

				u.state = NodeStatus.Visited;
			}
		}
		return false;
	}
}
