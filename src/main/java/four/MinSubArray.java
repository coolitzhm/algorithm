package four;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * we want to find  the sequential subString almost close to zeros
 */
public class MinSubArray {
	// the following is teacher's method but it has a little difference about
	// the sum
	// array with teacher's.
	// and the result is always the positive value or zero.
	// 时间复杂度O（NlogN),空间复杂度O(N)
	static int minSubArray(int[] array) {
		int n = array.length;
		int[] sum = new int[n + 1];
		sum[0] = 0;
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + array[i];
		}
		// Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.sort(sum);// 双指针快排O(NlogN)
		int min = Math.abs(sum[1] - sum[0]);// 初始化
		int tmp;
		for (int i = 1; i < n; i++) {
			tmp = sum[i + 1] - sum[i];
			if (Math.abs(tmp) <= Math.abs(min))
				min = tmp;
		}
		return min;
	}

	// we want to get the subString
	// I use the map to store the index ,
	// and the quantity of the code increase a lot
	static int getMinSubArray(int[] array) {
		int n = array.length;
		int[] sum = new int[n + 1];
		sum[0] = 0;
		// map is to store the index
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(sum[0], 0);
		int left = 0;
		for (int i = 1; i < n + 1; i++) {
			sum[i] = sum[i - 1] + array[i - 1];
			if (map.containsKey(sum[i])) {
				left = map.get(sum[i]);
				System.out.println("left = " + left);
				System.out.println("right = " + i);
				for (int j = left; j < i; j++) {
					System.out.print(array[j] + " ");
				}
				System.out.println();
				return 0;
			} else {
				map.put(sum[i], i);
			}
		}

		Arrays.sort(sum);// 双指针快排O(NlogN)
		int min = sum[1] - sum[0];
		int tmp;
		int right = 1;
		for (int i = 1; i < n; i++) {
			tmp = sum[i + 1] - sum[i];
			if (Math.abs(tmp) <= Math.abs(min)) {
				min = tmp;
				left = map.get(sum[i]);
				right = map.get(sum[i + 1]);
				System.out.println("left = " + left);
				System.out.println("right = " + right);
			}
		}
		// 排序导致的
		if (left > right) {
			tmp = left;
			left = right;
			right = tmp;
		}
		min = -min;
		System.out.println("left = " + left);
		System.out.println("right = " + right);
		for (int j = left; j < right; j++) {
			System.out.print(array[j] + " ");
		}
		System.out.println();
		return min;
	}

	public static void main(String[] args) {
		// int[] array = { 200, -10, 5 };// 结果不正确，打印的思路是对的，原来的算法写错了
		// int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
		// int[] array = { 1, 2, -2 };
		int[] array = { 1, -1 };
		int res = minSubArray(array);
		System.out.println(res);
		int res2 = getMinSubArray(array);
		System.out.println(res2);

	}
}
