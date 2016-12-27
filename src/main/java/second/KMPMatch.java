package second;

public class KMPMatch {

	public int kmpMatch(String t, String p) {
		char[] text = t.toCharArray();
		char[] pattern = p.toCharArray();
		int plen = pattern.length;
		int tlast = text.length;
		int[] next = new int[pattern.length];
		getNext2(pattern, next);
		// getNext(pattern, next);
		 for (int i : next) {
		 System.out.print(i + " ");
		 }
		// i is the position of text,j is the position of pattern when they are
		// compared
		// ans is the position where is the head of pattern in the text
		int i = 0, j = 0, ans = -1;
		while (i < tlast) {
			if (j == -1 || text[i] == pattern[j]) {
				++j;
				++i;
			} else {
				j = next[j];
			}
			if (j == plen) {
				ans = i - plen;
				break;
			}
		}
		return ans;
	}

	// we fill the next[]
	public void getNext(char[] pattern, int[] next) {
		int len = pattern.length;
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < len - 1) {
			if (k == -1 || pattern[j] == pattern[k]) {
				++j;
				++k;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
	}

	public void getNext2(char[] pattern, int[] next) {
		int len = pattern.length;
		next[0] = -1;
		int k = -1;
		int j = 0;
		// notice the range of j
		while (j < len - 1) {
			if (k == -1 || pattern[j] == pattern[k]) {
				++j;
				++k;
				if (pattern[j] == pattern[k]) {
					next[j] = next[k];
				} else {
					next[j] = k;
				}
			} else {
				k = next[k];
			}
		}

	}

	// return the position[i] the patternString first appear in the text
	public int BruteForce(String t, String p) {
		char[] text = t.toCharArray();
		char[] pattern = p.toCharArray();
		int plen = pattern.length;
		int tlen = text.length - plen;
		int i = 0;
		int j = 0;
		while (j < plen && i <= tlen) {
			if (text[i + j] == pattern[j]) {
				j++;
			} else {
				i++;
				j = 0;
			}
		}
		if (j >= plen)
			return i;
		return -1;
	}

	public static void main(String[] args) {
		KMPMatch kmp = new KMPMatch();
		String test = "aaababaabcabcba";
		String pattern = "abaabca";
		int b = kmp.BruteForce(test, pattern);
		int k = kmp.kmpMatch(test, pattern);
		System.out.println();
		System.out.println(b);
		System.out.println(k);

		// char[] ts = test.toCharArray();
		// int[] next = new int[ts.length + 1];// the length of array next
		// should
		// be the length of array plus one
		// kmp.getNext(ts, next);
		// for (int i : next) {
		// System.out.print(i + " ");
		// }
	}
}
