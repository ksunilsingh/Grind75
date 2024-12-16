package grind75.practice1.week2;

/*
 * Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
	public String addBinary(String a, String b) {

		StringBuilder binarySum = new StringBuilder();

		int i = a.length() - 1, j = b.length() - 1, carry = 0;

		while (i >= 0 || j >= 0 || carry > 0) {
			int sum = carry;
			if (i >= 0) {
				sum += a.charAt(i) - '0';
				--i;
			}
			if (j >= 0) {
				sum += b.charAt(j) - '0';
				--j;
			}

			binarySum.append(sum % 2);
			carry = sum / 2;
		}

		return binarySum.reverse().toString();

//		Brute force - doesn't work for large numbers
//		int m = a.length();
//		int n = b.length();
//		long aDec = 0;
//		int index = 0;
//		for (int i = m - 1; i >= 0; i--) {
//			int num = (a.charAt(i) - '0');
//			aDec += (num * Math.pow(2, index++));
//		}
//
//		long bDec = 0;
//		index = 0;
//		for (int i = n - 1; i >= 0; i--) {
//			int num = (b.charAt(i) - '0');
//			bDec += (num * Math.pow(2, index++));
//		}
//		long sum = aDec + bDec;
//		if (sum == 0)
//			return "0";
//		StringBuilder binarySum = new StringBuilder();
//		while (sum > 0) {
//			binarySum.insert(0, sum % 2);
//			sum /= 2;
//		}
//		return binarySum.toString();
	}

	public static void main(String[] args) {
		AddBinary addB = new AddBinary();
		// System.out.println(addB.addBinary("11", "1"));
		System.out.println(addB.addBinary(
				"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
				"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
	}
}
