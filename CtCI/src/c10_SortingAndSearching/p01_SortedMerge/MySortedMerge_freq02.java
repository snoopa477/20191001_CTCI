package c10_SortingAndSearching.p01_SortedMerge;
//import static java.lang.System.out;

//2020 1225(Fri
public class MySortedMerge_freq02 {

	//backbone
	static void mergeSrcToDestArray(int[] srcSortedArray, int[] destSortedArray
			, int srcArrayLength, int destArrayLength) {
		
		int srcIndex = srcArrayLength - 1;
		int destIndex = destArrayLength - 1;
		int mergedIndex = srcArrayLength + destArrayLength - 1;
		
		//to deplete srcArray, we use while ( !NOT_DEPLETION_CONDITION )
		while( srcIndex >= 0 ) {
			//pretty succinct for me, counter intuitive for me
			//let say, that's the ONLY condition where destArray has to move its element to mergeArray
			if( destIndex >= 0 && destSortedArray[destIndex] > srcSortedArray[srcIndex] ) {
				destSortedArray[ mergedIndex ] = destSortedArray[ destIndex ];
				destIndex--;
			}
			else {
				destSortedArray[ mergedIndex ] = srcSortedArray[ srcIndex ];
				srcIndex--;
			}
			mergedIndex--;
		}
		
		//depletion of srcArray, destArray itself is sorted => nothing left to do
		
		
	}
	
}


