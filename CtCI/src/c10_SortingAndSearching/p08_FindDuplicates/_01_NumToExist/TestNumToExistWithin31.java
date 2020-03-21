package c10_SortingAndSearching.p08_FindDuplicates._01_NumToExist;

import static java.lang.System.out;

public class TestNumToExistWithin31 {

	public static void main(String[] args) {
		
		NumToExist_withinValue31 numToExist_31 = new NumToExist_withinValue31();
		
		numToExist_31.set(3);
		numToExist_31.set(20);
		numToExist_31.set(12);
		
		for(int i = 0 ; i < 32; i ++) {
			
			if(numToExist_31.isExist(i)) {
				out.println("number " + i + " exists");
			}
		}
		
		out.println("- - - - - - - - - - - - - -  ");
		
		numToExist_31.erase(20);
		numToExist_31.erase(13);
		
		for(int i = 0 ; i < 32; i ++) {
			
			if(numToExist_31.isExist(i)) {
				out.println("number " + i + " exists");
			}
		}
		
		out.println("end ");
		
	}

}
