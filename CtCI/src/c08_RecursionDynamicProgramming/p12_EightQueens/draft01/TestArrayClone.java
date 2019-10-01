package c08_RecursionDynamicProgramming.p12_EightQueens.draft01;


import static java.lang.System.out;
//20190919(Thur
//https://stackoverflow.com/questions/14149733/clone-method-for-java-arrays
public class TestArrayClone {

	public static void main(String[] args) {
		String[] strs_a = {"apple", "banana", "carrot","dough"};
		//Creates and returns a copy of this object. 
		//The precise meaning of "copy" may depend on the class of the object.
		String[] strs_b = strs_a.clone();
		
		out.println("Are they the same object? " + (strs_a == strs_b? "Yes": "No") );
		
		strs_b[ strs_b.length-1 ] = "dog";
		
		out.println("strs_a: ");
		for(String str_a : strs_a) {
			out.print(str_a + " ");
		}
		out.println("");
		out.println("strs_b: ");
		for(String str_b : strs_b) {
			out.print(str_b + " ");
		}
		
		
	}

}
