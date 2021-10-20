package c04_TreesAndGraphs.p07_BuildOrder;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;

import c04_TreesAndGraphs.p07_BuildOrder._0407_00_BuildOrder.Project;
import util.MyStack;

public class _0407_01_BuildOrder {
	MyStack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}

	MyStack<Project> orderProjects(ArrayList<Project> projects) {
		MyStack<Project> stack = new MyStack<Project>();
		for (Project project : projects) {
			if (project.getState() == Project.State.BLANK) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

	boolean doDFS(Project project, MyStack<Project> stack) {
		if (project.getState() == Project.State.PARTIAL) {
			return false; // Cycle
		}
		if (project.getState() == Project.State.BLANK) {
			project.setState(Project.State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			project.setState(Project.State.COMPLETE);
			stack.push(project);
		}
		return true;
	}

	/* Same as before */
	// Graph buildGraph(String[] projects, String[][] dependencies) { ... }
	// public class Graph {}
	Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.createNode(project);
		}
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		return graph;
	}

	/*
	 * Essentially equivalent to earlier solution, with state info added and
	 * dependency count removed.
	 */
	public static class Project {
		public enum State {
			COMPLETE, PARTIAL, BLANK
		};

		private ArrayList<Project> children = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private String name;
		private int dependencies = 0;

		private State state = State.BLANK;

		public State getState() {
			return state;
		}

		public void setState(State st) {
			state = st;
		}

		/* Duplicate code removed for brevity */
		public Project(String n) {
			name = n;
		}

		public void addNeighbor(Project node) {
			if (!map.containsKey(node.getName())) {
				children.add(node);
				map.put(node.getName(), node);
				node.incrementDependencies();
			}
		}

		public void incrementDependencies() {
			dependencies++;
		}

		public void decrementDependencies() {
			dependencies--;
		}

		public String getName() {
			return name;
		}

		public ArrayList<Project> getChildren() {
			return children;
		}

		public int getNumberDependencies() {
			return dependencies;
		}

	}

	public class Graph {
		private ArrayList<Project> nodes = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();

		public Project getOrCreateNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			return map.get(name);
		}

		public void addEdge(String startName, String endName) {
			Project start = getOrCreateNode(startName);
			Project end = getOrCreateNode(endName);
			start.addNeighbor(end);
		}

		public ArrayList<Project> getNodes() {
			return nodes;
		}
	}

}
