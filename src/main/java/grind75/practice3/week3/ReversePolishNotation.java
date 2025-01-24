package grind75.practice3.week3;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Set<String> opSet = new HashSet<>();
		opSet.add("+");
		opSet.add("-");
		opSet.add("*");
		opSet.add("/");
		Stack<Integer> valStack = new Stack<Integer>();
		for (String token : tokens) {
			if (opSet.contains(token)) {
				int op2 = valStack.pop();
				int op1 = valStack.pop();
				if (token.equals("+")) {
					valStack.push(op1 + op2);
				} else if (token.equals("-")) {
					valStack.push(op1 - op2);
				} else if (token.equals("*")) {
					valStack.push(op1 * op2);
				} else if (token.equals("/")) {
					valStack.push(op1 / op2);
				}
			} else {
				valStack.push(Integer.parseInt(token));
			}
		}
		return valStack.isEmpty() ? -1 : valStack.pop();
	}
}
