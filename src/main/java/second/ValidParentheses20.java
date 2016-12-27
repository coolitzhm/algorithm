package second;

import java.util.Stack;

public class ValidParentheses20 {
	public static boolean isValid(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty() || !match(stack.peek(),ch[i])) {
				stack.push(ch[i]);
			} else {
				stack.pop();
			}
		}
		if (s.isEmpty())
			return true;
		return false;
	}

	public static boolean match(char a, char b) {
		if (a == '(' && b == ')')
			return true;
		if (a == '[' && b == ']')
			return true;
		if (a == '{' && b == '}')
			return true;
		return false;
	}

	public static void main(String[] args) {
		String s = "([])";
		boolean res = isValid(s);
		System.out.println(res);
	}
}
