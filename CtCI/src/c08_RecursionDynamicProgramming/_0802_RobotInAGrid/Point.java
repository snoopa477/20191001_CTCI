package c08_RecursionDynamicProgramming._0802_RobotInAGrid;

import java.util.Objects;

import c08_RecursionDynamicProgramming._0802_RobotInAGrid.set_differentObjectSameValue.Point_MyEqual_MyHashCode;

public class Point {
	
	public int row;
	public int col;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		String str = "{" + row + ", " + col +"}";
		return str;
	}
	
	//MISTAKE
	//without overriding hashCode(), equals(), 
	//HashSet would treat different object same values as different things; so is HashMap
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
        final Point other = (Point) obj;
        
        
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.col, other.col)) {
            return false;
        }
        return true;
    }

}


