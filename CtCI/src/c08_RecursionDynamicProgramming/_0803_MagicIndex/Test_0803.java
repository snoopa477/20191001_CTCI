package c08_RecursionDynamicProgramming._0803_MagicIndex;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashSet;
public abstract class Test_0803 {

	public static void main(String[] args) {
		
		String[] chosenOptions = {"2", "3", "8", "9"};
		HashSet<String> options = new HashSet<>( Arrays.asList(chosenOptions) );
		
		
		if(options.contains("1"))
		{
			out.println("case 1: textbook distint with slow answer");
			int[] magicIndeces = magicIndexDistinct();
			int[] array = nonMagiIndex();
			out.println( MagicIndex_01_Distinct.magicSlow(magicIndeces) );
			out.println( MagicIndex_01_Distinct.magicSlow(array));
			
		}
		
		if(options.contains("2"))
		{
			out.println("\ncase 2: textbook distint with fast answer");
			int[] magicIndeces = magicIndexDistinct();
			int[] array = nonMagiIndex();
			out.println( MagicIndex_01A_Distinct.magicFast(magicIndeces) );
			out.println( MagicIndex_01A_Distinct.magicFast(array));
			
		}
		
		if(options.contains("3"))
		{
			out.println("\ncase 3: textbook non distinct with answer");
			int[] magicIndeces = magicIndexNonDistinct();
			int[] array = nonMagiIndex();
			out.println( MagicIndex_02_NonDistinct.magicFast(magicIndeces) );
			out.println( MagicIndex_02_NonDistinct.magicFast(array));
			
		}
		
		if(options.contains("4"))
		{
			out.println("\ncase 4: my distinct with answer");
			int[] magicIndeces = magicIndexDistinct();
			int[] array = nonMagiIndex();
			out.println( My_MagicIndex_01_Distinct.findMagicIndex(magicIndeces) );
			out.println( My_MagicIndex_01_Distinct.findMagicIndex(array));
			
		}
		
		if(options.contains("5"))
		{
			out.println("\ncase 5: my non-distinct with answer");
			int[] magicIndeces = magicIndexNonDistinct();
			int[] array = nonMagiIndex();
			out.println( My_MagicIndex_02_NonDistinct.findMagicIndex(magicIndeces) );
			out.println( My_MagicIndex_02_NonDistinct.findMagicIndex(array));
			
		}
		
		if(options.contains("6"))
		{
			out.println("\ncase 6: my non-distinct with answer");
			int[] magicIndeces = magicIndexNonDistinct();
			int[] array = nonMagiIndex();
			out.println( My_MagicIndex_01_Distinct_02.findMagicIndex(magicIndeces) );
			out.println( My_MagicIndex_01_Distinct_02.findMagicIndex(array));
			
		}
		
		if(options.contains("7"))
		{
			out.println("\ncase 7: my non-distinct with answer");
			int[] magicIndeces = magicIndexNonDistinct();
			int[] array = nonMagiIndex();
			out.println( My_MagicIndex_02_NonDistinct_02.findMagicIndex(magicIndeces) );
			out.println( My_MagicIndex_02_NonDistinct_02.findMagicIndex(array));
			
		}
		
		if(options.contains("8")){
			out.println("\ncase 8: my distint with fast answer");
			int[] magicIndeces = magicIndexDistinct();
			int[] array = nonMagiIndex();
			out.println( _Practice_My_MagicIndex_01_Distinct.getMagicIndex(magicIndeces) );
			out.println( _Practice_My_MagicIndex_01_Distinct.getMagicIndex(array));
			
		}
		
		if(options.contains("9")){
			out.println("\ncase 9: my non distint with fast answer");
			int[] magicIndeces = magicIndexNonDistinct();
			int[] array = nonMagiIndex();
			out.println( _Practice_My_MagicIndex_02_NonDistinct.getMagicIndex(magicIndeces) );
			out.println( _Practice_My_MagicIndex_02_NonDistinct.getMagicIndex(array));
			
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


