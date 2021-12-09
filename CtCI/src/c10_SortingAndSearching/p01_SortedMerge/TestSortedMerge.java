package c10_SortingAndSearching.p01_SortedMerge;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;


//20191212(Thur
public class TestSortedMerge {

	static final int SIZE = 5;
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		String[] chosenOptions = { "3" };
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		
		if(options.contains("1"))
		{
			int maxALen = rand.nextInt(10) + 10;
			int arrALen = rand.nextInt(maxALen);
			int arrBLen = maxALen - arrALen;
			int[] A = new int[maxALen];
			int[] B = new int[arrBLen];
			getTwoSortedArrs(A, maxALen, arrALen, B, arrBLen);
			MySortedMerge.mergeFromBackEnd(A, B, arrALen, arrBLen);
			printArr(A, maxALen);
		}
		
		if(options.contains("2"))
		{
			out.println("MySortedMerge_freq02: ");
			int maxALen = rand.nextInt(10) + 10;
			int arrALen = rand.nextInt(maxALen);
			int arrBLen = maxALen - arrALen;
			int[] A = new int[maxALen];
			int[] B = new int[arrBLen];
			getTwoSortedArrs(A, maxALen, arrALen, B, arrBLen);
			MySortedMerge_freq02.mergeSrcToDestArray(A, B, arrALen, arrBLen);
			printArr(A, maxALen);
		}
		
		if(options.contains("3"))
		{
			
			int lastIdx_a = rand.nextInt(SIZE) + SIZE;
			int lastIdx_b = rand.nextInt(SIZE) + SIZE;
			int length_a = ( lastIdx_a + 1 ) + ( lastIdx_b + 1 ) +  rand.nextInt(SIZE);
			int length_b = ( lastIdx_b + 1 ) +  rand.nextInt(SIZE);
			
			int[] arr_a = new int[ length_a ];
			assignSortedArr(arr_a, lastIdx_a + 1);
			
			int[] arr_b = new int[ length_b ];
			assignSortedArr(arr_b, lastIdx_b + 1);
			
			printArr( arr_a, lastIdx_a );
			printArr( arr_b, lastIdx_b );
			
			out.println("after merge");
			_Practice_SortedMerge.merge(arr_a, lastIdx_a, arr_b, lastIdx_b);
			int[] mergedArr = arr_a;
			int lastIdx_merge = ( lastIdx_a + 1 ) + ( lastIdx_b + 1 ) -1;
			
			printArr(mergedArr, lastIdx_merge);
			
			
		}
		
	}
	
	
	/**
	 * last Idx: -1 means we don't have such thing
	 * '|' is to denote the position where set effective elements or not apart
	 */
	public static void printArr(int[] arr, int lastIdx) {
		
		for( int i = 0; i < arr.length; i++ ) {
			String separator =  i == lastIdx ? "|": " ";
			out.printf("%3d%s", arr[i], separator );
		}
		out.println();
		
	}
	
	public static void assignSortedArr(int[] arr, int len) {
		
		Random rand = new Random();
		int currVal = 0;
		
		for(int i = 0 ; i < len; i++) {
			currVal += rand.nextInt(30);
			arr[i] = currVal;
		}
		
	}
	
	public static void getTwoSortedArrs(int[] A, int maxALen, int arrALen, int[] B, int arrBLen) {
//		Random rand = new Random();
		
		//would be woring if uncomment these
		//when the method ends, A will be null, why???
		//I thought someone is still referencing it, so the garbage collector won't kill it, right?
//		A = new int[maxALen];
//		B = new int[arrBLen];
//		
		
		assignSortedArr(A, arrALen);
		assignSortedArr(B, arrBLen);
		out.printf("maxALen is %d  %narrAlen is %d  %narrBlen is %d%n",maxALen, arrALen, arrBLen);
		printArr(A, arrALen);
		printArr(B, arrBLen);
	}

}
