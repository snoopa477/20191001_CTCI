package c10_SortingAndSearching.p04_SortedSearchNoSize;


import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class TestListy {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet<>( Arrays.asList(new String[] {"3"} ) );
		
//		{
//			//		   0, 1,  2,  3,  4,  5,   6,   7,   8,   9
//			int[] a = {2, 15, 17, 23, 55, 146, 198, 198, 202, 207};
//			Listy list = new Listy(a);
//			out.println(_1004_00_SortedSearchNoSize.search(list, 202));
//			out.println(_1004_00_SortedSearchNoSize.search(list, 55));
//			out.println(_1004_00_SortedSearchNoSize.search(list, 100));
//		}
		
		
		if( options.contains("1") )
		{
			out.println("- - - - - - -");
			//		   0, 1,  2,  3,  4,  5,   6,   7,   8,   9
			int[] a = {2, 15, 17, 23, 55, 146, 198, 198, 202, 207};
			Listy list = new Listy(a);
			out.println(_1004_01_MySortedSearchNoSize.search(list, 202));
			out.println(_1004_01_MySortedSearchNoSize.search(list, 55));
			out.println(_1004_01_MySortedSearchNoSize.search(list, 100));
			
		}
		
		
		if( options.contains("2") )
		{
			out.println("- - - - - - -MySortedSearchNoSize_freq02");
			//		   0, 1,  2,  3,  4,  5,   6,   7,   8,   9
			int[] a = {2, 15, 17, 23, 55, 146, 198, 198, 202, 207};
			Listy list = new Listy(a);
			out.println(MySortedSearchNoSize_freq02.binarySearch(list, 202));
			out.println(MySortedSearchNoSize_freq02.binarySearch(list, 55));
			out.println(MySortedSearchNoSize_freq02.binarySearch(list, 100));
			
		}
		
		if( options.contains("3") ) {
			int[] a = {2, 15, 17, 23, 55, 146, 198, 198, 202, 207};
			Listy list = new Listy(a);
			out.println(_Practice_SortedSearchNoSize.search(list, 202));
			out.println(_Practice_SortedSearchNoSize.search(list, 55));
			out.println(_Practice_SortedSearchNoSize.search(list, 100));
		}
		
		
		out.println("end");
		
		
	}
	
	
	
}
