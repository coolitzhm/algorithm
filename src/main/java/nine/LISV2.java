package nine;

import java.util.Stack;

/*
 * record the LIS 
 */
public class LISV2 {

	static int getLIS(int[] a) {
		if (a == null)
			return 0;

		int len = a.length;
		if (len == 1) {
			System.out.println("LIS is : " + a[0]);
			return 1;
		}

		Stack<Integer> s = new Stack<Integer>();
		int max = 1;
		int[] b = new int[len];
		int[] pre = new int[len];
		int suffix = -1;
		for (int i = 0; i < len; i++) {
			b[i] = 1;
			pre[i] = -1;
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && b[j] + 1 > b[i]) {
					b[i] = b[j] + 1;
					pre[i] = j;
				}
			}
			if (b[i] > max) {
				max = b[i];
				suffix = i;
			}
		}

		// use the stack to reverse the pre array
		while (suffix != -1) {
			s.push(a[suffix]);
			suffix = pre[suffix];
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		System.out.println();
		return max;
	}

	public static void main(String[] args) {
		// int[] array = {1,4,6,2,8,9,7};
		int[] array = { 1, 4, 6, 2, 3, 4, 7 };
		int res = getLIS(array);
		System.out.println(res);
	}

}
