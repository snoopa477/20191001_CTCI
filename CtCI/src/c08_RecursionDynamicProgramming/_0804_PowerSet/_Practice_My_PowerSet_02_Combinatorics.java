package c08_RecursionDynamicProgramming._0804_PowerSet;
import static java.lang.System.out;
import java.util.*;

/*
REASONING
all subset = consider every element if exist or not.
given a set with size = 2: abc, there are 2 * 2  possibilities to create subset
0 0 
0 1
1 0
1 1

and by coincidence, if we look at them in base 2, the sequence is equal to 
0
1
2
3

in base 10
*/
public class _Practice_My_PowerSet_02_Combinatorics {

	public static ArrayList<ArrayList<String>> getAllSubSets( ArrayList<String> set){
		
		
		/* REPLACED
		 int numberOfElements = set.size();
		 */
		int setSize = set.size();
		//DETAIL we aim for power of 2, instead of aiming for bit. see the reasoning
		int numberOfSubSet = 1 << setSize;
		
		
		return getSubSetHelper(numberOfSubSet, setSize, set);
	}
	
	private static ArrayList<ArrayList<String>> getSubSetHelper(int numberOfSubSet, int setSize,  ArrayList<String> set){
		
		ArrayList<ArrayList<String>> allSubSets = new ArrayList<ArrayList<String>>();
		
		/* REPLACED
		 for(int sequenceOfIfExistInBit = 0 ; sequenceOfIfExistInBit < numberOfSubSet; sequenceOfIfExistInBit++) {
		 */
		for(int bitSequence = 0 ; bitSequence < numberOfSubSet; bitSequence++) {
			ArrayList<String> subSet = getSubSetBySequence(bitSequence, setSize, set);
			allSubSets.add(subSet);
		}
		
		return allSubSets;
	}

	
	
	private static ArrayList<String> getSubSetBySequence(int bitSequence, int numberOfElements,  ArrayList<String> set) {
		
		
		ArrayList<String> subSet = new ArrayList<String>();
		
		for(int i = 0; i < numberOfElements; i ++) {
			int ifExist = ((bitSequence >> i) & 1 );
			if( ifExist == 1) {
				//THINK_FURTHER the reason we use arrayList, so we can get element in order
				String element = set.get(i);
				subSet.add( element );
			}
		}
		
		//DETAIL I don't like the idea that 1. each time the value is decreased, changed 2. cannot randomly get index
		/*
		REPLACED
		while(sequenceOfIfExistInBit >= 0) {
			
			int isExist = sequenceOfIfExistInBit & 1)
			
		}
		*/
		
		
		return subSet;
	}
	
}


