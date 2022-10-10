package c01_ArraysAndStrings.p01_IsUnique;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
public class Test_isUnique {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet<String>( Arrays.asList("2") );
		
		String[] inputs = { "apple", "please", "XXYYXX", "XY", "apPle" };
		
		for( String input: inputs ) {
			
			
			if( options.contains("1") ) {
				out.printf("%s has duplicated char? %s\n"
					, input
					, isUnique_01_intuition.isUnique(input));
			}
			
			if( options.contains("2") ) {
				out.printf("%s has duplicated char? %s\n"
					, input
					, isUnique_02_ASCIISet.isUnique(input));
			}
			
		}
		
	}

}


