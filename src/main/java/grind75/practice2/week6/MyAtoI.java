package grind75.practice2.week6;

public class MyAtoI {
	public int myAtoi(String s) {
		if (s == null || s.length() == 0)
			return 0;

		// Remove white space
		s = s.trim();
		int sign = 1;
		int index = 0;
		if (index < s.length() && s.charAt(index) == '-') {
			sign = -1;
			++index;
		} else if (index < s.length() && s.charAt(index) == '+') {
			++index;
		}

		while (index < s.length() && s.charAt(index) == '0') {
			++index;
		}
		long actualNumber = 0;
		for (int i = index; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int digit = (s.charAt(i) - '0');
				actualNumber = actualNumber * 10 + digit;
				if ((sign * actualNumber) > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if ((sign * actualNumber) < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			} else {
				return (int) (sign * actualNumber);
			}
		}
		return (int) (sign * actualNumber);
	}

	public static void main(String[] args) {
		MyAtoI myAtoI = new MyAtoI();
		myAtoI.myAtoi("-91283472332");
	}

}
