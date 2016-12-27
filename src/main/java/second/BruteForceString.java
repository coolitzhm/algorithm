package second;
/*
 *  暴力解法
 */
public class BruteForceString {
	public static int BFMatchPos(String text, String pattern) {
		char[] chtext = text.toCharArray();
		char[] chpattern = pattern.toCharArray();

		int lenP = chpattern.length;
		int lenTM = chtext.length - lenP;
		int i = 0, j = 0;
		while (i <= lenTM && j < lenP) {
			if (chtext[i + j] == chpattern[j]) {
				j++;
			} else {
				i++;
				j = 0;
			}
		}
		if (j == lenP)
			return i;

		return -1;
	}

	public static void main(String[] args) {
		String text = "ababcabcdfe";
		String pattern = "bcabcd";
		// String pattern2 = "aabbb";
		int res = BFMatchPos(text, pattern);
		System.out.println(res);
	}
}
