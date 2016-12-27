package thred;

/*
 * 实现全排列的时间复杂度：O(n* n!)
 */
public class NextPermutation {
	public static boolean nextPermutation(int[] a, int size, int n) {
		// to find the first ascending from the end
		int i = size - 2;
		while (a[i] >= a[i + 1]) {
			i--;
			if (i < 0)
				return false;
		}
		// the find the smallest number bigger than a[i]
		int j = size - 1;
		while (a[j] <= a[i])
			j--;
		// swap the two number
		swap(a, i, j);

		// reverse the sequence behind a[i]
		reverse(a, i + 1, size - 1);

		return true;
	}

	public static void print(int[] a, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void swap(int[] a, int m, int n) {
		int tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}

	public static void reverse(int[] array, int m, int n) {
		while (m < n) {
			int tmp = array[m];
			array[m] = array[n];
			array[n] = tmp;
			m++;
			n--;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 4 };
		int size = a.length;
		int count = 1;
		print(a, size);
		while (nextPermutation(a, size, 0)) {
			print(a, size);
			count++;
		}

		System.out.println(count);
	}
}
