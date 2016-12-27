package nine;


/*
 * greedy:only to record the length of LIS
 * O(NlogN)
 * strategy: write the fake code first
 * this solution is to solve the nondecreasing LIS 
 * my solution has a little difference from the teacher's
 */
public class LISV3 {

	static int getLIS(int[] a) {
		int len = a.length;
		// b is accessoril array and storage the element value
		int[] b = new int[len];

		int max = 1;
		for (int i = 1; i < len; i++) {
			max = insert(b, a[i], max);
		}
		return max;
	}

	static int insert(int[] b, int cur, int max) {
		if (max <= 0) {
			b[0] = cur;
			max++;
			return max;
		}
		int low = 0;
		int high = max;
		int mid;
		if (cur >= b[max - 1]) {
			b[max++] = cur;
		} else {
			while (low < high) {
				mid = low + (high - low) / 2;
				if (b[mid] > cur) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}
			b[low] = cur;
		}
		return max;
	}

	public static void main(String[] args) {
		// int[] array = { 1, 4, 6, 2, 8, 9, 7 };

		int[] array = { 1, 3, 2, 3, 4, 5, 6, 7 };
		int res = getLIS(array);
		System.out.println(res);
	}
}
