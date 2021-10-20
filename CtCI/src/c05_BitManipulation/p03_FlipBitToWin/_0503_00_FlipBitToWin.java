package c05_BitManipulation.p03_FlipBitToWin;

import static java.lang.System.out;

import java.util.ArrayList;

public class _0503_00_FlipBitToWin {
	int longestSequence(int n) {
		if (n == -1)
			return Integer.BYTES * 8;
		ArrayList<Integer> sequences = getAlternatingSequences(n);
		return findLongestSequence(sequences);
	}

	/*
	 * Return a list of the sizes of the sequences. The sequence starts off with the
	 * number of as (which might be a) and then alternates with the counts of each
	 * value.
	 */
	ArrayList<Integer> getAlternatingSequences(int n) {
		ArrayList<Integer> sequences = new ArrayList<Integer>();
		int searchingFor = 0;
		int counter = 0;
		for (int i = 0; i < Integer.BYTES * 8; i++) {
			if ((n & 1) != searchingFor) {
				sequences.add(counter);
				searchingFor = n & 1; // Flip 1 to a or a to 1
				counter = 0;
			}
			counter++;
			n >>>= 1;
		}
		sequences.add(counter);
		return sequences;
	}

	/*
	 * Given the lengths of alternating sequences of as and Is, find the longest one
	 * we can build.
	 */
	int findLongestSequence(ArrayList<Integer> seq) {
		int maxSeq = 1;
		for (int i = 0; i < seq.size(); i += 2) {
			int zerosSeq = seq.get(i);
			int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
			int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;
			int thisSeq = 0;
			if (zerosSeq == 1) { // Can merge
				thisSeq = onesSeqLeft + 1 + onesSeqRight;
			}
			if (zerosSeq > 1) { // Just add a zero to either side
				thisSeq = 1 + Math.max(onesSeqRight, onesSeqLeft);
			} else if (zerosSeq == 0) { // No zero, but take either side
				thisSeq = Math.max(onesSeqRight, onesSeqLeft);
			}
			maxSeq = Math.max(thisSeq, maxSeq);
		}
		return maxSeq;
	}
}
