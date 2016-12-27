package second;

public class MinPeriodSubString {
	public int minPeriodSubString(String s) {
		char[] pattern = s.toCharArray();
		int len = pattern.length;
		if (len == 0)
			return -1;
		int j = 0;
		int k = -1;
		int[] next = new int[len];// 仿照KMP，求"伪Next"
		next[0] = -1;// 哨兵，串首标志
		while (j < len - 1) {
			if (k == -1 || pattern[j] == pattern[k]) {
				j++;
				k++;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
		next[0] = 0;// 回复成逻辑上的0
		if (next[len - 1] == 0)
			return -1;
		int period = len - next[len - 1];
		if (len % period == 0)
			return period;
		return -1;
	}
}
