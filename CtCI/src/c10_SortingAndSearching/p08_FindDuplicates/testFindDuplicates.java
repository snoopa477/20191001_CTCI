package c10_SortingAndSearching.p08_FindDuplicates;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;

public class testFindDuplicates {

	public static void main(String[] args) {
		
		HashSet<String> options = new HashSet<>( Arrays.asList(new String[] {"2"} ) );
		
		if( options.contains("1") )
		{
			int[] input = {125,5,4,8,3,45,65,45,125,4,89, 10045, 10045, 10047};
			_1008_00_FindDuplicates.checkDuplicates(input);
			out.println("- - - - - - - - - - - - - - - - - - - - -");
			_1008_01_MyFindDuplicates.findDuplicate(input);
			
			out.println("MyFindDuplicates_freq02: ");
			MyFindDuplicates_freq02.findDuplicates(input, 32000);
			
		}
		
		
		if( options.contains("2") ) {
			
			String[] fileNames = { "D:\\Notes\\CTCI\\10.07\\no67.txt", "D:\\Notes\\CTCI\\10.07\\no67dup101.txt" };
			
			for( String fileName : fileNames ) {
				_Practice_FindDuplicates findDuplicate = new _Practice_FindDuplicates( );
				out.printf("fileName is %s, find the duplicate number %d\n"
					/* THINK_FURTHER: what if we uncomment this line, while the file has lower value than the statement states the minVlaue = 0
					 * suppose the normalizedKey is -1, then in the set method there will be like << -1, which result in unexpected outcome 
					 **/
					//, fileName, findDuplicate.findDuplicate(fileName, 32000, 1));
						, fileName, findDuplicate.findDuplicate(fileName, 32000, 0));
			}
			
		}
		
		
		
	}

}
