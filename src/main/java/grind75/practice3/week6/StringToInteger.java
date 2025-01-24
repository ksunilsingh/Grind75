package grind75.practice3.week6;

public class StringToInteger {
	public int myAtoi(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int index = 0;
		char[] sChar = s.toCharArray();
		while (index < s.length() && sChar[index] == ' ') {
			++index;
		}
		int sign = 1;

		if (index < s.length() && sChar[index] == '-') {
			sign = -1;
			++index;
		} else if (index < s.length() && sChar[index] == '+') {
			++index;
		}

		while (index < s.length() && sChar[index] == '0') {
			++index;
		}

		long result = 0;

		while (index < s.length()) {
			if (Character.isDigit(sChar[index])) {
				result = result * 10 + (sChar[index] - '0');
				if ((sign * result) > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if ((sign * result) < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			} else {
				return (int) (sign * result);
			}
			++index;
		}

		return (int) (sign * result);
	}
}
