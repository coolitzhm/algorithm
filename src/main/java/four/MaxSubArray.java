package four;

public class MaxSubArray {
	static int maxSubArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int n = array.length;
		int max = array[0];
		int sum = max;
		for (int i = 1; i < n; i++) {
			if (sum > 0) {
				sum += array[i];
			} else {
				sum = array[i];
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	// get the max subString,not to consider that array is null
	static int getMaxSubString(int[] array) {
		int n = array.length;
		int from = 0;
		int to = 0;
		int sum = array[0];
		int max = sum;
		for (int i = 1; i < n; i++) {
			if (sum > 0) {
				sum += array[i];
			} else {
				sum = array[i];
				from = i;
			}
			if (sum > max) {
				max = sum;
				to = i;
			}
		}
		// test
		System.out.println("from = " + from);
		System.out.println("to = " + to);
		for (int i = from; i <= to; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		return max;
	}

	static int teacherMethod(int[] array) {
		int n = array.length;
		int from = 0;
		int to = 0;
		int sum = array[0];
		int max = sum;
		int fromNew = 0;
		for (int i = 1; i < n; i++) {
			if (sum > 0) {
				sum += array[i];
			} else {
				sum = array[i];
				fromNew = i;
			}
			if (sum > max) {
				max = sum;
				from = fromNew;
				to = i;
			}
		}
		// test
		System.out.println("from = " + from);
		System.out.println("to = " + to);
		for (int i = from; i <= to; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		return max;
	}

	public static void main(String[] args) {
		// int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int[] array = { -1, 2, 3, 4, -5 };
		// int[] array = { 1 };
		int res = maxSubArray(array);
		System.out.println(res);
		int res2 = getMaxSubString(array);
		System.out.println(res2);
		int res3 = teacherMethod(array);
		System.out.println(res3);
	}
}
