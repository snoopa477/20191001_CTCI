package c10_SortingAndSearching.p01_SortedMerge;

//20191212(Thur
public class MySortedMerge {

	public static void mergeFromBackEnd(int[] dest_array, int[] src_array
			, int length_dest, int length_src) {
		
		int dest_idx = length_dest - 1;
		int src_idx = length_src - 1;
		int merge_idx = length_dest + length_src - 1;
		
		//��while�ӫDfor, �]�������C�@�����|--
		while( src_idx >= 0 ) {
			
			//�Ĥ@�ӻPmain logic�L�[, ���u�O�Ψ��˹�further access ���|�y��nullPointerException
			//���ݭn�ˮ�src_idx, �]���~�h�w�g���F
			if(  dest_idx >= 0 && dest_array[dest_idx] > src_array[src_idx] ) {
				dest_array[merge_idx] = dest_array[dest_idx];
				dest_idx--;
			}
			else {
				dest_array[merge_idx] = src_array[src_idx];
				src_idx--;
			}
			
			merge_idx--;
		}
		
		
	}
	
	
}
