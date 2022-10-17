package c01_ArraysAndStrings.p05_OneAway;
import static java.lang.System.out;
public class OneAway_01 {

	
	public static String isOneWayString( String s1, String s2 ) {
		return String.format("%s, %s -> %s",
			s1,
			s2,
			isOneWay(s1, s2)? "true": "false");
	}
	
	
	
	private static boolean isOneWay( String s1, String s2 ) {
		
		int lengthDifference = Math.abs( s1.length() - s2.length() );
		/**
		 * one ways is either one edit insert or one edit replace 
		 */
		if( lengthDifference == 0 ) {
			return isOneEditReplace( s1, s2 );
		}
		else if( lengthDifference == 1 ) {
			return isOneEditInsert( s1, s2 );
		}
		//None of the above, must be non one way string
		else {
			return false;
		}
	}
	
	
	
	/**
	 * PREREQUISITE:  Math.abs( lenS1 - lenS2 ) == 0, which is a necessary condition
	 * to be OneEditReplace situation
	 */
	private static boolean isOneEditReplace( String s1, String s2 ) {
		
		int index1 = 0;
		int index2 = 0;
		
		/**
		 * for any pairs of elements pointed by indices, at least one pair different, it is not one edit replace condition; else, it is edit replace condition 
		 */
		while( index1 < s1.length() && index2 < s2.length() ) {
			
			if( s1.charAt(index1) != s1.charAt(index2) ) {
				return false;
			}
			index1++;
			index2++;
		}
		
		return true;
	}
	
	
	
	/**
	 * PREREQUISITE:  Math.abs( lenS1 - lenS2 ) == 1, which is a necessary condition
	 * to be oneEditInsert situation
	 */
	private static boolean isOneEditInsert( String s1, String s2 ) {
		
		String strShort = s1.length() > s2.length() ? s2 : s1;
		String strLong = s1.length() > s2.length() ? s1 : s2;
		
		
		int indexShort = 0;
		int indexLong = 0;
		
		int differenceCount = 0;
		
		//DETAIL: using 'while' instead of 'for' gives the feeling of both indices proceed together 
		//for( indexLong = 0; indexLong < strLong.length(); indexLong++ ) {
		//REASONING: if both strings hold the condition that is one edit insert, then when both indices proceed together, indexShort would pause exactly once, meaning this is the place that should be inserted so that strShort becomes strLong
		while( indexShort < strShort.length() && indexLong < strLong.length() ) {
			
			/**
			 * PURPOSE: both matches, proceed 
			 */
			if( strShort.charAt(indexShort) == strLong.charAt(indexLong) ) {
				indexShort++;
				indexLong++;
			}
			else {
				
				differenceCount++;
				if( differenceCount > 1 ) {
					return false;
				}
				
				//indexShort pauses, waiting for the next indexLong until their values are the same
				//DETAIL: the indexLong proceed, when indexShort pauses, is the exact index that would be inserted into strShort 
				indexLong++;
			}
		}
		
		return true;
	}
	
}




