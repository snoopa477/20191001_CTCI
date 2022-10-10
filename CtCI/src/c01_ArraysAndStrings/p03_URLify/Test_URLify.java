package c01_ArraysAndStrings.p03_URLify;
import static java.lang.System.out;
public class Test_URLify {

	public static void main(String[] args) {
		
		String str = "Mr John Smith           ";
		
		out.println( URLify.replaceSpaces(str, 13) );
		
	}

}


