package c09_SystemDesignAndScalability.p02_SocialNetwork;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class _0902_00_SocialNetwork {
	LinkedList<_0902_01_Person> findPathBiBFS(HashMap<Integer, _0902_01_Person> people, int source, int destination) {
		_0902_00_BFSData sourceData = new _0902_00_BFSData(people.get(source));
		_0902_00_BFSData destData = new _0902_00_BFSData(people.get(destination));
		while (!sourceData.isFinished() && !destData.isFinished()) {
			/* Search out from source. */
			_0902_01_Person collision = searchLevel(people, sourceData, destData);
			if (collision != null) {
				return mergePaths(sourceData, destData, collision.getID());
			}
			/* Search out from destination. */
			collision = searchLevel(people, destData, sourceData);
			if (collision != null) {
				return mergePaths(sourceData, destData, collision.getID());
			}
		}
		return null;
	}

	/* Search one level and return collision, if any. */
	_0902_01_Person searchLevel(HashMap<Integer, _0902_01_Person> people, _0902_00_BFSData primary,
			_0902_00_BFSData secondary) {
		/*
		 * We only want to search one level at 0 time. Count how many nodes are cu r
		 * rently in the primary's level and only do that many nodes. We'll continue to
		 * add nodes to the end.
		 */
		int count = primary.toVisit.size();
		for (int i = 0; i < count; i++) {
			/* Pullout first node. */
			_0902_00_PathNode pathNode = primary.toVisit.poll();
			int personld = pathNode.getPerson().getID();
			/* Check if it's already been visited. */
			if (secondary.visited.containsKey(personld)) {
				return pathNode.getPerson();
			}
			/* Add friends to queue. */
			_0902_01_Person person = pathNode.getPerson();
			ArrayList<Integer> friends = person.getFriends();
			for (int friendld : friends) {
				if (!primary.visited.containsKey(friendld)) {
					_0902_01_Person friend = people.get(friendld);
					_0902_00_PathNode next = new _0902_00_PathNode(friend, pathNode);
					primary.visited.put(friendld, next);
					primary.toVisit.add(next);
				}
			}
		}
		return null;
	}

	/* Merge paths where searches met at connection. */
	LinkedList<_0902_01_Person> mergePaths(_0902_00_BFSData bfs1, _0902_00_BFSData bfs2, int connection) {
		_0902_00_PathNode end1 = bfs1.visited.get(connection); // end1 -> source
		_0902_00_PathNode end2 = bfs2.visited.get(connection); // end2 -> dest
		LinkedList<_0902_01_Person> pathOne = end1.collapse(false);
		LinkedList<_0902_01_Person> pathTwo = end2.collapse(true); // reverse
		pathTwo.removeFirst(); // remove connection
		pathOne.addAll(pathTwo); // add second path
		return pathOne;
	}

}
