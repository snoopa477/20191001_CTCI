package c01_ArraysAndStrings.p02_CheckPermutatoin;
import static java.lang.System.out;
public class CheckPermutation_01_Sort {

	
	public static boolean checkPermutation( String s1, String s2 ) {
		
		//DETAIL: use cheap operation to have quick check before further thorough check
		if( s1.length() != s2.length() ) {
			return false;
		}
		
		String sortedS1 = mergeSort( s1 );
		String sortedS2 = mergeSort( s2 );
		
		return sortedS1.equals( sortedS2 );
		
	}
	
	
	
	//private static void mergeSort(String str) {
	private static String mergeSort(String str) {
		
		char[] arr = str.toCharArray();
		char[] helperArr = new char[ arr.length ];
		
		mergeSort( arr, helperArr, 0, arr.length -1 );
		
		//return arr.toString();
		return new String( arr );
	}
	
	
	
	/*MISTAKE: String as argument is like pass by value; char[] is like pass by reference*/
	//private static void mergeSort(String str, int low, int high, String asd) {
	//NAMING arr is better than str
	private static void mergeSort( char[] arr, char[] helperArr, int iLow, int iHigh ) {
		
		//MISTAKE: Am I going to use this func, or implement it?
		if( iLow < iHigh ) {
			
			int iMiddle = ( iHigh - iLow ) /2 + iLow;
			mergeSort( arr, helperArr, iLow, iMiddle );
			mergeSort( arr, helperArr, iMiddle + 1, iHigh );
			//DETAIL: now the both arr intervals [iLow, iMiddle] and [iMiddle + 1, iHigh] are sorted, ready to call sort, or merge. 
			sort( arr, helperArr, iLow, iHigh );
			
		}
	}
	
	
	
	/**
	 * The sort is called under the premise that the input has logically two sorted arrays
	 * ; both of them are stored in 'arr'. 
	 * <br>Given iMiddle = ( iHigh - iLow ) /2 + iLow
	 * <br>The first sorted array ranges from iLow to iMiddle; second sorted array from iMiddle + 1 to iHigh
	 * <br>
	 * <br>
	 * We sort by merging. We merge two given sorted arrays into one target sorted array by picking the smallest element from the two arrays in each iteration until one of them depletes
	 * <br>, and then the other remaining fill the rest of target array
	 */
	private static void sort( char[] arr, char[] helperArr, int iLow, int iHigh ) {
		
		//MAMING RULE: i stands for index
		
		//We only process a snippet of arr, which ranges from low to high
		
		//USE some implication
		
		//read from both helper left and helper right, pick one and overwrite to arr
		
		/* IMAGINATION
		 * it's like copying a snippet of DNA
		 */
		for( int i = iLow; i <= iHigh; i++ ) {
			helperArr[ i ] = arr[ i ];
		}
		
		//DETAIL: iMiddle can be implied from iLow and iHigh -> no need to be parameter 
		int iMiddle = ( iHigh - iLow ) /2 + iLow;
		
		//DETAIL: left sorted array's index ranges from iLow to iMiddle
		int iLeft_Current = iLow;  
		int iLeft_Bound = iMiddle;
		
		//DETAIL: right sorted array's index ranges from iMiddle + 1 to iHigh
		int iRight_Current = iMiddle + 1;
		int iRight_Bound = iHigh;
		
		int iWrite = iLow; 
		
		//PURPOSE: part1/2. merge two given sorted arrays into one target sorted array by picking the smallest element from the two arrays in each iteration until one of them depletes
		while( iLeft_Current <= iLeft_Bound
			&& iRight_Current <= iRight_Bound) {
			
			char minLeft = helperArr[ iLeft_Current ];
			char minRight =  helperArr[ iRight_Current ];
			
			/*if( helperArr[ iLeft_Current ] < helperArr[ iRight_Current ] ) {
				//arr[ iWrite ] = 
			}*/
			
			if( minLeft < minRight ) {
				arr[ iWrite ] = minLeft;
				iLeft_Current++;
			}
			else {
				arr[ iWrite ] = minRight;
				iRight_Current++;
			}
			iWrite++;
		}
		
		
		//PURPOSE part2/2. and then the other remaining fill the rest of target array
		/* REASONING:
		 * reaching here meaning one of two sorted array depletes, remaining the other
		 * , and we are going to depletes the remaining one 
		 * , and now the 'arr' under construction looks like this: 
		 * [ sorted array which is just get down ][ original and partially overwritten right sorted array]
		 * 
		 * if the remaining one is right sorted array, then no further operation; just use the existent right sorted array. No if statement needed
		 * 
		 * if the remaining is left sorted array, then further operation is needed. 
		 * Interestingly, if left one remains => iLeft_Current < iLeft_Bound, no if statement to check if left sorted array needed
		 */
		
		//for( int i = iLeft_Current; i <= iLeft_Bound; i++) {
		
		while( iLeft_Current <= iLeft_Bound ) {
			arr[ iWrite ] = helperArr[ iLeft_Current ];
			iLeft_Current++;
			iWrite++;
		}
		
	}
	
	
	
	//TEST merge sort
	/*
	 YouTube and after sorted: TYbeouu 
	 hello and after sorted: ehllo 
	 aAaAAaAa and after sorted: AAAAaaaa  
	 */
	public static void main(String[] args) {
		
		String[] inputs = { "YouTube", "hello", "aAaAAaAa"};
		
		for( String input: inputs ) {
			
			out.printf("%s and after sorted: %s \n"
					, input
					, mergeSort( input ) );
			
		}
		
	}
	
}




