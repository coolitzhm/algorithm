package second;

/*
 * find the longest palindrome subString
 */
public class ManacherAlgorithm {
	// the first solution
	static int longestPalindrome(char[] chs, int n) {
		// because we deliver two parameter,we must check them all
		if (chs == null || n == 0)
			return 0;
		int i, j, max;
		max = 0;
		for (i = 0; i < n; i++) { // presume i is the middle position of the
									// palindrome subString
			for (j = 1; (i - j >= 0) && (i + j < n); j++) {
				if (chs[i - j] != chs[i + j])
					break;
			}
			if (j * 2 - 1 > max)
				max = j * 2 - 1;
			for (j = 0; (i - j >= 0) && (i + j + 1 < n); j++) {
				if (chs[i - j] != chs[i + j + 1])
					break;
			}
			if (j * 2 > max)
				max = j * 2;
		}
		return max;
	}

	// manacher solution
	static void manacher(char[] chs, int[] p, int len) {
		// System.out.println(len);
		p[0] = 1;
		int id = 0;
		// mx is the futhest position we can reach at the present
		int mx = 1;
		for (int i = 1; i < len; i++) {
			// manacher algorithm main idea
			if (mx > i) {
				p[i] = Math.min(p[2 * id - i], mx - i);
			} else {
				p[i] = 1;
			}
			// expand the palindrome length around i.
			// we must apend the situation of i - p[i] >=0 && i + p[i] < len
			while (i - p[i] >= 0 && i + p[i] < len
					&& chs[i + p[i]] == chs[i - p[i]]) {
				p[i]++;
			}

			// update the mx and id
			if (mx < i + p[i]) {
				mx = i + p[i];
				id = i;
			}
		}
	}

	static int longestPalindromeII(char[] chs, int n) {
		int max = 0;
		int[] p = new int[n];
		manacher(chs, p, n);
		for (int i : p) {
			if (i > max)
				max = i;
		}
		return max - 1;
	}

	// my thought: first maybe we could reverse the String
	// then if we can compare the resString and the initial String
	// if they have the longest consequent substring , the subString is the
	// result
	// this solution's time is O(n) and the space is O(n)
	// don't complete for now

	// teacher's update version to complete the manacher, we can reduce the
	// total of while loop.
	// len is the length of s.
	static void manacherUpdate(char[] s, int[] p, int len) {
		p[0] = 1;
		int id = 0;
		int mx = 1;
		for (int i = 1; i < len; i++) {
			if (mx > i) {
				if (p[2 * id - i] != mx - i) {
					p[i] = Math.min(p[2 * id - i], mx - i);
				} else {
					p[i] = p[2 * id - i];
					while (i - p[i] >= 0 && i + p[i] < len
							&& s[i + p[i]] == s[i - p[i]]) {
						p[i]++;
					}
				}
			} else {
				p[i] = 1;
				while (i - p[i] >= 0 && i + p[i] < len
						&& s[i + p[i]] == s[i - p[i]]) {
					p[i]++;
				}
			}
			if (mx < i + p[i]) {
				mx = i + p[i];
				id = i;
			}
		}
	}

	public static void main(String[] args) {
		String s = "12212321";
		// char[] chs = s.toCharArray();
		// int len = chs.length;
		// String s2 = "12212321";
		// char[] chs2 = s2.toCharArray();
		// int len2 = chs2.length;
		// int res1 = longestPalindrome(chs, len);
		// int res2 = longestPalindrome(chs2, len2);
		// System.out.println(res1 + " " + res2);
		// create the manacher String
		char[] chs = s.toCharArray();
		int len = chs.length;
		int lenM = 2 * len + 1;
		char[] chManacher = new char[lenM];
		for (int i = 0; i < lenM - 1; i++) {
			if (i % 2 == 1) {
				chManacher[i] = chs[i / 2];
			} else {
				chManacher[i] = '#';
			}
		}
		chManacher[lenM - 1] = '#';
		int res = longestPalindromeII(chManacher, lenM);
		System.out.println(res);
	}
}
