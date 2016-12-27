package second;

/*
 * 只返回可能的一个LCS
 */
public class LCSequence {
	public static String getLCS(char[] chA, char[] chB) {
		int m = chA.length;
		int n = chB.length;
		int[][] c = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (chA[i] == chB[j])
					c[i + 1][j + 1] = c[i][j] + 1;
				else {
					c[i + 1][j + 1] = Math.max(c[i][j + 1], c[i + 1][j]);
				}
			}
		}
		int len = c[m][n];
		int k = len - 1;
		char[] res = new char[len];
		// System.out.println(i);
		// System.out.println(j);
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (chA[i - 1] == chB[j - 1]) {
				res[k--] = chA[i - 1];
				i--;
				j--;
			} else {
				if (c[i - 1][j] > c[i][j - 1])
					i--;
				else {
					j--;
				}
			}
		}
		return String.valueOf(res);
	}

	public static void main(String[] args) {
		// String a = "abcbdab";
		// String b = "bdcaba";
		String a = "abac";
		String b = "ababc";
		char[] chA = a.toCharArray();
		char[] chB = b.toCharArray();
		String res = getLCS(chA, chB);
		System.out.println(res);

	}

}
