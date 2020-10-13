package c08_RecursionDynamicProgramming._0802_RobotInAGrid.set_differentObjectSameValue;

import java.util.Objects;
public class Point_MyEqual {
	public int row;
	public int col;
	
	public Point_MyEqual(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		String str = "{row: " + row + ", col: " + col +"}";
		return str;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point_MyEqual other = (Point_MyEqual) obj;
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.col, other.col)) {
            return false;
        }
        return true;
    }
}


