package four;

import java.util.LinkedList;
import java.util.List;

/*
 * we know the ordered array and the cantor array
 * then to revert the original array
 */
public class CantorExpensionR {

	static int[] cantorExpensionR(int[] array, int[] cantor, int n) {
		// delete an element from an array is a time-consuming thing.
		// so I replace the ordered array with a list
		List<Integer> b = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			b.add(i + 1);
		}

		// then we can complete the algorithm
		for (int i = 0; i < n; i++) {
			array[i] = b.get(cantor[i]);
			b.remove(cantor[i]);
		}

		return array;
	}

	// the same with teacher's
	static void cantorExpensionR2(int[] array, int[] c, int n) {
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (array[j] != 0)// 这个位置的0,已经记录过了
					continue;
				if (c[j] == 0)
					break;
				c[j]--;// 用逆序的想法去想
			}
			array[j] = i + 1;
		}
	}

	public static void main(String[] args) {
		int[] ordered = { 1, 2, 3, 4, 5, 6 };
		// int[] cantor = { 1, 4, 2, 2, 1, 0 };
		int[] cantor = { 1, 0, 0, 1, 1, 0 };
		int n = ordered.length;
//		 int[] res = cantorExpensionR(ordered, cantor, n);
//		 for (int i : res) {
//		 System.out.print(i + " ");
//		 }

		int[] array = new int[n];
		cantorExpensionR2(array, cantor, n);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
