package second.secondlesson;

/*
 * 把栈转换成深度deep
 * 因为左右括号肯定不相等，所以左右各扫描一次
 */
public class LongestMchBcksSubString2 {
	public static int matchBck(String s) {
		char[] brts = s.toCharArray();
		int n = brts.length;
		int deep = 0;
		int start = -1;
		int ml = 0;
		for (int i = 0; i < n; i++) {
			if (brts[i] == '(')
				deep++;
			else {
				deep--;
				if (deep == 0) {
					ml = i - start > ml ? i - start : ml;
				} else if (deep < 0) {// 说明右括号，比左括号多，初始化为for循环前
					deep = 0;
					start = i;
				}
			}
		}
		deep = 0;
		start = n;
		for (int i = n - 1; i >= 0; i--) {
			if (brts[i] == ')')
				deep++;
			else {
				deep--;
				if (deep == 0)
					ml = start - i > ml ? start - i : ml;
				else if (deep < 0) {// 说明左括号比右括号多，初始化为for循环前
					deep = 0;
					start = i;
				}
			}
		}
		return ml;
	}

	public static void main(String[] args) {
		String s = "()(()()))";
		int res = matchBck(s);
		System.out.println(res);
	}
}
