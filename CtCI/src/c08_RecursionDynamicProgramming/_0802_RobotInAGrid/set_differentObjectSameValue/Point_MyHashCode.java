package c08_RecursionDynamicProgramming._0802_RobotInAGrid.set_differentObjectSameValue;

public class Point_MyHashCode {
	
	private static final int PRIME_NUMBER_0 = 7759;
	private static final int PRIME_NUMBER_1 = 7789;
	
	public int row;
	public int col;
	
	public Point_MyHashCode(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		String str = "{row: " + row + ", col: " + col +"}";
		return str;
	}
	
	@Override
	public int hashCode() {
		
		return row * PRIME_NUMBER_0 + col * PRIME_NUMBER_1;
	}

}


