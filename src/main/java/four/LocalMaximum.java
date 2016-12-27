package four;

/*
 * 二分法
 */
public class LocalMaximum {
	static int localMaximum(int[] array) {

		int n = array.length;
		int left = 0;
		int right = n - 1;
		int mid;

		while (left < right) {
			mid = (left + right) / 2;
			System.out.print(mid + " ");
			if (array[mid] > array[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println();
		return array[left];
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 1, 2, 6, 1, 8 };
		int res = localMaximum(array);
		System.out.println(res);
	}
}
