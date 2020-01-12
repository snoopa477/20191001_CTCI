package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

public class Box {
	
	public int  width;
	public int  depth;
	public int  height;
	
	
	
	public Box(int width, int depth, int height) {
		super();
		this.width = width;
		this.depth = depth;
		this.height = height;
	}



	public boolean canBeAbove(Box bottom) {
		return this.width < bottom.width 
				&& this.height < bottom.height
				&& this.depth < bottom.depth;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("[width: " + String.format("%3d", width) + "]");
		sb.append("[depth: " + String.format("%3d", depth) + "]");
		sb.append("[height: " + String.format("%3d", height) + "]");
		sb.append("}");
		return sb.toString();
	}
	
}
