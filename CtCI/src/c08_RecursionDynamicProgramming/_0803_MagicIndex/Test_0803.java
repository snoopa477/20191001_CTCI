package c08_RecursionDynamicProgramming._0803_MagicIndex;
import static java.lang.System.out;
public abstract class Test_0803 {

	public static void main(String[] args) {

		{
			out.println("case 1: textbook distint with slow answer");
			int[] magicIndeces = magicIndexDistinct();
			int[] array = nonMagiIndex();
			out.println( MagicIndex_01_Distinct.magicSlow(magicIndeces) );
			out.println( MagicIndex_01_Distinct.magicSlow(array));
			
		}
		
		{
			out.println("\ncase 2: textbook distint with fast answer");
			int[] magicIndeces = magicIndexDistinct();
			int[] array = nonMagiIndex();
			out.println( MagicIndex_01A_Distinct.magicFast(magicIndeces) );
			out.println( MagicIndex_01A_Distinct.magicFast(array));
			
		}
		
		{
			out.println("\ncase 3: textbook non distinct with answer");
			int[] magicIndeces = magicIndexNonDistinct();
			int[] array = nonMagiIndex();
			out.println( MagicIndex_02_NonDistinct.magicFast(magicIndeces) );
			out.println( MagicIndex_02_NonDistinct.magicFast(array));
			
		}
		
		{
			out.println("\ncase 4: my distinct with answer");
			int[] magicIndeces = magicIndexDistinct();
			int[] array = nonMagiIndex();
			out.println( My_MagicIndex_01_Distinct.findMagicIndex(magicIndeces) );
			out.println( My_MagicIndex_01_Distinct.findMagicIndex(array));
			
		}
		
		{
			out.println("\ncase 5: my non-distinct with answer");
			int[] magicIndeces = magicIndexNonDistinct();
			int[] array = nonMagiIndex();
			out.println( My_MagicIndex_02_NonDistinct.findMagicIndex(magicIndeces) );
			out.println( My_MagicIndex_02_NonDistinct.findMagicIndex(array));
			
		}
		
		
		
	}
	
	private static int[] magicIndexDistinct() {
		//					0	1	2	3	4 5	 6	7, 8,  9, 10
		return new int[] {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
	}
	
	private static int[] nonMagiIndex() {
		//					0	1	2	3	4 5	 6	7, 8,  9, 10
		return new int[] {-40, -20, -1, 1, 2, 3, 5, 8, 9, 12, 13};
	}
	
	private static int[] magicIndexNonDistinct() {
		//					0	1  2  3	 4  5  6  7, 8,  9, 10
		return new int[] {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
	}

}


