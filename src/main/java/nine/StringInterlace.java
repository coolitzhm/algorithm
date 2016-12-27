package nine;

public class StringInterlace {

	static boolean isInterlace(String s1, String s2, String s3) {

		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		char[] ch3 = s3.toCharArray();
		int l1 = ch1.length;
		int l2 = ch2.length;
		int l3 = ch3.length;
		if (l3 != l1 + l2)
			return false;

		boolean[][] dp = new boolean[l1 + 1][l2 + 1];
		dp[0][0] = true;

		int i, j;
		for (i = 1; i <= l1; i++) {
			dp[i][0] = (dp[i - 1][0] && ch3[i - 1] == ch1[i - 1]);
		}
		for (j = 1; j <= l2; j++) {
			dp[0][j] = (dp[0][j - 1] && ch3[j - 1] == ch2[j - 1]);
		}
		for (i = 1; i <= l1; i++) {
			for (j = 1; j <= l2; j++) {
				dp[i][j] = (dp[i][j - 1] && ch3[i + j - 1] == ch2[j - 1])
						|| (dp[i - 1][j] && ch3[i + j - 1] == ch1[i - 1]);
			}
		}
		return dp[l1][l2];
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "edf";
		String str3 = "aedbfc";
		boolean res = isInterlace(str1, str2, str3);
		System.out.println(res);
	}

}
