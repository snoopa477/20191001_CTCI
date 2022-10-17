package c01_ArraysAndStrings.p05_OneAway;
import static java.lang.System.out;

public class OneAway_02_codeMerge {
	public static String isOneWayString( String s1, String s2 ) {
		return String.format("%s, %s -> %s",
			s1,
			s2,
			isOneWay(s1, s2)? "true": "false");
	}
	
	
	
	private static boolean isOneWay( String s1, String s2 ) {
		
		/**
		 * one ways is either one edit insert or one edit replace 
		 */
		if( Math.abs( s1.length() - s2.length() ) <= 1 ) {
			return isOneEdit( s1, s2 );
		}
		//None of the above, must be non one way string
		else {
			return false;
		}
	}
	
	
	
	//check if one edit insert or one edit replace 
	private static boolean isOneEdit( String s1, String s2 ) {
		
		int lengthDifference = Math.abs( s1.length() - s2.length() );
		
		String strA = s1.length() > s2.length() ? s2 : s1;
		String strB = s1.length() > s2.length() ? s1 : s2;
		
		int indexA = 0;
		int indexB = 0;
		
		int differenceCount = 0;
		
		//DETAIL: two conditions share this snippet of codes
		/**
		 * REASONING :
		 * if is one edit replace, for all pairs of elements pointed by indices, there's only one pair which elements are different
		 * if is one edit edit, for all pairs of elements pointed by indices, there's only one pair which elements are different
		 */
		while( indexA < strA.length() && indexB < strB.length() ) {
			
			if( strA.charAt(indexA) == strB.charAt(indexB) ) {
				indexA++;
				indexB++;
			}
			else {
				differenceCount++;
				//one edit replace
				//WRONG: if( lengthDifference == 0 && differenceCount > 0 ) {
				if( lengthDifference == 0 && differenceCount > 1  ) {
					return false;
				}
				//one edit edit
				if( lengthDifference == 1 && differenceCount > 1 ) {
					return false;
				}
				
				//WRONG: forgot to add this one
				if( lengthDifference == 0   ) {
					indexA++;
				}
				indexB++;
			}
		}
		return true;
	}
}


