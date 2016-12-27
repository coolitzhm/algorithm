package second;

public class StringLeftShift {
	public void reverseString(char[] c, int from, int to) {
		while (from < to) {
			char tmp = c[from];
			c[from++] = c[to];
			c[to--] = tmp;
		}
	}

	public void leftRotateString(String s, int n) {
		char[] array = s.toCharArray();
		int len = array.length;
		n %= len;
		reverseString(array, 0, n - 1);
		reverseString(array, n, len - 1);
		reverseString(array, 0, len - 1);
	}
}
