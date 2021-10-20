package c10_SortingAndSearching.p05_SparseSearch;
//import static java.lang.System.out;
//2021 0108(Fri)
public class _1005_MySparseSearch_freq02 {
	

	public static int search( String[] strs_sparseSorted, String key ) {
		return binarySearch(strs_sparseSorted, key, 0, strs_sparseSorted.length -1); 
	}
	
	
	
	static int binarySearch( String[] strs_sparseSorted, String key, int left_bound, int right_bound ) {
		
		int mid_onExistentElt = getMidIndex_onExistentElement(strs_sparseSorted, left_bound, right_bound);
		while(left_bound <= right_bound) {
			
			String mid_value = strs_sparseSorted[mid_onExistentElt];
			if( key.compareTo(mid_value) == 0) {
				return mid_onExistentElt;
			}
			else if( key.compareTo(mid_value) < 0 ) {
				right_bound = mid_onExistentElt -1 ;
			}
			//if( key.compareTo(mid_value) > 0 )
			else {
				left_bound = mid_onExistentElt + 1;
			}
			mid_onExistentElt = getMidIndex_onExistentElement(strs_sparseSorted, left_bound, right_bound);
		}
		
		return -1;
	}
	
	
	
	//backbone
	static int getMidIndex_onExistentElement( String[] strs_sparseSorted, int left_bound, int right_bound) {
		
		int mid = left_bound + ( right_bound - left_bound ) / 2;
		
		if(strs_sparseSorted[mid].isEmpty() == false) {
			return mid;
		}
		
//		int left_explorer = mid -1;
//		while( left_bound <= left_explorer  ) {
//			if(strs_sparseSorted[left_explorer].isEmpty() == false) {
//				return left_explorer;
//			}
//			left_explorer--;
//		}
		
		//better
		for( int left_explorer = mid -1; left_bound <= left_explorer; left_explorer-- ) {
			if(strs_sparseSorted[left_explorer].isEmpty() == false) {
				return left_explorer;
			}
		}
		
		for( int right_explorer = mid +1; right_explorer <= right_bound; right_explorer++ ) {
			if(strs_sparseSorted[right_explorer].isEmpty() == false) {
				return right_explorer;
			}
		}
		
		//that thing is not exist
		return -1;
	}

}


