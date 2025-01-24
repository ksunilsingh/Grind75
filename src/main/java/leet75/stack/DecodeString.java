package leet75.stack;

import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {
		Stack<Integer> stackCount = new Stack<>();
		Stack<StringBuilder> stackSB = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				n = n * 10 + Character.getNumericValue(ch);
			} else if (ch == '[') {
				stackCount.push(n);
				n = 0;
				stackSB.push(sb);
				sb = new StringBuilder();
			} else if (ch == ']') {
				int k = stackCount.pop();
				StringBuilder repl = sb;
				sb = stackSB.pop();
				while (k > 0) {
					sb.append(repl);
					--k;
				}
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		// System.out.println(ds.decodeString("3[a2[c]]"));
		System.out.println(ds.decodeString("3[a]2[bc]"));
	}
}
