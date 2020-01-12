package c08_RecursionDynamicProgramming.p14_BooleanEvaluation;
//20191119(Tue




public class BooleanEvaluation_Way1 {

	public static int countEval(String s, boolean result) {
		
		if(s.length() == 0)
			return 0;
		if(s.length() == 1)
			return stringToBool(s) == result?
					1: 0;
		
		int ways = 0;
		//e.g.1: 1^0|0|0|1
		//e.g.2: 0^0&0^1|1
		for( int i = 1; i < s.length(); i +=2 ) {
			//從此層切入, index i is given value
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i+1, s.length());
			
			/*Evaluate each side for each result*/
			
			int leftTrue = countEval(left, true);
			int leftFalse = countEval(left, false);
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);
			
			//我覺得以下這一段第一次是想不出來的，是先遇到要寫12個expr 太過多餘(MyWay1)，才想到
			//
			int total = ( leftTrue + leftFalse) * (rightTrue + rightFalse);
			
			int totalTrue = 0;
			if ( c =='^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			}else if ( c == '&') {
				totalTrue = leftTrue * rightTrue;
			}else if ( c =='|' ) {
				totalTrue = leftTrue * rightTrue + leftFalse* rightTrue +
						leftTrue * rightFalse;
			}
			
			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		return ways;
	}
	
	//我覺得這個蠻tricky的
	//String equal true為相等, false 為不相等
	// 若與1相等 => 給予新的reutnrn 意義: Boolean  true
	//
	//因為兩件事情(String equal)與 Boolean 兩事情共用true false, 導致 第一層的true false(string equal)
	//與第二層的true false( convert to boolean) 混淆
	private static boolean stringToBool(String c ) {
		return c.equals("1")? true: false;
	}
	
}
