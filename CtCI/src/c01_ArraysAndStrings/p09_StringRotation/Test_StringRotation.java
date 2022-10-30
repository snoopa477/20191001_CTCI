package c01_ArraysAndStrings.p09_StringRotation;
import static java.lang.System.out;
public class Test_StringRotation {

	public static void main(String[] args) {
		
		String[] inputs_1 = {
			"waterbottle",
			"erbottlewat",
			"waterkettle"
		};
		
		String input_2 = "waterbottle";
		
		
		for( String input_1 : inputs_1 ) {
			out.printf("\"%s\" is rotation of \"%s\"? %s\n",
				input_1,
				input_2,
				StringRotation_01_FlattenCircle.isRotation(input_1, input_2));
		}
		
	}

}


