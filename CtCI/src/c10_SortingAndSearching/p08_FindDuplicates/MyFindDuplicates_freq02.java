package c10_SortingAndSearching.p08_FindDuplicates;
import static java.lang.System.out;

//import java.util.ArrayList;
//2021 0113(Wed)
import c10_SortingAndSearching.p08_FindDuplicates._01_NumToExist.MyIntegerSet_freq02;
public class MyFindDuplicates_freq02 {
	
	
	public static void findDuplicates(int[] arr, int maxNumber){
		
		MyIntegerSet_freq02 set = new MyIntegerSet_freq02(maxNumber);
		boolean isFirst = true;
		for(int i = 0; i < arr.length; i++) {
			if( false == set.contains(arr[i]) ) {
				set.put(arr[i]);
			}
			else {
//				out.print( (i == 0? "": " ") + arr[i] );
				out.print( ( isFirst? "": " ") + arr[i] );
				isFirst = false;
			}
		}
		out.println();
	}

}


