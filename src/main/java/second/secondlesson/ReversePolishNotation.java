package second.secondlesson;

import java.util.Stack;

public class ReversePolishNotation {
	public static int reversePolishN(String[] expression) {
		int n = expression.length;
		Stack<Integer> s = new Stack<Integer>();
		int a, b;
		for (int i = 0; i < n; i++) {
			if (!isOperation(expression[i])) {
				s.push(Integer.parseInt(expression[i]));
			} else {
				b = s.pop();
				a = s.pop();
				switch (expression[i]) {
				case "+":
					s.push(a + b);
					break;
				case "-":
					s.push(a - b);
					break;
				case "*":
					s.push(a * b);
					break;
				case "/":
					s.push(a / b);
					break;
				default:
					break;
				}
			}
		}
		return s.pop();
	}

	public static char[] infixToSuffix(char[] expression) {
		int n = expression.length;
		char[] exSuffix = new char[n];
		Stack<Character> s = new Stack<Character>();
		int i = 0;
		int index = 0;
		while (i < n) {
			if (isOperation(expression[i])) {
				if (s.isEmpty() || s.peek() == '(')
					s.push(expression[i++]);
				else if (prior(expression[i], s.peek()))
					s.push(expression[i++]);
				else {
					exSuffix[index++] = s.pop();
					s.push(expression[i++]);
				}
			} else {
				if (expression[i] == '(') {
					s.push(expression[i++]);
				} else if (expression[i] == ')') {
					while (s.peek() != '(') {
						exSuffix[index++] = s.pop();
					}
					s.pop();
					i++;
				} else {
					exSuffix[index++] = expression[i++];
				}
			}
		}

		while (!s.isEmpty()) {
			exSuffix[index++] = s.pop();
		}

		for (char c : exSuffix) {
			System.out.print(c + " ");
		}
		System.out.println();
		return exSuffix;
	}

	public static boolean prior(char a, char b) {
		if (a == '*' && (b == '+' || b == '-'))
			return true;
		else if (a == '/' && (b == '+' || b == '-'))
			return true;
		return false;
	}

	public static boolean isOperation(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}

	public static boolean isOperation(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			return true;
		return false;
	}

	//
	// public static int autoI(char c) {
	// String mi = String.valueOf(c);
	// int res = Integer.parseInt(mi);
	// return res;
	// }

	public static void main(String[] args) {
		// String expression = "132-*5";
		// String[] expSuffix = { "10", "6", "2", "-", "*", "8", "+" };
		// int res = reversePolishN(expSuffix);
		// System.out.println(res);
		String exIn = "a*((b+c)*d)";
		infixToSuffix(exIn.toCharArray());

	}
}
