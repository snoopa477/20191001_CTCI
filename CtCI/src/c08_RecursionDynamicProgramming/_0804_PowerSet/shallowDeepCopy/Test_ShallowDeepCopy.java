package c08_RecursionDynamicProgramming._0804_PowerSet.shallowDeepCopy;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class Test_ShallowDeepCopy {

	public static void main(String[] args) {
		
		{
			out.println("case 1: Arr<StringBuilder>: shallow copy");
			ArrayList<StringBuilder> arr = new ArrayList<>();
			arr.add(new StringBuilder("a"));
			
			ArrayList<StringBuilder> arr2 = new ArrayList<>(arr);
			arr2.get(0).append("asdf");
			
			//aasdf
			out.println("arr " + arr.get(0).toString());
			//aasdf
			out.println("arr2 " + arr2.get(0).toString());
		}
		
		{
			out.println("\ncase 2: Arr<StringBuilder>: deep copy");
			ArrayList<StringBuilder> arr = new ArrayList<>();
			arr.add(new StringBuilder("a"));
			arr.add(new StringBuilder("b"));
			
			ArrayList<StringBuilder> arr2 = new ArrayList<>();
			for( StringBuilder sb: arr ) {
				arr2.add( new StringBuilder( sb.toString() ) );
			}
			
			for(StringBuilder sb: arr2) {
				sb.append(" hello");
			}
			
			//a
			out.println("arr " + arr.get(0).toString());
			//a hello
			out.println("arr2 " + arr2.get(0).toString());
			
			//b
			out.println("arr " + arr.get(1).toString());
			//b hello
			out.println("arr2 " + arr2.get(1).toString());
		}
		
		{
			ArrayList<ArrayList<String>> sets = new ArrayList<>();
			ArrayList<String> set1 = new ArrayList<>( Arrays.asList("a", "b", "c"));
			ArrayList<String> set2 = new ArrayList<>( Arrays.asList("d", "e", "f"));
			sets.add( set1 );
			sets.add( set2 );
			
			ArrayList<ArrayList<String>> sets2 = new ArrayList<>();
			for( ArrayList<String> set: sets) {
				sets2.add( new ArrayList<>( set ) );
			}
			
			for( ArrayList<String> set : sets2 ) {
				set.add("zz");
			}
			
			out.println("\nsets");
			printSets_String(sets);
			out.println("\nsets2");
			printSets_String(sets2);
			
			
		}
		
	}
	
	public static void printSets_String( ArrayList<ArrayList<String>> sets) {
		
		for(ArrayList<String> set : sets) {
			
			//MISTAKE:
			//forget size = 0
			if(set.size() == 0) {
				out.println("{ }");
			}
			else {
				boolean isFirstElt = true;
				for(String elt : set) {
					out.print( (isFirstElt? "{ ": ",") + elt);
					isFirstElt = false;
				}
				out.println(" } ");
			}
		}
	}
	
}


