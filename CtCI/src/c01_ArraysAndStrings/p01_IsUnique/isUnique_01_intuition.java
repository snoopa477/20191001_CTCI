package c01_ArraysAndStrings.p01_IsUnique;
import static java.lang.System.out;
public class isUnique_01_intuition {

	static final public int NUMBER_VISIBLE_CHARS = 128;
	
	//DETAIL: this class is used to compare with isUnique_02_ASCIISet
	public static boolean isUnique(String str) {
		
		if( str == null || str.length() == 0 || str.length() > NUMBER_VISIBLE_CHARS) {
			return true;
		}
		
		//PURPOSE: simulate a set by using array if the keys are integer and continuous
		boolean[] set = new boolean[ NUMBER_VISIBLE_CHARS ];
		
		for( int i = 0; i < str.length(); i++ ) {
			//REASONING: direct mapping: value of char( which is ascii code) = index of a set
			int currCharIndex = str.charAt(i);
			//IMAGINATION: set.contains
			if( set[ currCharIndex ] == true ) {
				return true;
			}
			
			set[ currCharIndex ] = true;
			
		}
		
		return false;
	}
	
}


