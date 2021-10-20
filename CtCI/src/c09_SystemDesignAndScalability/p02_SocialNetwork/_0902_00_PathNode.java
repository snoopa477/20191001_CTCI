package c09_SystemDesignAndScalability.p02_SocialNetwork;

import static java.lang.System.out;

import java.util.LinkedList;

public class _0902_00_PathNode {
	private _0902_01_Person person = null;
	private _0902_00_PathNode previousNode = null;

	public _0902_00_PathNode(_0902_01_Person p, _0902_00_PathNode previous) {
		person = p;
		previousNode = previous;
	}

	public _0902_01_Person getPerson() {
		return person;
	}

	public LinkedList<_0902_01_Person> collapse(boolean startsWithRoot) {
		LinkedList<_0902_01_Person> path = new LinkedList<_0902_01_Person>();
		_0902_00_PathNode node = this;
		while (node != null) {
			if (startsWithRoot) {
				path.addLast(node.person);
			} else {
				path.addFirst(node.person);
			}
			node = node.previousNode;
		}
		return path;

	}
}
