package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class Test_Byte {

	public static void main(String[] args) {
		byte num1=127;
		byte num2=-128;
		//ERROR MESSAGE- Type mismatch: cannot convert from int to byte
		byte num3=(byte) 128;
		byte num4=(byte) 129;
		out.println("num1 : "+num1);
		out.println("num2 : "+num2);
		out.println("num3 : "+num3);
		out.println("num4 : "+num4);
	}

}


