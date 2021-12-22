package c10_SortingAndSearching.p02_GroupAnagrams.List_toArray_T;

import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.out;
/*
Returns an array containing all of the elements in this list in proper sequence (from first to last element);
 the runtime type of the returned array is that of the specified array. If the list fits in the specified 
 array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified 
 array and the size of this list. 

If the list fits in the specified array with room to spare(i.e., the array has more elements than the list),
 the element in the array immediately following the end of the collection is set to null. (This is useful
  in determining the length of the list only if the caller knows that the list does not contain any null 
  elements.)

 * */
public class Test_List_toArray_T {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>( Arrays.asList("apple", "banana", "caterpillar") );

		
		out.println("list: ");
		out.println(list.toString());
		
		out.println("\n1: arr size is the same as list");
		
		String[] arr = new String[ list.size() ];
		out.println("before");
		printArr( arr );
		arr = list.toArray(arr);
		out.println("after");
		printArr( arr );
		
		
		out.println("\n2: the arr size is larger than list");
		String[] arr2 = new String[ 10 ];
		arr2[0] = "asdf";
		arr2[4] = "asdf";
		out.println("before");
		printArr( arr2 );
		
		arr2 = list.toArray(arr2);
		out.println("after");
		printArr( arr2 );
		
		
		out.println("\n3: arr size is one, which is smaller than list");
		String[] arr3 = list.toArray( new String[0] );
		out.println("after");
		printArr( arr3 );
		
		
		out.println("4");
		
		
	}
	
	static void printArr(String[] strs) {
		
		for(String str: strs) {
			out.print( "[" + str + "] " );
		}
		out.println();
	}

}


