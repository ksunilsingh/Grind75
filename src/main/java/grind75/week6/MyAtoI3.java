package grind75.week6;

public class MyAtoI3 {
	public int myAtoi(String s) {

		if (s == null || s.length() == 0)
			return 0;

		int n = s.length();
		int index = 0;
		int sign = 1;

		while (index < n && s.charAt(index) == ' ') {
			index++;
		}

		if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
			if (index + 1 < n && (s.charAt(index + 1) == '+' || s.charAt(index + 1) == '-'))
				return 0;
			sign = s.charAt(index) == '-' ? -1 : 1;
			index++;
		}
		long result = 0;
		while (index < n && Character.isDigit(s.charAt(index))) {
			int digit = s.charAt(index) - '0';
			result = result * 10 + digit;
			++index;
			if (sign * result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign * result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}

		return (int) (sign * result);
	}

}
