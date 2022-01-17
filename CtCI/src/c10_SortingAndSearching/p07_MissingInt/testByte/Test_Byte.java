package c10_SortingAndSearching.p07_MissingInt.testByte;
import static java.lang.System.out;
public class Test_Byte {

	
	
	
	public static void main(String[] args) {
		
		int num1 = 127;
		int num2 = -128;
		int num3 = 128;
		int num4 = 129;
		//MISTAKE: this is wrong in 2 ways.
		int num5 = 2<<7 + 2<<8;
		int num6 = (1<<7) + (1<<8);
		//REASONING: since + has a high precedence over <<,  this is equivalent of 1 << (7 + 1) << 8 = 1<<16 ~ 64 * 1000 
		int num7 = 1<<7 + 1<<8;
		
		
		//REASONING: when conversion from integer to byte, don't think about how value would change, but to think about byte only takes 8 bits from integer, and discard the remaining 24 bits. 
		
		//ERROR Type mismatch: cannot convert from int to byte
		//byte byte1=num1;
		byte byte1=(byte)num1;
		byte byte2=(byte)num2;
		//ERROR MESSAGE- Type mismatch: cannot convert from int to byte
		//byte num3= 128;
		byte byte3=(byte) num3;
		byte byte4=(byte) num4;
		byte byte5=(byte) num5;
		byte byte6=(byte) num6;
		byte byte7=(byte) num7;
		
		
		//REASONING: when converting from byte to integer, the leading bit of byte decides whether 1 or 0, which would fill the left side of 8 bits up to 32 bits. 
		//INTERESTING FACT: converting from byte to integer won't change the value 
		//THINK_FURTHER the value in decimal might change due to overflowing, so we need to consider bits, discarding bits, filling bit based on leading bit value, leading bit( positive or negative), before considering its value in decimal.
		int byteToNum1 = byte1;
		int byteToNum2 = byte2;
		int byteToNum3 = byte3;
		int byteToNum4 = byte4;
		int byteToNum5 = byte5;
		int byteToNum6 = byte6;
		int byteToNum7 = byte7;
		
		//REASONING: Integer.toBinaryString(byte1), byte1 is converting from byte to integer first.  
		
		/*OUTPUT
num1 : 127; 1111111; byte1 : 127; 1111111; byteToNum1 : 127
num2 : -128; 11111111111111111111111110000000; byte2 : -128; 11111111111111111111111110000000; byteToNum2 : -128
num3 : 128; 10000000; byte3 : -128; 11111111111111111111111110000000; byteToNum3 : -128
num4 : 129; 10000001; byte4 : -127; 11111111111111111111111110000001; byteToNum4 : -127
num5 : 262144; 1000000000000000000; byte5 : 0; 0; byteToNum5 : 0
num6 : 384; 110000000; byte6 : -128; 11111111111111111111111110000000; byteToNum6 : -128
num7 : 65536; 10000000000000000; byte7 : 0; 0; byteToNum7 : 0
		 * 
		 */
		
		out.println("num1 : "+num1 + "; " + Integer.toBinaryString(num1) + "; byte1 : "+byte1 + "; " + Integer.toBinaryString(byte1) + "; byteToNum1 : " + byteToNum1);
		out.println("num2 : "+num2 + "; " + Integer.toBinaryString(num2) + "; byte2 : "+byte2 + "; " + Integer.toBinaryString(byte2) + "; byteToNum2 : " + byteToNum2);
		out.println("num3 : "+num3 + "; " + Integer.toBinaryString(num3) + "; byte3 : "+byte3 + "; " + Integer.toBinaryString(byte3) + "; byteToNum3 : " + byteToNum3);
		out.println("num4 : "+num4 + "; " + Integer.toBinaryString(num4) + "; byte4 : "+byte4 + "; " + Integer.toBinaryString(byte4) + "; byteToNum4 : " + byteToNum4);
		out.println("num5 : "+num5 + "; " + Integer.toBinaryString(num5) + "; byte5 : "+byte5 + "; " + Integer.toBinaryString(byte5) + "; byteToNum5 : " + byteToNum5);
		out.println("num6 : "+num6 + "; " + Integer.toBinaryString(num6) + "; byte6 : "+byte6 + "; " + Integer.toBinaryString(byte6) + "; byteToNum6 : " + byteToNum6);
		out.println("num7 : "+num7 + "; " + Integer.toBinaryString(num7) + "; byte7 : "+byte7 + "; " + Integer.toBinaryString(byte7) + "; byteToNum7 : " + byteToNum7);
		
		out.println();
		
		
		
		
		//the way to set value in bits, second way is better than the first way
		//         3         2         1         0  
		//        10987654321098765432109876543210
		int a1 = 0b11111111111111111111111110000000;
		int a2 = (0b11111111<<24) + (0b11111111<<16) + (0b11111111<<8) + 0b10000000;
		//OUTPUT: a1: -128; a2: -128
		out.println( "a1: " + a1 + "; a2: " + a2 );
		
		
		out.println( Integer.toHexString(byte1) );
		out.println( Integer.toHexString(byte2) );
		
	}

}


