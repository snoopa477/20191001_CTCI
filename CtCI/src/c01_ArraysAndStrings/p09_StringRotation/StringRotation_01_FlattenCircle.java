package c01_ArraysAndStrings.p09_StringRotation;
import static java.lang.System.out;
public class StringRotation_01_FlattenCircle {
	
	public static boolean isRotation(String s1, String s2) {
		
		if( s1 == null || s2 == null ) {
			return false;
		}
		
		//Under the premise that
		if( s1.length() == s2.length() ) {
			
			//REASONING: (s1 + s1) contains s2 iff s1 is rotation of s2 
			String doubleS1 = s1 + s1;
			return doubleS1.contains( s2 );
		}
		else {
			return false;
		}
	}

}


