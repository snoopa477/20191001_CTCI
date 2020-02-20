package c10_SortingAndSearching.p05_SparseSearch;


import static java.lang.System.out;

public class testSparseSearch {

	public static void main(String[] args) {
		String[] input = {"at", "", "", "", "ball", "", "",
				"car","","","dad","",""};
		
		out.println(_1005_00_SparseSearch.search(input, "ball"));
		out.println(_1005_00_SparseSearch.search(input, "dad"));
		
		out.println(_1005_01_MySparseSearch.search(input, "ball"));
		out.println(_1005_01_MySparseSearch.search(input, "dad"));
		
	}

}
