package c08_RecursionDynamicProgramming._0802_RobotInAGrid.list_hasSameObject;
import static java.lang.System.out;

import java.util.ArrayList;

import c08_RecursionDynamicProgramming._0802_RobotInAGrid.Point;
public class Test_list_hasSameObject {

	public static void main(String[] args) {
		Point point = new Point(5, 6);
		ArrayList<Point> listA = new ArrayList<>();
		listA.add(point);
		
		ArrayList<Point> listB = new ArrayList<>();
		listB.add(point);
		point.col = 10;
		
		out.println(listA.get(0).col);
		
	}

}


