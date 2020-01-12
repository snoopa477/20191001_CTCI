package c10_SortingAndSearching.e01_mergesort;

//20191124(Sun

//��ƻ�Ĳv�n?
//���[�W�O�ݤ��X�Ӫ��F�ƦܡAı�o�ܺC
//���A�u�ꪺ�Ĳv�O�ݼƾǺ⪺���G(��operation �ƶq�èS���ܰ�)
public class MyMergeSort_comment {

	public static void mergesort(int[] array) {
		//syntax �h��, in[] �O�@��type, []�����@�ӰѼ�, ��size; �ڷQ�����O��constructor(�����Ӥ��O...? 
		//�ѩ�primitive type
		
		//�J�M������, �A�����e���|�Q�л\; �]��, �������O�@�w�O�̫�@������, �N���ݭn�S�O���@��(���|����W�W��,�άO�W�W�W��)
		
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length -1);
	}

	private static void mergesort(int[] array, int[] helper, int low, int high) {
		
		//�ѩ�C���B�z��low �a�k, high�a��; �ӳB�z�L�N����sort��
		//�]�N�O��low �������Osort�L��(���O�O�q���}�l�A���o�Ӫ�); high �a��(���high�k���w�gsort��)
		
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
		
		//�H�̫�����ı�� ���ӴN���s�b���F��...
		//else if ( low = high){
			//���Osorted base case!
			// �����ΰ�����Ʊ�, �N�Osorted array, �]�� �s�g���S���g�i��
			// �o�]�ɭP, �ڭ̱`�`�����o�ӭ��n��CASE; ����, �`���פ�ɭ�
		//}
		//else if (low > high){ ��ı�o�o���i��|�o��}
		/*
		 * �ҩ�: 
		 * ���� if (low < high){
		 * }
		 * low�Phigh�̤p���j��1 , ��sub method ���j��0 
		 * (low = middle, middle+1 = high)
		 * ��F�U�@�h, ���|�A�s�F; �]��, ���M�S�� low > high ��case�u���o��
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