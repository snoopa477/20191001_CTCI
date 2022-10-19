package c01_ArraysAndStrings.p06_StringCompression;
import static java.lang.System.out;
public class StringCompression_03_TestBeforeCompress {
	
	private static final boolean IS_DEBUG = false;
	
	//REASONING: it has tradeoff that potentially it will execute all methods, meaning 2 loops is executed
	public static String getStringCompression( String str ) {
		
		if( str.length() < getStringCompressionLength( str ) ) {
			return str;
		}
		
		return getStringCompressionHelper(str);
	}
	
	
	
	private static String getStringCompressionHelper(String str) {
		
		StringBuilder resultStr = new StringBuilder();
		int sameCharCount = 0;
		
		for( int i = 0, peekIndex = i + 1; i < str.length(); i++, peekIndex++ ) {
			sameCharCount++;
			
			if( i == str.length() -1 
				|| str.charAt( peekIndex ) != str.charAt(i) ) {
			
				resultStr.append( str.charAt(i) + String.valueOf( sameCharCount ) );
				
				sameCharCount = 0;
			}
		}
		return str.length() < resultStr.length()? str : resultStr.toString();
	}
	
	
	
	//PURPOSE: calculating length is efficient than generating actual string due to avoidance of StringBuilder
	//DETAIL it almost has same logic, except that it counts length instead of generating actual compressedString
	private static int getStringCompressionLength( String str ) {
	
		int sameCharCount = 0;
		int compressedStringLength = 0 ;
		
		for( int i = 0, peekIndex = i + 1; i < str.length(); i++, peekIndex++ ) {
			sameCharCount++;
			
			if( i == str.length() -1 
				|| str.charAt( peekIndex ) != str.charAt(i) ) {
				
				//REASONING: example the length of 'a11' is 1 + digitLength(11) = 3
				compressedStringLength += 1 + String.valueOf(sameCharCount).length();
				sameCharCount = 0;
			}
		
		}
		
		if( IS_DEBUG ) {
			out.printf("getStringCompressionLength is %d\n", compressedStringLength);
		}
		
		return compressedStringLength;
	}
	
}



