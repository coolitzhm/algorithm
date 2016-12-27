package second.secondlesson;

import java.util.Stack;

/*
 * 我一开始理解错了，以为是找到有多少对匹配的括号，
 * 找出最长匹配的括号字串长度，所以条件是找到连续的括号匹配的长度
 * 所以需要维护一个值，来记录当前最长字串的长度，比较大小
 * 只有在左括号和右括号发生匹配时，才进行ml的更新。
 * 这道题也说明了，算法思想的重要性。如何把根据思想，一步步变为代码
 */
public class LongestMatchBrackets {
	public static int matchBrackets(String brackets) {
		char[] brs = brackets.toCharArray();
		int n = brs.length;
		Stack<Integer> s = new Stack<Integer>();
		int start = -1;
		int ml = 0;
		for (int i = 0; i < n; i++) {
			if (brs[i] == '(')
				s.push(i);
			else {
				if (s.isEmpty())
					start = i;
				else {
					s.pop();
					if (s.isEmpty()) {
						ml = i - start > ml ? i - start : ml;
					} else {
						ml = i - s.peek() > ml ? i - s.peek() : ml;
					}
				}
			}
		}
		return ml;
	}

	public static void main(String[] args) {
		String s = "()(()()))";
		int res = matchBrackets(s);
		System.out.println(res);
	}
}
