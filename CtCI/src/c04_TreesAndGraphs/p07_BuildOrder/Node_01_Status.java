package c04_TreesAndGraphs.p07_BuildOrder;
import static java.lang.System.out;

import java.util.ArrayList;
public class Node_01_Status {

	private String name;
	//private Node_01_Status[] children;
	private ArrayList<Node_01_Status> children;
	private Status status;
	
	
	
	public Node_01_Status(String name) {
		this.name = name;
		this.children = new ArrayList<>();
		status = Status.UNVISITED;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<Node_01_Status> getChildren() {
		return children;
	}



	public void addChild( Node_01_Status child) {
		this.children.add( child );
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append( String.format("node: %s, children:{", name) );
		boolean isFirst = true;
		for( Node_01_Status child : children ) {
			stringBuilder.append( String.format("%s%s ", isFirst? " ": ", ", child.getName()) );
			isFirst = false;
		}
		stringBuilder.append( "}" );
		
		return stringBuilder.toString();
	}



	enum Status{
		UNVISITED, PROCESSING, DONE;
	}
	
}


