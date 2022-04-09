package c04_TreesAndGraphs.p07_BuildOrder;

import java.util.ArrayList;
import static java.lang.System.out;

public class Node_02_Dependency {
	
	private String name;
	private ArrayList<Node_02_Dependency> children;
	private int dependency;
	

	public Node_02_Dependency(String name) {
		this.name = name;
		this.children = new ArrayList<>();
		dependency = 0;
	}
	
	
	
	public String getName() {
		return name;
	}

	
	
	public ArrayList<Node_02_Dependency> getChildren() {
		return children;
	}
	
	
	/**
	 * @param otherNode would increase its dependecy 
	 */
	public void addChild( Node_02_Dependency otherNode ) {
		children.add( otherNode );
		/*PURPOSE: we could have have other node "point back" to this node
		 * ; however, in this problem, we don't need such powerful functionality; dependency would suffice.
		 */
		otherNode.dependencyIncreases();
	}
	
	
	
	public int getDependency() {
		return dependency;
	}



	public void dependencyIncreases() {
		this.dependency++;
	}
	
	
	
	public void dependencyDecreases() {
		this.dependency--;
	}
	
	
	
	public String toString() {
		
		boolean isFirst = true;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append( String.format("node: %s, dependency: %s, children:{ ", name, String.valueOf( dependency )) );
		for( Node_02_Dependency child: children ) {
			stringBuffer.append( String.format("%s%s", isFirst? "": ", ", child.getName()) );
			isFirst = false;
		}
		stringBuffer.append(" }");
		return stringBuffer.toString();
	}
}


