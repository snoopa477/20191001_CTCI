package c10_SortingAndSearching.p11_PeaksAndValleys.textbook.optimal;
import static java.lang.System.out;

import util.MyArrays;
public class Test {

	public static void main(String[] args) {
		
		{
			out.println("case 1");
			
			int[] input = { 5, 3, 1, 2, 3};
			MyArrays.print(input);
			PeaksAndValleys sms = new PeaksAndValleys();
			sms.sortValleyPeak(input);
			MyArrays.print(input);
		}
		
		
		
	}

}


