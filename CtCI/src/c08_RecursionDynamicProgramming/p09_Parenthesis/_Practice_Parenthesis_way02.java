package c08_RecursionDynamicProgramming.p09_Parenthesis;
import static java.lang.System.out;

import java.util.*;
public class _Practice_Parenthesis_way02 {
	
	public static ArrayList<String> getAllParenSeqs(int numberOfParens) {
		
		ArrayList<String> results = new ArrayList<String>();
		getAllParenSeqsHelper(0, 0, numberOfParens, "", results);
		
		return results;
	}

	
	
	/* REASONING
	 * valid
	 * R	 1  23
	 * L	1 23
	 * 		()(())
	 * 
	 * invalid
	 * R	 1 23
	 * L	1 2
	 * 		()())
	 * 
	 * at any given point, building parens from left to right, 
	 * 1. leftParens >= rightParens
	 * 2. when all leftParens and rightParens consumes -> parens build complete
	 */
	
	/* DETAIL
	 * it's recursion post-order method: iterative
	 * e.g. quickSort
	 * counter e.g. mergeSort
	 * 
	 * Imagine calling multi sub method is like building a tree
	 */
	private static void getAllParenSeqsHelper(int leftParensUsed, int rightParensUsed, int numberOfParens,  String currentSubParenSeq, ArrayList<String> results) {
		
		
		//Impossible -> cut off
		if( (leftParensUsed > numberOfParens)
				|| (rightParensUsed > numberOfParens) ) {
			return;
		}
		
		
		//invalid -> cut off
		if( leftParensUsed < rightParensUsed ) {
			return;
		}
		
		
		//the complete parenSeq is formed, added to results
		if( (leftParensUsed == numberOfParens) 
				&& (rightParensUsed == numberOfParens) ) {
			
			results.add(currentSubParenSeq);
			return ;
		}
			
		
		//PURPOSE: none of the above. General case, currentSubParenSeq is growing. there are two ways: add leftParen or rightParen
		//add one leftParen
		/*
		 * MISTAKE: that put char in front of existing parens
		 * getAllParenSeqsHelper( leftParensUsed + 1, rightParensUsed, numberOfParens, "(" + currentSubParenSeq, results );
		 * RESULT: [)))(((, ))()((, )())((, ))(()(, )()()(]
		 */
		getAllParenSeqsHelper( leftParensUsed + 1, rightParensUsed, numberOfParens, currentSubParenSeq + "(", results );
		//add one rightParen 
		getAllParenSeqsHelper( leftParensUsed, rightParensUsed + 1, numberOfParens, currentSubParenSeq + ")", results );
		
		
	}
	
}


