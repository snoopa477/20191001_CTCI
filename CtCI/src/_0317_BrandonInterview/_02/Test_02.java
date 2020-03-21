package _0317_BrandonInterview._02;

import static java.lang.System.out;

import java.util.ArrayList;

public class Test_02 {

	public static void main(String[] args) {
		
		//ArrayList<Integer> arry = new ArrayList<Integer>(5);
		//out.println("array list size " + arry.size());
		
		OptimumAppleToCapacity opatc= new OptimumAppleToCapacity();
		
		
		
		out.println(opatc.optimumAppleToCapcity(new int[]{100,30,30,100,50,100}, 150) );
		out.println(opatc.optimumAppleToCapcity(new int[]{150, 150, 150}, 350) );
	}

}
