package c10_SortingAndSearching.p08_FindDuplicates._01_NumToExist;
import static java.lang.System.out;

import java.util.ArrayList;

//2021 0112(Tue)
public class MyIntegerSet_freq02 {
	
	static final int SIZE_OF_INTEGER = 32;
	private int maxNumber;
	private int[] arr_32BitsToBoolean;

	
	
	public MyIntegerSet_freq02(int maxNumber) {
		this.maxNumber = maxNumber;
		int words = maxNumber / SIZE_OF_INTEGER + 1;
		arr_32BitsToBoolean = new int[words];
	}
	
	
	
	public boolean contains(int number) {
		//don't forget
		if (number > maxNumber) {
			return false;
		}
		int word_Index = getWordIndex(number);
		int word_Offset = getWordOffset(number);
		//mistake
		//boolean result = ( arr_32BitsToBoolean[word_Index] & ( 1 << word_Offset )) == 1;
		boolean result = ( arr_32BitsToBoolean[word_Index] & ( 1 << word_Offset )) != 0;
		
		return result;
	}
	
	
	
	public void put(int number) {
		//don't forget
		if( number > maxNumber ) {
			out.println("can't do " + number);
			return ;
		}
		int word_Index = getWordIndex(number);
		int word_Offset = getWordOffset(number);
		arr_32BitsToBoolean[word_Index] = arr_32BitsToBoolean[word_Index] | ( 1 << word_Offset );
	}
	
	
	
	public void remove(int number) {
		//don't forget
		if (number > maxNumber) {
			out.println("can't do" + number);
			return;
		}
		int word_Index = getWordIndex(number);
		int word_Offset = getWordOffset(number);
		arr_32BitsToBoolean[word_Index] = arr_32BitsToBoolean[word_Index] & ~( 1 << word_Offset );
	}
	
	
	
	public ArrayList<Integer> getList(){
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i <= maxNumber; i++) {
			if( contains(i) ) {
//				out.println( i );
				list.add(i);
			}
		}
		
		return list;
	}
	
	
	
	private int getWordIndex(int number) {
		return number / SIZE_OF_INTEGER;
	}
	
	
	
	private int getWordOffset(int number) {
		return number % SIZE_OF_INTEGER;
	}
}


