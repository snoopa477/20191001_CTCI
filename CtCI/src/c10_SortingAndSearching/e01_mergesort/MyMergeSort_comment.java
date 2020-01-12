package c10_SortingAndSearching.e01_mergesort;

//20191124(Sun

//位甚麼效率好?
//直觀上是看不出來的；甚至，覺得很慢
//但，真實的效率是看數學算的結果(其operation 數量並沒有很高)
public class MyMergeSort_comment {

	public static void mergesort(int[] array) {
		//syntax 層面, in[] 是一個type, []接受一個參數, 為size; 我想像成是類constructor(但應該不是...? 
		//由於primitive type
		
		//既然取的值, 再取之前都會被覆蓋; 因此, 取的都是一定是最後一次取的, 就不需要特別維護它(不會取到上上次,或是上上上次)
		
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length -1);
	}

	private static void mergesort(int[] array, int[] helper, int low, int high) {
		
		//由於每次處理完low 靠右, high靠左; 而處理過意味著sort完
		//也就是說low 的左側是sort過的(但是是從哪開始，不得而知); high 靠左(表示high右側已經sort完)
		
		// Why do we need this if statement?
		//we know that each time we process the array, low right shift, high leftShift
		//and ONLY the unsorted part is withn low and high
		//Therefore, if low < high, that means that interval is non-exist => don't have
		//to do the sorting job
		if(low < high) {
			int middle = (low + high) / 2 ;
			mergesort(array, helper, low, middle);//sort the left half
			mergesort(array, helper, middle + 1, high);//sort the right half
			merge(array, helper, low, middle, high);//merge them
			//general arrives here: array sorted
		}
		//base case arrives here: one elt sorted
		
		//人們很難察覺到 本來就不存在的東西...
		//else if ( low = high){
			//它是sorted base case!
			// 它不用做任何事情, 就是sorted array, 因此 連寫都沒有寫進來
			// 這也導致, 我們常常忽略這個重要的CASE; 畢竟, 總有終止的時候
		//}
		//else if (low > high){ 我覺得這不可能會發生}
		/*
		 * 證明: 
		 * 執行 if (low < high){
		 * }
		 * low與high最小間隔為1 , 其sub method 間隔為0 
		 * (low = middle, middle+1 = high)
		 * 到了下一層, 不會再叫了; 因此, 必然沒有 low > high 的case真的發生
		 * 
		 * */
	}

	private static void merge(int[] array, int[] helper, int low, int middle, int high) {
		/*copy both halves into a helper array*/
		for(int i = low; i <=high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		/*iterate thru helper array, Compare the left and right half, copy back the smaller
		 * element from the 2 halves into the original array.
		 * */
		
		while( helperLeft <= middle && helperRight <= high) {
			
			if(helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			}
			else {//if right elment is smaller than left elt
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		/*Copy the rest of the left side of the array into the target array
		 * 
		 * */
		//there are 3 cases arriving here:
		//1. both array fills the original array
		//2. left array filled, right array left
		//3. right array filled, left array left
		int remaining = middle - helperLeft;
		for(int i =0; i <=remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
		
	}
	
}