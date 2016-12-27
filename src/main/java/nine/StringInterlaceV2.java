package nine;

/*
 * scoll array
 */
public class StringInterlaceV2 {
	static boolean isInterlace(String s1, String s2, String s3) {

		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		char[] ch3 = s3.toCharArray();
		int l1 = ch1.length;
		int l2 = ch2.length;
		int l3 = ch3.length;
		if (l3 != l1 + l2)
			return false;

		if (l1 > l2)
			return isInterlace(s2, s1, s3);

		boolean[] p = new boolean[l1 + 1];
		p[0] = true;
		int i, j;
		// initialize
		for (i = 1; i <= l1; i++) {
			p[i] = p[i - 1] && (ch3[i - 1] == ch1[i - 1]);
		}

		// drawing the matrix draft may make the solution more clear
		for (j = 1; j <= l2; j++) {
			p[0] = (p[0] && ch3[j - 1] == ch2[j - 1]);
			for (i = 1; i <= l1; i++) {
				p[i] = (p[i - 1] && ch3[i + j - 1] == ch1[i - 1])
						|| (p[i] && ch3[i + j - 1] == ch2[j - 1]);
			}
		}

		return p[l1];
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "edf";
		String str3 = "aedbfc";
		boolean res = isInterlace(str1, str2, str3);
		System.out.println(res);
	}
}
