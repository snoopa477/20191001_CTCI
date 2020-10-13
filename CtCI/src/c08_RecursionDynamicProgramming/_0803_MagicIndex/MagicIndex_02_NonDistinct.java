package c08_RecursionDynamicProgramming._0803_MagicIndex;

public class MagicIndex_02_NonDistinct {
	
	public static int magicFast(int[] array) {
		return magicFast(array, 0, array.length -1);
	}
	
	private static int magicFast(int[] array, int start, int end) {
		
		if( end < start ) {
			return -1;
		}
		
		int midIndex = (start + end) /2;
		int midValue = array[midIndex];
		if(midValue == midIndex) {
			return midIndex;
		}
		
		/*search left*/
		int leftIndex = Math.min(midIndex -1, midValue);
		int left = magicFast(array, start, leftIndex);
		if(left >= 0) {
			return left;
		}
		
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);
		
		return right;
		
	}

}


