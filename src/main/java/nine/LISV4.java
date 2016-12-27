package nine;

import java.util.Stack;

/*
 * greedy: record the length and the subString of LIS
 */
public class LISV4 {
	static int getLIS(int[] a) {
		int len = a.length;
		// b is the accessorial array and stores the position
		int[] b = new int[len];
		int[] pre = new int[len];
		int max = 1;
		for (int i = 0; i < len; i++) {
			pre[i] = -1;
		}
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 1; i < len; i++) {
			max = insert(b, a, max, i, pre);
		}

		int cur = b[max - 1];
		while (cur != -1) {
			s.push(a[cur]);
			cur = pre[cur];
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		System.out.println();

		return max;
	}

	static int insert(int[] b, int[] a, int size, int i, int[] pre) {

		int low = 0;
		int high = size - 1;
		int mid;
		if (a[i] >= a[b[size - 1]]) {
			b[size] = i;
			pre[i] = b[size - 1];
			size++;
		} else {
			while (low < high) {
				mid = low + (high - low) / 2;
				if (a[i] <= a[b[mid]]) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}
			b[low] = i;
			pre[i] = (low == 0 ? -1 : b[low - 1]);
		}

		return size;
	}

	public static void main(String[] args) {
		int[] array = { 1, 4, 6, 2, 8, 9, 7 };

		// int[] array = { 1, 4, 6, 2, 3, 4, 7 };
		int res = getLIS(array);
		System.out.println(res);
	}
}
