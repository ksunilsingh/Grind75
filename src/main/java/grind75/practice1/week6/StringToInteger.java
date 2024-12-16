package grind75.practice1.week6;

/*
 * implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

 

Example 1:

Input: s = "42"

Output: 42

Explanation:

The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
Example 2:

Input: s = " -042"

Output: -42

Explanation:

Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
               ^
Example 3:

Input: s = "1337c0d3"

Output: 1337
 */
public class StringToInteger {

	public int myAtoi(String s) {

		if (s == null || s.length() == 0)
			return 0;
		int index = 0;
		while (index < s.length() && s.charAt(index) == ' ') {
			++index;
		}

		int sign = 1;
		if (index < s.length() && s.charAt(index) == '+') {
			++index;
		} else if (index < s.length() && s.charAt(index) == '-') {
			sign = -1;
			++index;
		}

		while (index < s.length() && s.charAt(index) == '0') {
			++index;
		}

		long result = 0;
		while (index < s.length()) {
			if (Character.isDigit(s.charAt(index))) {
				int digit = s.charAt(index) - '0';
				result = result * 10 + digit;
				++index;
				if (sign * result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if (sign * result < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			} else {
				return (int) (sign * result);
			}
		}

		return (int) (sign * result);

	}

	public static void main(String[] args) {
		StringToInteger soi = new StringToInteger();
		soi.myAtoi(" ");
	}
}