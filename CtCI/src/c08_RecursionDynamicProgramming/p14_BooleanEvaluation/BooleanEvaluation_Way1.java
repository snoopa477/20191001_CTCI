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
			//�q���h���J, index i is given value
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i+1, s.length());
			
			/*Evaluate each side for each result*/
			
			int leftTrue = countEval(left, true);
			int leftFalse = countEval(left, false);
			int rightTrue = countEval(right, true);
			int rightFalse = countEval(right, false);
			
			//��ı�o�H�U�o�@�q�Ĥ@���O�Q���X�Ӫ��A�O���J��n�g12��expr �ӹL�h�l(MyWay1)�A�~�Q��
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
	
	//��ı�o�o���Ztricky��
	//String equal true���۵�, false �����۵�
	// �Y�P1�۵� => �����s��reutnrn �N�q: Boolean  true
	//
	//�]�����Ʊ�(String equal)�P Boolean ��Ʊ��@��true false, �ɭP �Ĥ@�h��true false(string equal)
	//�P�ĤG�h��true false( convert to boolean) �V�c
	private static boolean stringToBool(String c ) {
		return c.equals("1")? true: false;
	}
	
}
