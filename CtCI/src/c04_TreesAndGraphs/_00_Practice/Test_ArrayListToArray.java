package c04_TreesAndGraphs._00_Practice;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class Test_ArrayListToArray {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(  Arrays.asList( new String[]{"A", "B", "C"} ) )  ;
		
		//ERROR: Type mismatch: cannot convert from Object[] to String[]
		//String[] arrs = list.toArray();
		
		//EXCEPTOIN: ClassCastException
		//String[] arrs = (String[])list.toArray();
		
		//TRICK: the argument String[] tell what type of result should be produced
		String[] arrs = list.toArray( new String[0] );
		
		for(String elt: arrs) {
			out.printf("%s ", elt);
		}
		
		
	}

}


