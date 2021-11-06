package c08_RecursionDynamicProgramming._0807_PermutationWithoutDups;
import static java.lang.System.out;

import java.util.ArrayList;

public class _Practice_My_PermutationWithoutDups_way02 {
	
	/* PURPOSE
	 * given we have n balls
	 * n balls of all permutation is
	 * all the ways we pick one ball out of ball group ( we call it x, which is n )
	 * and then we permute the remaining balls of ball group ( we call f( n balls - that picked ball) )
	 * n * f( n balls - that picked ball)
	 */
	public static ArrayList<String> getAllPermutatoins(String sequence){
		
		
		return getAllPermutatoinsHelper(sequence);
	}

	private static ArrayList<String> getAllPermutatoinsHelper(String sequence) {
		
		//base case
		if(sequence.length() == 1) {
			ArrayList<String> result = new ArrayList<>();
			result.add(sequence);
			return result;
		}
		
		
		char pickedChar;
		String remainingSeq;
		ArrayList<String> subPermutations;
		ArrayList<String> result = new ArrayList<>();
		for( int pickIdx = 0 ; pickIdx < sequence.length(); pickIdx++ ) {
			pickedChar = sequence.charAt(pickIdx);
			
			remainingSeq = substractCharFromSeq( sequence, pickIdx );
			subPermutations = getAllPermutatoins(remainingSeq);
			
			
			for( String subPerm : subPermutations ) {
				String permutaion =  pickedChar + subPerm;
				result.add( permutaion );
			}
			
		}
		
		return result;
	}

	
	
	private static String substractCharFromSeq(String sequence, int pickIdx) {
		
		//just in case
		if( sequence.length() -1 < pickIdx ) {
			return "";
		}
		
		String remainingLeft = sequence.substring(0, pickIdx);
		//This comment is for better understanding
		//Char pickedChar = sequence.charAt(pickedIdx);
		String remainingRight = sequence.substring(pickIdx + 1);
		
		return remainingLeft + remainingRight;
	}

}


