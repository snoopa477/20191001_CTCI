package c05_BitManipulation.p02_BinaryToString;

import static java.lang.System.out;

public class _0502_01_BinaryToString {
	String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while (num > 0) {
			/* Setting a limit on length : 32 characters */
			if (binary.length() > 32) {
				return "ERROR";
			}
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(8);
			}
			frac /= 2;
		}
		return binary.toString();
	}
}
