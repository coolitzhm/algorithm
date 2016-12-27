package thred;

/*
 * when the array include the same values
 * 这个方法的时间复杂度为O((n+1)!)
 */
public class PermutationV2 {
	public static void permutation(int[] a, int size, int n) {
		if (n == size - 1) {
			print(a, size);
			return;
		}
		for (int i = n; i < size; i++) {
			if (!isDuplication(a, n, i)) {
				swap(a, i, n);
				permutation(a, size, n + 1);
				swap(a, i, n);
			}
			// print(a,size);
		}
	}

	public static boolean isDuplication(int[] array, int i, int j) {
		for (int k = i; k < j; k++) {
			if (array[k] == array[j])
				return true;
		}
		return false;
	}

	public static void print(int[] array, int size) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// 注意swap如果传入的参数是两个int值的话，并不会对数组a产生影响
	public static void swap(int[] a, int m, int n) {
		int tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}

	// test
	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 4 };
		int size = a.length;
		permutation(a, size, 0);
	}
}
