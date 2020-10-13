package c08_RecursionDynamicProgramming._0802_RobotInAGrid.set_differentObjectSameValue;
import static java.lang.System.out;

import java.util.HashSet;

import c08_RecursionDynamicProgramming._0802_RobotInAGrid.Point;
public class Test_set {
	
	public static void main(String[] args) {
		
		{
			out.println("\ncase1: Point");
			Point p1 = new Point(1,2);
			Point p2 = new Point(1,2);
			
			HashSet<Point> set = new HashSet<>();
			set.add(p1);
			
			//false
			out.println("set.contains(p2)? ");
			if( set.contains(p2) ) {
				out.println("true");
			}
			else {
				out.println("false");
			}
		}
		
		{
			out.println("\ncase2: Point_MyHashCode");
			Point_MyHashCode p1 = new Point_MyHashCode(1,2);
			Point_MyHashCode p2 = new Point_MyHashCode(1,2);
			
			HashSet<Point_MyHashCode> set = new HashSet<>();
			set.add(p1);
			
			//false
			out.println("set.contains(p2)? ");
			if( set.contains(p2) ) {
				out.println("true");
			}
			else {
				out.println("false");
			}
			
			out.println("p1.equals(p2)");
			if(p1.equals(p2)) {
				out.println("true");
			}
			else {
				out.println("false");
			}
			
		}
		
		{
			out.println("\ncase3: Point_MyEqual");
			Point_MyEqual p1 = new Point_MyEqual(1,2);
			Point_MyEqual p2 = new Point_MyEqual(1,2);
			
			HashSet<Point_MyEqual> set = new HashSet<>();
			set.add(p1);
			
			//false
			out.println("set.contains(p2)? ");
			if( set.contains(p2) ) {
				out.println("true");
			}
			else {
				out.println("false");
			}
			
			
			out.println("p1.equals(p2)");
			if(p1.equals(p2)) {
				out.println("true");
			}
			else {
				out.println("false");
			}
			
		}
		
		{
			out.println("\ncase4: Point_MyEqual_MyHashCode");
			Point_MyEqual_MyHashCode p1 = new Point_MyEqual_MyHashCode(1,2);
			Point_MyEqual_MyHashCode p2 = new Point_MyEqual_MyHashCode(1,2);
			
			HashSet<Point_MyEqual_MyHashCode> set = new HashSet<>();
			set.add(p1);
			
			//false
			out.println("set.contains(p2)? ");
			if( set.contains(p2) ) {
				out.println("true");
			}
			else {
				out.println("false");
			}
			
			
			out.println("p1.equals(p2)");
			if(p1.equals(p2)) {
				out.println("true");
			}
			else {
				out.println("false");
			}
			
		}
		
	}

}


