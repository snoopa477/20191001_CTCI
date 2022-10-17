package c01_ArraysAndStrings.p05_OneAway;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class Test_OneAway {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet<>( Arrays.asList(new String[] {"1", "2"} ) );
		
		String inputPairs[][] = {
			{ "pale", "ple" },
			{ "pales", "pale" },
			{ "pale", "bale" },
			{ "pale", "bae" }
		};
		
		
		if( options.contains("1") ) {
			out.println("\n-----------------OneAway_01");
			for( String[] inputPair : inputPairs ) {
				out.println( OneAway_01.isOneWayString(inputPair[0], inputPair[1]) );
			}
		}
		
		
		if( options.contains("2") ) {
			out.println("\n-----------------OneAway_02_codeMerge");
			for( String[] inputPair : inputPairs ) {
				out.println( OneAway_02_codeMerge.isOneWayString(inputPair[0], inputPair[1]) );
			}
		}
		
	}
	
	
	
}


