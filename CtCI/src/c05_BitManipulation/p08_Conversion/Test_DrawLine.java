package c05_BitManipulation.p08_Conversion;
import static java.lang.System.out;

import java.util.Arrays;

import util.BitPrinter;

public class Test_DrawLine {

	public static void main(String[] args) {
		
		
		DrawLine.IS_DEBUG = false;
		
		out.println("--------------------------case1");
		{
			byte[] screen = new byte[15];
			int width = 40;
			int x1 = 5;
			int x2 = 28;
			int y = 1;
			out.println("x1: " + x1
					+ "\nx2: " + x2
					+ "\ny: " + y
					+ "\nwidth: " + width);
			
			//Byte[] wrappedScreen = Arrays.stream(screen).boxed().toArray(Integer[]::new);
			DrawLine.drawLine(screen, x1, x2, y, width);
			Byte[] wrappedScreen = toObject(screen);
			out.println( BitPrinter.toBitStringWithHeader(wrappedScreen, width) );
		}
		
		
		out.println("--------------------------case2");
		{
			byte[] screen = new byte[15];
			int width = 40;
			int x1 = 22;
			int x2 = 28;
			int y = 1;
			out.println("x1: " + x1
					+ "\nx2: " + x2
					+ "\ny: " + y
					+ "\nwidth: " + width);
			
			DrawLine.drawLine(screen, x1, x2, y, width);
			Byte[] wrappedScreen = toObject(screen);
			out.println( BitPrinter.toBitStringWithHeader(wrappedScreen, width) );
		}
		
		
		out.println("--------------------------case3");
		{
			byte[] screen = new byte[15];
			int width = 40;
			int x1 = 8;
			int x2 = 22;
			int y = 2;
			out.println("x1: " + x1
					+ "\nx2: " + x2
					+ "\ny: " + y
					+ "\nwidth: " + width);
			
			DrawLine.drawLine(screen, x1, x2, y, width);
			Byte[] wrappedScreen = toObject(screen);
			out.println( BitPrinter.toBitStringWithHeader(wrappedScreen, width) );
		}
		
		out.println("--------------------------case4");
		{
			byte[] screen = new byte[15];
			int width = 40;
			int x1 = 18;
			int x2 = 22;
			int y = 2;
			out.println("x1: " + x1
					+ "\nx2: " + x2
					+ "\ny: " + y
					+ "\nwidth: " + width);
			
			DrawLine.drawLine(screen, x1, x2, y, width);
			Byte[] wrappedScreen = toObject(screen);
			out.println( BitPrinter.toBitStringWithHeader(wrappedScreen, width) );
		}
	}
	
	
	public static Byte[] toObject(byte[] array) {
	    
		
	    final Byte[] result = new Byte[array.length];
	    for (int i = 0; i < array.length; i++) {
	        //result[i] = new Byte(array[i]);
	    	result[i] = array[i];
	    }
	    return result;
	}
}


