package c08_RecursionDynamicProgramming._0802_RobotInAGrid.set_differentObjectSameValue;

import java.util.Objects;
public class Point_MyEqual_MyHashCode {

	
	public int row;
	public int col;
	
	public Point_MyEqual_MyHashCode(int row, int col) {
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
		
		int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.row);
        hash = 47 * hash + Objects.hashCode(this.col);
        return hash;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        //have to do the cast, otherwise you cannot compare field by field
        final Point_MyEqual_MyHashCode other = (Point_MyEqual_MyHashCode) obj;
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.col, other.col)) {
            return false;
        }
        return true;
    }
}


