package c08_RecursionDynamicProgramming._0804_PowerSet;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
public class Test_0804 {

	public static void main(String[] args) {
		
		
		{
			out.println("case 1: PowerSet_Recursion");
			ArrayList<ArrayList<Integer>> sets = PowerSet_01_Recursion.getSubsets(getSet1(), 0);
			printSets(sets);
			
		}
		
		{
			out.println("\ncase 2: PowerSet_Combinatorics");
			ArrayList<ArrayList<Integer>> sets = PowerSet_02_Combinatorics.getSubserts2(getSet1());
			printSets(sets);
			
		}
		
		{
			out.println("\ncase 3: MyPowerSet_Combinatorics");
			ArrayList<ArrayList<String>> sets = My_PowerSet_02_Combinatorics.getSubSets(getSet_String());
			printSets_String(sets);
			
		}
		
		{
			out.println("\ncase 4: MyPowerSet_Recursion");
			ArrayList<ArrayList<String>> sets = My_PowerSet_01_Recursion.getAllSubsets(getSet_String());
			printSets_String(sets);
			
		}
		
		{
			out.println("\ncase 5: MyPowerSet_Recursion_02");
			ArrayList<ArrayList<String>> sets = My_PowerSet_01_Recursion_02.getAllSubSets(getSet_String());
			printSets_String(sets);
			
		}
		
		{
			out.println("\ncase 6: MyPowerSet_Combinatorics_02");
			ArrayList<ArrayList<String>> sets = My_PowerSet_02_Combinatorics_02.getAllSubSets(getSet_String());
			printSets_String(sets);
			
		}
		
		
		
		out.println("end");
		
		
	}
	
	public static void printSets( ArrayList<ArrayList<Integer>> sets) {
		
		for(ArrayList<Integer> set : sets) {
			
			//MISTAKE:
			//forget size = 0
			if(set.size() == 0) {
				out.println("{ }");
			}
			else {
				boolean isFirstElt = true;
				for(Integer elt : set) {
					out.print( (isFirstElt? "{ ": ",") + elt);
					isFirstElt = false;
				}
				out.println(" } ");
			}
		}
	}
	
	//Erasure of method printSets(ArrayList<ArrayList<String>>) is the same as another method in type Test_0804
	//.. hmm generic issue?
	public static void printSets_String( ArrayList<ArrayList<String>> sets) {
		
		for(ArrayList<String> set : sets) {
			
			//MISTAKE:
			//forget size = 0
			if(set.size() == 0) {
				out.println("{ }");
			}
			else {
				boolean isFirstElt = true;
				for(String elt : set) {
					out.print( (isFirstElt? "{ ": ",") + elt);
					isFirstElt = false;
				}
				out.println(" } ");
			}
		}
	}
	
	public static ArrayList<Integer> getSet1(){
		
		ArrayList<Integer> set = new ArrayList<>();
		set.addAll(Arrays.asList(1,2,3,4));
		return set;
	}
	
	public static ArrayList<String> getSet_String(){
		
		ArrayList<String> set = new ArrayList<>();
		set.addAll(Arrays.asList("A", "B", "C", "D"));
		return set;
	}

}


