package thred;

public class StringCycleLeftShift {
	public static String leftShift(String s, int n) {
		char[] ch = s.toCharArray();
		int len = ch.length;
		n = n % len;

		reverse(ch, 0, n - 1);
		reverse(ch, n, len - 1);
		reverse(ch, 0, len - 1);
//		System.out.println(ch.toString());
		return String.valueOf(ch);
	}

	public static void reverse(char[] ch, int m, int n) {
		while (n > m) {
			char tmp = ch[m];
			ch[m] = ch[n];
			ch[n] = tmp;
			n--;
			m++;
		}
	}

	public static void main(String[] args) {
		String s = "abcdef";
		String res = leftShift(s, 2);
		System.out.println(res);
	}
}
