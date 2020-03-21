package c10_SortingAndSearching.p08_FindDuplicates;

import static java.lang.System.out;

public class testFindDuplicates {

	public static void main(String[] args) {
		
		{
			int[] input = {125,5,4,8,3,45,65,45,125,4,89, 10045, 10045, 10047};
			_1008_00_FindDuplicates.checkDuplicates(input);
			out.println("- - - - - - - - - - - - - - - - - - - - -");
			_1008_01_MyFindDuplicates.findDuplicate(input);
		}
		
		
		
	}

}
