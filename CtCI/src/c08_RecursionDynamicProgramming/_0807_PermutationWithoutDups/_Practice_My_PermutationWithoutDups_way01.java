package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups;
import static java.lang.System.out;
import java.util.*;

/*
 * PURPOSE 
 * given we have all permutations of (n-1) = f(n-1)
 * consider nth element, 
 * f(n) would be
 * 	insert nth element to all possible positions in f(n-1)
 * 
 */
/* THINK_FURTHER
 * 
 * it's data structure is like ArrayList<ArrayList<String>>
 */
public class _Practice_My_PermutationWithoutDups_way01 {

	public static ArrayList<String> getAllPermutatoins(String sequence){
		
		
		return getAllPermutatoinsHelper(sequence);
	}
	
	
	private static ArrayList<String> getAllPermutatoinsHelper(String sequence){
		
		
		//base case
		if(sequence.length() == 1) {
			ArrayList<String> result = new ArrayList<>();
			result.add(sequence);
			return result;
		}
		
		/*DETAIL
		 * 'sequence' is concatenation of 'firstChar' and 'subSequence'
		 */
		char firstChar = sequence.charAt(0);
		String subSequence = sequence.substring(1);
		
		/*DETAIL
		 * this is quite similar to call subcall f(n-1); however, this is not obvious
		 */
		ArrayList<String> permsOfSubSeq = getAllPermutatoinsHelper(subSequence);
		
		ArrayList<String> result = new ArrayList<String>();
		
		//uncaught exception NullPointwerException
		for(String permOfSebSeq : permsOfSubSeq) {
			String newSeq;
			for(int i = 0; i < permOfSebSeq.length(); i++) {
				newSeq = newSeqByInsertionOfChar(permOfSebSeq, firstChar, i);
				result.add(newSeq);
			}
			
			newSeq = insertAtBack( permOfSebSeq , firstChar);
			result.add(newSeq);
		}
		
		
		//return null;
		return result;
	}
	
	/**
	 * 
	 * Insert 'ch' at index 'idx' by left  
	 */
	private static String newSeqByInsertionOfChar(String str, char ch, int idx){
		
		String leftPart = str.substring(0, idx);
		char midPart = ch;
		String rightPart = str.substring(idx);
		
		return leftPart + midPart + rightPart;
	}
	
	/* WRONG
	 * I forget newSeqByInsertionOfChar won't cover all the possible insertion position cases
	 * So this method is needed to fill the missing cases which newSeqByInsertionOfChar cannot cover
	 */
	private static String insertAtBack( String str, char ch ) {
		
		return str + ch;
	}
	
}


