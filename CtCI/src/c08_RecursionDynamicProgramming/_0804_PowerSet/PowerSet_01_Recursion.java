package c08_RecursionDynamicProgramming._0804_PowerSet;
import java.util.ArrayList;
public class PowerSet_01_Recursion {
	
	static public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if(set.size() == index) {
			allsubsets= new ArrayList<>();
			allsubsets.add(new ArrayList<>());
		}
		else {
			
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
			
			for(ArrayList<Integer> subset: allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
			
		}
		
		return allsubsets;
	}

}


