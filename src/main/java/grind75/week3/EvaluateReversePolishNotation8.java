package grind75.week3;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation8 {

	public int evalRPN(String[] tokens) {
		Set<String> validOps = new HashSet<>();
		validOps.add("+");
		validOps.add("-");
		validOps.add("*");
		validOps.add("/");
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			if (validOps.contains(tokens[i])) {
				int secondOperand = stack.pop();
				int firstOperand = stack.pop();
				if (tokens[i].equals("+")) {
					stack.push(firstOperand + secondOperand);
				}
				if (tokens[i].equals("-")) {
					stack.push(firstOperand - secondOperand);
				}
				if (tokens[i].equals("*")) {
					stack.push(firstOperand * secondOperand);
				}
				if (tokens[i].equals("/")) {
					stack.push(firstOperand / secondOperand);
				}

			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		EvaluateReversePolishNotation8 evaluate = new EvaluateReversePolishNotation8();
		evaluate.evalRPN(new String[] { "4", "13", "5", "/", "+" });
	}
}
