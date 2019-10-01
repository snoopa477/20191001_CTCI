package c08_RecursionDynamicProgramming.p11_Coins;

//20190818(Sun)
//�q���N���[�I�Ӭ�, JavaLanguage �٬O����{������; ���ɭԫܦhnotation�L�k��{�ڪ��Q�k, �����̿�inference�~��
//�Ϊ�, �n��

//�ҥ��Ҵ��Ѫ�����, �O�̥��T�����|; �M��, �H������������򥩤@����F���|;
//�]��, �J����~�ɭn��ץ�
public class MyCoins {
	
	public static int waysToMakeChange(int n) {
		int []coinValues = {50, 10, 1};
		int [][] computedResults = new int [n+1][coinValues.length];// precomputed values
		return waysToMakeChange(n, coinValues, 0 , computedResults);
	}
	
	
	//�Ҧ�case�@�Τ@�Ӷ��鷧��: ways to make change
	//�M��; �ſ���Ҧ�case��@�O���������������p(�Y��, �]�����n�ҩ�)
	private static int waysToMakeChange(int amount, int[] coinValues
			, int coinIndex, int[][] computedResults) {
		
		if(computedResults[amount][coinIndex] > 0) {
			return computedResults[amount][coinIndex];
		}
		
		//���ҥH�i�H�o��g: ��̫�@��index mapping �쪺value��1, �B�Ҧ�value����Ƥ~��o�q
		//�]��, �Ҧ���Ƴ��i�H�Q1�Һc��
		if(coinIndex >= coinValues.length -1)
			return 1;
		
		int conValue = coinValues[coinIndex];
		
		int ways = 0;
		
		for(int i =0; i * conValue <= amount; i++) {
			// don't get mistaken i as 1
			int remainingAmount = amount - i* conValue;
			if(remainingAmount >= 0)
				ways += waysToMakeChange(remainingAmount, coinValues, coinIndex + 1, computedResults);
			else
				ways += 0;
		}
		computedResults[amount][coinIndex] = ways;
		
		return ways;
	} 
}
