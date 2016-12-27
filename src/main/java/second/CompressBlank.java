package second;

/*
 * 给定某字符串s,该字符串中有空格，删除这些空格，并返回修改后的字符串；
 * 要求：空间复杂度O(N)，空间复杂度O(1)
 * <注>可能两个单词之间存在若干空格
 * 思路1：两个指针，如果j指向的不是空格，且i和j不相等，那么把j的值赋给i
 * 思路1：j到结尾停下来。把剩下的char的位置赋值为0
 * 思路2：计数，根据空格数移位
 */
public class CompressBlank {
	public void removeBlank(char[] ch) {
		int len = ch.length;
		int i = 0;
		for (int j = 0; j < len; j++) {

			if (ch[j] != ' ') {
				if (i != j) {
					ch[i] = ch[j];
				}
				i++;
			}
		}
		for (int k = i; k < ch.length; k++) {
			ch[k] = '\0';// ch[k] = 0;
		}
		// System.out.println(ch.length);
		// ch[i] = 0;
		// for (char c : ch) {
		// System.out.print(c);
		// }
		// ch[i + 1] = 'H';
		// System.out.println();
		// for (char c : ch) {
		// System.out.print(c);
		// }
		//
		// System.out.println("\n" + ch.length + "\n");
		// ch[i] = 'B';
		// for (char c : ch) {
		// System.out.print(c);
		// }

	}

	// solution2: when we encounters blanks count and move and
	// when we encounters elements move elements to the blanks forth
	public void removeBlank2(char[] ch) {
		int blankCount = 0;
		int i = 0;
		for (; i < ch.length; i++) {
			if (ch[i] == ' ')
				blankCount++;
			else {
				ch[i - blankCount] = ch[i];
			}
		}
		for (int j = ch.length - blankCount; j < ch.length; j++) {
			ch[j] = 0;
		}
	}

	// public void test(char[] ch) {
	// for (int i = 0; i < ch.length; i++) {
	// if (ch[i] == ' ')
	// ch[i] = 'M';
	// }
	// }

	public static void main(String[] args) {
		String s = "I have a   dream.";
		char[] ch = s.toCharArray();
		CompressBlank cb = new CompressBlank();
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
		cb.removeBlank(ch);
		// cb.removeBlank2(ch);
		// cb.test(ch);
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
		}
	}

}
