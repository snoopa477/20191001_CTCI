package c05_BitManipulation.p01_Insertion;
import static java.lang.System.out;

import util.BitPrinter;
public class Test_Insertion_01_Embed {

	public static void main(String[] args) {
		
		Insertion_01_Embed.IS_DEBUG = true;
		
		InputSet[] inputSets = { 
			new InputSet(
				0b10000000000,
				0b10011,
				6,
				2),
			
			new InputSet(
				0b11111111111,
				0b10011,
				8,
				3)
		};
		
		
		
		for( InputSet inputSet : inputSets ) {
		
			out.println(" - - - ");
			
			out.println( inputSet + "\nresult:\n" 
			+ BitPrinter.bitString( 
				Insertion_01_Embed.embed(inputSet.number_N, inputSet.number_M, inputSet.leftBit, inputSet.rightBit)
				, true ) );
		
		/*
		   - - - 
mask
1 1 1 1  (28) 1 1 1 1  (24) 1 1 1 1  (20) 1 1 1 1  (16) 1 1 1 1  (12) 1 1 1 1  (8) 1 0 0 0  (4) 0 0 1 1  (0)
masked_N
0 0 0 0  (28) 0 0 0 0  (24) 0 0 0 0  (20) 0 0 0 0  (16) 0 0 0 0  (12) 0 1 0 0  (8) 0 0 0 0  (4) 0 0 0 0  (0)
number_N
0 0 0 0  (28) 0 0 0 0  (24) 0 0 0 0  (20) 0 0 0 0  (16) 0 0 0 0  (12) 0 1 0 0  (8) 0 0 0 0  (4) 0 0 0 0  (0)
number_M
0 0 0 0  (28) 0 0 0 0  (24) 0 0 0 0  (20) 0 0 0 0  (16) 0 0 0 0  (12) 0 0 0 0  (8) 0 0 0 1  (4) 0 0 1 1  (0)
(leftBit,rightBit)=(6,2)

result:
0 0 0 0  (28) 0 0 0 0  (24) 0 0 0 0  (20) 0 0 0 0  (16) 0 0 0 0  (12) 0 1 0 0  (8) 0 1 0 0  (4) 1 1 0 0  (0)
 - - - 
mask
1 1 1 1  (28) 1 1 1 1  (24) 1 1 1 1  (20) 1 1 1 1  (16) 1 1 1 1  (12) 1 1 1 0  (8) 0 0 0 0  (4) 0 1 1 1  (0)
masked_N
0 0 0 0  (28) 0 0 0 0  (24) 0 0 0 0  (20) 0 0 0 0  (16) 0 0 0 0  (12) 0 1 1 0  (8) 0 0 0 0  (4) 0 1 1 1  (0)
number_N
0 0 0 0  (28) 0 0 0 0  (24) 0 0 0 0  (20) 0 0 0 0  (16) 0 0 0 0  (12) 0 1 1 1  (8) 1 1 1 1  (4) 1 1 1 1  (0)
number_M
0 0 0 0  (28) 0 0 0 0  (24) 0 0 0 0  (20) 0 0 0 0  (16) 0 0 0 0  (12) 0 0 0 0  (8) 0 0 0 1  (4) 0 0 1 1  (0)
(leftBit,rightBit)=(8,3)

result:
0 0 0 0  (28) 0 0 0 0  (24) 0 0 0 0  (20) 0 0 0 0  (16) 0 0 0 0  (12) 0 1 1 0  (8) 1 0 0 1  (4) 1 1 1 1  (0)

		 */
			
		}
		
		
	}

	
	
	static class InputSet{
		public int number_N;
		public int number_M;
		public int leftBit;
		public int rightBit;
		
		public InputSet(int number_N, int number_M, int leftBit, int rightBit) {
			this.number_N = number_N;
			this.number_M = number_M;
			this.leftBit = leftBit;
			this.rightBit = rightBit;
		}
		
		public String toString() {
			
			return String.format("number_N\n%s\nnumber_M\n%s\n(leftBit,rightBit)=(%d,%d)\n",
				BitPrinter.bitString(number_N, true),
				BitPrinter.bitString(number_M, true),
				leftBit,
				rightBit);
			
		}
		
	}
	
}


