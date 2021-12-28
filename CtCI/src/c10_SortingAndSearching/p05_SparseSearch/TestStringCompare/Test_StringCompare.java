package c10_SortingAndSearching.p05_SparseSearch.TestStringCompare;
import static java.lang.System.out;
public class Test_StringCompare {

	public static void main(String[] args) {
		
		String abcd = "abcd";
		String abcde = "abcde";
		String abduction = "abduction";
		
		/*
		 If there is no index position at which they differ, then the shorterstring lexicographically precedes the longer string. In this case, compareTo returns the difference of the lengths of thestrings -- that is, the value: 
 this.length()-anotherString.length()

		 * */
		//-1
		out.printf( "%s vs %s is %d%n", abcd, abcde, abcd.compareTo(abcde) );
		//1
		out.printf( "%s vs %s is %d%n", abcde, abcd, abcde.compareTo(abcd) );
		
		//-1
		out.printf( "%s vs %s is %d%n", abcd, abduction, abcd.compareTo(abduction) );
		
		
		//asii(z) = 96 + 26 = 122
		String az = "az";
		
		//ascii(Z) = 64 + 26 = 90;
		String aZ = "aZ";
		String aZe = "aZe";
		
		//32
		out.printf( "%s vs %s is %d%n", az, aZ, az.compareTo(aZ) );
		
		//32
		out.printf( "%s vs %s is %d%n", az, aZe, az.compareTo(aZe) );
		
		
	}
	
	
}


