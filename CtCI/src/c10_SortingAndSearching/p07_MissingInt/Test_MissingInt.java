package c10_SortingAndSearching.p07_MissingInt;
import static java.lang.System.out;

import java.io.FileNotFoundException;
public class Test_MissingInt {

	public static void main(String[] args) {
		
		try {
			_1007_00_MissingInt missingInt = new _1007_00_MissingInt();
			missingInt.findOpenNuMber();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		{
			String filename = "D:\\Notes\\CTCI\\10.07\\no67.txt";
			_Practice_MissingInt_01_enoughMemory missingIntFinder = new _Practice_MissingInt_01_enoughMemory();
			out.println( missingIntFinder.findMissingInteger(filename) ) ;
			
		}
		
		{
			String filename = "D:\\Notes\\CTCI\\10.07\\no67.txt";
			_Practice_MissingInt_02_NotEnoughMemory missingIntFinder = new _Practice_MissingInt_02_NotEnoughMemory();
			try {
				out.println( missingIntFinder.findMissingInt(filename) ) ;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
}


