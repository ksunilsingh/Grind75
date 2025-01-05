package leet75.arrays;

public class StringCompression {
	public int compress(char[] chars) {
		int n = chars.length;
		int index = 0;
		for (int i = 0; i < n; i++) {
			char ch = chars[i];
			int count = 0;
			while (i < n && ch == chars[i]) {
				++count;
				++i;
			}
			chars[index++] = ch;
			if (count > 1) {
				for (char digit : Integer.toString(count).toCharArray()) {
					chars[index++] = digit;
				}
			}
			--i;
		}
		return index;
	}

	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		sc.compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' });
	}
}
