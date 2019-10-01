package c08_RecursionDynamicProgramming.p11_Coins.draft01;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.out;

public class Util {

	public static void print(ArrayList<HashMap<Integer, Integer>> arrayOfMap) {
		for( HashMap<Integer, Integer> map: arrayOfMap) {
			for( Integer key: map.keySet() ) {
				out.print("[" + key + "¤¸ : " + map.get(key)+ "ªT]");
			}
			out.println("");
		}
	}
	
}
