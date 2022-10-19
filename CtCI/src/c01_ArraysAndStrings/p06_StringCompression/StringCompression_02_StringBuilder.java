package c01_ArraysAndStrings.p06_StringCompression;
import static java.lang.System.out;
public class StringCompression_02_StringBuilder {

	public static String getStringCompression(String str) {
		
		//String resultStr = "";
		//REASONING: stringBuilder append operation is better than string concatenation
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
}


