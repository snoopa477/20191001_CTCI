package c08_RecursionDynamicProgramming.p13_StackOfBoxes;

public class Box {
	
	public int  width;
	public int  height;
	public int  depth;
	public boolean canBeAbove(Box bottom) {
		return this.width < bottom.width 
				&& this.height < bottom.height;
	}
	
	
}
