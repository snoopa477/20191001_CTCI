package c01_ArraysAndStrings.p06_StringCompression;
import static java.lang.System.out;
public class StringCompression_01_String {

	public static String getStringCompression(String str) {
		
		String resultStr = "";
		
		int sameCharCount = 0;
		
		for( int i = 0, peekIndex = i + 1; i < str.length(); i++, peekIndex++ ) {
			//sameCharCount increases along with i increases
			sameCharCount++;
			
			/**
			 * PURPOSE:
			 * if char pointed by current index is different from char pointed by peekIndex,
			 *  stop the counting, put the counting to result string, and reset the counting for next iteration
			 */
			//DETAIL: putting the counting to result string are resetting counting are equivalent
			if( i == str.length() -1 
				|| str.charAt( peekIndex ) != str.charAt(i) ) {
				//WRONG
				//aabcccccaaa -> 97989997
				//resultStr += str.charAt(i) + sameCharCount;
				resultStr += str.charAt(i) + String.valueOf( sameCharCount );
				
				//ready for the next loop
				sameCharCount = 0;
			}
		}
		
		return str.length() < resultStr.length()? str : resultStr;
	}
	
}


