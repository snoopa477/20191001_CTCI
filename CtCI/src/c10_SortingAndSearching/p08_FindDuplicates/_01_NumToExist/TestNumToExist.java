package c10_SortingAndSearching.p08_FindDuplicates._01_NumToExist;

import static java.lang.System.out;

public class TestNumToExist {

	public static void main(String[] args) {
		
		{
			out.println("NumToExist:");
			final int maxNum  = 10000;
			
			NumToExist numToExist = new NumToExist(maxNum);
			
			numToExist.set(2545);
			numToExist.set(7777);
			numToExist.set(12);
			numToExist.set(651);
			numToExist.set(10012);
			
			printAllExistNum(numToExist, maxNum);
			
			out.println("- - - - - - - - - - - - - - -");
			
			numToExist.erase(651);
			numToExist.erase(7777);
			numToExist.erase(666);
			
			printAllExistNum(numToExist, maxNum);
		}
		
		{
			out.println("MyIntegerSet_freq02: ");
			final int maxNum  = 10000;
			
			MyIntegerSet_freq02 set = new MyIntegerSet_freq02(maxNum);
			
			set.put(2545);
			set.put(7777);
			set.put(12);
			set.put(651);
			set.put(10012);
			
			out.println(set.getList());
			
			out.println("- - - - - - - - - - - - - - -");
			
			set.remove(651);
			set.remove(7777);
			set.remove(666);
			
			out.println(set.getList());
			
		}
		
		
	}
	
	public static void printAllExistNum(NumToExist numToExist, int maxNum) {
		for( int i = 0; i <  maxNum; i++) {
			if(numToExist.isExist(i)) {
				out.println("number exist: " + i);
			}
		}
	}

}
