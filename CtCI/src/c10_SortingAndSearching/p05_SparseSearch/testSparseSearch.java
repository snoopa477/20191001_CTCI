package c10_SortingAndSearching.p05_SparseSearch;


import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class testSparseSearch {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet<>( Arrays.asList(new String[] {"3", "4"} ) );
		
		String[] input = {"at", "", "", "", "ball", "", "",
				"car","","","dad","",""};
		
		if( options.contains("1") ) {
			out.println(_1005_00_SparseSearch.search(input, "ball"));
			out.println(_1005_00_SparseSearch.search(input, "dad"));
		}
		
		
		if( options.contains("2") ) {
			out.println(_1005_01_MySparseSearch.search(input, "ball"));
			out.println(_1005_01_MySparseSearch.search(input, "dad"));
			
		}
		
		
		if( options.contains("3") ) {
			out.println("_1005_MySparseSearch_freq02");
			out.println(_1005_MySparseSearch_freq02.search(input, "ball"));
			out.println(_1005_MySparseSearch_freq02.search(input, "dad"));
			out.println(_1005_01_MySparseSearch.search(input, "papa"));
		}
		
		if(options.contains("4")) {
			out.println("_Practice_SparseSearch");
			out.println(_Practice_SparseSearch.search(input, "ball"));
			out.println(_Practice_SparseSearch.search(input, "dad"));
			out.println(_1005_01_MySparseSearch.search(input, "papa"));
		}
		
	}

}
