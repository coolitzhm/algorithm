package second;

/*
 * 有重复字符的情况
 * 空间换时间，时间复杂度为恢复为无重复字符时的时间复杂度
 * 假设：字符范围是ascii码
 */
public class PermutationV3 {
	public static void permutation(char[] a, int size, int n) {
		if (n == size - 1) {
			print(a, size);
			return;
		}
		int[] dup = new int[256];
		for (int i = n; i < size; i++) {
			if (dup[a[i]] == 1)
				continue;
			dup[a[i]] = 1;
			swap(a, i, n);
			permutation(a, size, n + 1);
			swap(a, i, n);
		}
	}

	public static void swap(char[] array, int m, int n) {
		char temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}

	public static void print(char[] a, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// test
	public static void main(String[] args) {
		char[] a = { 'a', 'b', 'b', 'c' };
		int size = a.length;
		permutation(a, size, 0);
	}
}
