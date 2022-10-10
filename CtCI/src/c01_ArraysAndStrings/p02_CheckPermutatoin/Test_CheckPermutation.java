package c01_ArraysAndStrings.p02_CheckPermutatoin;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

import c10_SortingAndSearching.p05_SparseSearch._1005_00_SparseSearch;
import c10_SortingAndSearching.p05_SparseSearch._1005_01_MySparseSearch;
import c10_SortingAndSearching.p05_SparseSearch._1005_MySparseSearch_freq02;
import c10_SortingAndSearching.p05_SparseSearch._Practice_SparseSearch;
public class Test_CheckPermutation {

	public static void main(String[] args) {
		
		
		HashSet<String> options = new HashSet<>( Arrays.asList(new String[] {"1", "2"} ) );
		
		String s1 = "yellow";
		String s2 = "lowlye";
		String s3 = "lowyee";
		String s4 = "lowlyel";
		
		if( options.contains("1") ) {
			String strA = s1;
			String strB = s2;
			out.println( String.format("Is [%s] and [%s] have same permutation? %b", strA, strB
				, CheckPermutation_01_Sort.checkPermutation(strA, strB) ) );
			
			strB = s3;
			out.println( String.format("Is [%s] and [%s] have same permutation? %b", strA, strB
					, CheckPermutation_01_Sort.checkPermutation(strA, strB) ) );
			
			strB = s4;
			out.println( String.format("Is [%s] and [%s] have same permutation? %b", strA, strB
					, CheckPermutation_01_Sort.checkPermutation(strA, strB) ) );
			
		}
		
		
		if( options.contains("2") ) {
			String strA = s1;
			String strB = s2;
			out.println( String.format("Is [%s] and [%s] have same permutation? %b", strA, strB
				, CheckPermutation_02_Map.checkPermutation(strA, strB) ) );
			
			strB = s3;
			out.println( String.format("Is [%s] and [%s] have same permutation? %b", strA, strB
					, CheckPermutation_02_Map.checkPermutation(strA, strB) ) );
			
			strB = s4;
			out.println( String.format("Is [%s] and [%s] have same permutation? %b", strA, strB
					, CheckPermutation_02_Map.checkPermutation(strA, strB) ) );
		}
		
		
	}

}


