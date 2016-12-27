package second;

public class Permutation {
	public static void permutation(int[] a, int size, int n) {
		if (n == size - 1) {
			print(a, size);
			return;
		}
		for (int i = n; i < size; i++) {
			swap(a, i, n);
			permutation(a, size, n + 1);
			swap(a, i, n);
			// print(a,size);
		}
	}

	public  static void print(int[] array, int size) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// 注意swap如果传入的参数是两个int值的话，并不会对数组a产生影响
	public  static void swap(int[] a, int m, int n) {
		int tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int size = a.length;
		permutation(a, size, 0);
	}
}
