package c09_SystemDesignAndScalability.p02_SocialNetwork;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _0902_00_BFSData {
	public Queue<_0902_00_PathNode> toVisit = new LinkedList<_0902_00_PathNode>();
	public HashMap<Integer, _0902_00_PathNode> visited = new HashMap<Integer, _0902_00_PathNode>();

	public _0902_00_BFSData(_0902_01_Person root) {
		_0902_00_PathNode sourcePath = new _0902_00_PathNode(root, null);
		toVisit.add(sourcePath);
		visited.put(root.getID(), sourcePath);
	}

	public boolean isFinished() {
		return toVisit.isEmpty();
	}
}
