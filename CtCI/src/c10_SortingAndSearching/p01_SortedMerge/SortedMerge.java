package c10_SortingAndSearching.p01_SortedMerge;

import static java.lang.System.out;

//20191212(Thur
public class SortedMerge {

	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerged = lastB + lastA - 1;
		
//		out.println("indexA is " + indexA);
		
		while(indexB >= 0) {
			
//			out.println("a[indexA] " + a[indexA]);
//			out.println("b[indexB] " + b[indexB]);
//			
			if(indexA >= 0 && a[indexA] > b[indexB] ) {
				a[indexMerged] = a[indexA];
				indexA--;
			}
			else {
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
		
	}
	
	
}
