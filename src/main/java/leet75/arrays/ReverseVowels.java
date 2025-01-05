package leet75.arrays;

public class ReverseVowels {

	public String reverseVowels(String s) {
		int left = 0, right = s.length() - 1;
		StringBuilder sb = new StringBuilder(s);
		while (left < right) {
			while (left < right && !isVowel(s.charAt(left))) {
				++left;
			}
			while (left < right && !isVowel(s.charAt(right))) {
				--right;
			}
			if (left < right && sb.charAt(left) != sb.charAt(right)) {
				char temp = sb.charAt(left);
				sb.setCharAt(left, sb.charAt(right));
				sb.setCharAt(right, temp);
			}
			++left;
			--right;
		}
		return sb.toString();
	}

	private boolean isVowel(char c) {
		return "AEIOUaeiou".indexOf(c) != -1;
	}

	public static void main(String[] args) {
		ReverseVowels rv = new ReverseVowels();
		rv.reverseVowels("a0G0i0masA::sA4m4ipGp0");
	}
}
