package c08_RecursionDynamicProgramming._0803_MagicIndex;
public class MagicIndex_01_Distinct {
	
	public static int magicSlow(int[] array) {
		
		for(int i = 0; i< array.length; i++) {
			
			if(array[i] == i) {
				return i;
			}
			
		}
		return -1;
	}

}


