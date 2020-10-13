package c08_RecursionDynamicProgramming._0803_MagicIndex;
//import static java.lang.System.out;
public class My_MagicIndex_01_Distinct {
	
	
	//since we gotta use BST, we need paramater start and end to set the boundary
	public static int findMagicIndex( int[] arr ) {
		
		int start_Index = 0; 
		int end_Index = arr.length -1;
		
		//there are two ways to do BST. one is for while loop, another is for recursion
		while( start_Index <= end_Index ) {
			
			int mid_Index = start_Index + (end_Index - start_Index) /2;
			
			//magic index definition
			if(arr[mid_Index] == mid_Index) {
				return mid_Index;
			}
			
			//if magic index exist, it must on the left side of mid_index, since arr[i] never catches up i 
			//given that i > mid_Index
			//therefore, we reset the start / end to move left
			
			//MISTAKE: have to visualize the picture so that you won't get confused
			else if( arr[mid_Index] > mid_Index ) {
				end_Index = mid_Index -1;
			}
			//likewise
			// arr[mid_index] > mid_index
			else {
				start_Index = mid_Index +1;
			}
			
		}
		
		return -1;
	}

}


