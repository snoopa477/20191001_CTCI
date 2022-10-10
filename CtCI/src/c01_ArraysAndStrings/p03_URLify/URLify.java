package c01_ArraysAndStrings.p03_URLify;
import static java.lang.System.out;
public class URLify {

	/**
	 * 
	 * @param  str	to hold future %20, it has more capacity than its original str length
	 * @param  trueLength	the length without trailing spaces that are going to hold future %20
	 */
	public static char[] replaceSpaces(String s, int trueLength) {
		
		char[] str = s.toCharArray();
		
		/** PURPOSE
		 * To get the length of processed str, numberOfSpaces is required  
		 * 
		 * Steps
		 * 1. get length of processed str
		 * 2. to make processed str, move backward, starting with the end index of processed str
		 */
		
		int numberOfSpaces = countSpaces(str, trueLength);
		
		//REASONING: suppose original has x number of spaces, that means 3x number of spaces alternatives; Therefore, total length is original length + 3x-x
		int processedStrLength = trueLength + numberOfSpaces * 2;
		
		//DETAIL: original str and processed str share the same arr until all element in original str are processed( consumed)
		//DETAIL: The mapping relationship. In for loop if statement we deal with i_oringal; in for loop body we deal with i_process; two things are done separately
		//REASONING: once the element of orginal str is read(consumed); it can be discarded by being replaced
		
		//WRONG
		//for( int i_original = processedStrLength -1, i_processed = i_original; i_original >= 0; i_original-- ) {
		for( int i_original = trueLength -1, i_processed = processedStrLength -1; i_original >= 0; i_original-- ) {
			
			if( str[ i_original ] != ' ') {
				//cancel out?
				str[ i_processed ] = str[ i_original ];
				i_processed--;
			}
			else {
				//str[ i_original ] == ' ' is mapped to "%20"
				
				str[ i_processed ] = '0';
				str[ i_processed -1 ] = '2';
				str[ i_processed -2 ] = '%';
				
				i_processed -= 3;
			}
			
		}
		
		return str;
	}
	
	
	
	private static int countSpaces( char[] str, int trueLength ) {
		
		int countSpaces = 0;
		for( int i = 0; i < trueLength; i++ ) {
			if( str[i] == ' ' ) {
				countSpaces++;
			}
		}
		
		return countSpaces;
	}
}


