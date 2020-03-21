package _0317_BrandonInterview._02;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.out;

public class OptimumAppleToCapacity {

	
	int optimumAppleToCapcity(int[] applesWeights, int containerWightLeft) {
		
		out.println("applesWeights.length " + applesWeights.length);
		
		ArrayList<HashMap<Integer, Integer>> itwtn = 
				new ArrayList<HashMap<Integer, Integer>>(applesWeights.length ) ;
		
		out.println("itwtn.length " + itwtn.size());
		
		for(int i = 0; i < applesWeights.length; i++) {
			//out.println(i);
			//itwtn.set(i, new HashMap<Integer, Integer>())  ;
			itwtn.add( new HashMap<Integer, Integer>());
		}
		
		return optimumAppleToCapcity(applesWeights, applesWeights.length-1, containerWightLeft,itwtn);
		
	}
	
	
	private int optimumAppleToCapcity(int[] applesWeights, int k
			, int containerWightLeft, ArrayList<HashMap<Integer, Integer>> itwtn) {
	
		
		if(k < 0) {
			return 0;
		}
		
		if(itwtn.get(k).containsKey(containerWightLeft) == false) {
			
			int num_no_curr_apple = optimumAppleToCapcity(applesWeights, k-1, containerWightLeft, itwtn);
			int num_with_curr_apple = 
					containerWightLeft < applesWeights[k] ?
							0:
							1 + optimumAppleToCapcity(applesWeights, k-1, containerWightLeft-applesWeights[k], itwtn);
			
			int max_num = Math.max(num_no_curr_apple, num_with_curr_apple);
			
			//itwtn[k].put(containerWightLeft, max_num);
			HashMap<Integer, Integer> map = itwtn.get(k);
			map.put(containerWightLeft, max_num);
			itwtn.set(k, map);
		}
		
		return itwtn.get(k).get(containerWightLeft);
		
	}
	
	
	
}
