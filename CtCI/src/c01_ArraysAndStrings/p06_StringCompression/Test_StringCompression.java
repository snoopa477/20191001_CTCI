package c01_ArraysAndStrings.p06_StringCompression;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
public class Test_StringCompression {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet<>( Arrays.asList(new String[] {"1", "2"} ) );
		
		String[] inputs = {
			"aabcccccaaa",
			"aaaaaaaaaa",
			"abc"
		};
		
		if( options.contains("1") ) {
			out.println("\n-------------------------------StringCompression_01_String");
			for( String input: inputs ) {
				out.printf("%s -> %s\n",
					input,
					StringCompression_01_String.getStringCompression(input));
			}
		}
		
		
		if( options.contains("2") ) {
			out.println("\n-------------------------------StringCompression_02_StringBuilder");
			for( String input: inputs ) {
				out.printf("%s -> %s\n",
					input,
					StringCompression_02_StringBuilder.getStringCompression(input));
			}
		}
		
		
		if( options.contains("2") ) {
			out.println("\n-------------------------------StringCompression_03_TestBeforeCompress");
			for( String input: inputs ) {
				out.printf("%s -> %s\n",
					input,
					StringCompression_03_TestBeforeCompress.getStringCompression(input));
			}
		}
		
		
	}

}


