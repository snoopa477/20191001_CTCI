package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;

import java.util.ArrayList;
public class Test_QuasiSet {
	/* OUTPUT: 
	 	00000000 00000000 00000000 
		set 11
		00000000 00001000 00000000 
		set 9
		00000000 00001010 00000000 
		remove 11
		00000000 00000010 00000000 
		set 18( which is out of boundary) 
		00000000 00000010 00000000 
		set 16
		00000001 00000010 00000000 
		contains 0
		false
		set 0
		00000001 00000010 00000001 
		contains 0
		true
		all numbers
		[0, 9, 16]
	 * 
	 */
	public static void main(String[] args) {
		
		QuasiSet qs = new QuasiSet(16);
		qs.printIndexToExistence();
		
		out.println("set 11");
		qs.put(11);
		qs.printIndexToExistence();
		
		out.println("set 9");
		qs.put( 9 );
		qs.printIndexToExistence();
		
		out.println("remove 11");
		qs.remove( 11 );
		qs.printIndexToExistence();
		
		out.println("set 18( which is out of boundary) ");
		qs.put( 18 );
		qs.printIndexToExistence();
		
		out.println("set 16");
		qs.put(16);
		qs.printIndexToExistence();
		
		out.println("contains 0");
		out.println(qs.contains(0));
		
		out.println("set 0");
		qs.put(0);
		qs.printIndexToExistence();
		
		out.println("contains 0");
		out.println(qs.contains(0));
		
		
		ArrayList<Integer> allNumbers = qs.getAllPutNumbers();
		out.println("all numbers");
		out.println(allNumbers);
		
		
	}

}


