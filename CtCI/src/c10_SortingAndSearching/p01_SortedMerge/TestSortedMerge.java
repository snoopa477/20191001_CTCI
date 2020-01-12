package c10_SortingAndSearching.p01_SortedMerge;

import static java.lang.System.out;


import java.util.Random;


//20191212(Thur
public class TestSortedMerge {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
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
		
	}
	
	
	public static void printArr(int[] arr, int length) {
		
		for(int i = 0; i < length; i++) {
			out.printf("%d ", arr[i]);
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
