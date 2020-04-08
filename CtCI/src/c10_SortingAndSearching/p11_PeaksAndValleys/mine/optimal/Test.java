package c10_SortingAndSearching.p11_PeaksAndValleys.mine.optimal;
import static java.lang.System.out;

import util.MyArrays;
public class Test {

	public static void main(String[] args) {
		{
			out.println("case 1");
			
			int[] input = { 5, 3, 1, 2, 3};
			MyArrays.print(input);
			PeaksAndValleys sms = new PeaksAndValleys();
			sms.sortAsPeaksAndValleys(input);
			MyArrays.print(input);
		}
		
		{
			out.println("case 2");
			
			int[] input = { 15, 31, 11, 52, 93, 22, 3, 12, 33, 22};
			MyArrays.print(input);
			PeaksAndValleys sms = new PeaksAndValleys();
			sms.sortAsPeaksAndValleys(input);
			MyArrays.print(input);
		}
	}

}


