package four;

/*
 * I haven't seen the following lesson,
 * so this is my understand from the PPT
 * this function is to generate  the cantor String
 * paragram is the original array
 * return the cantor array.
 */
public class CantorExpansion {
	static int[] cantorString(int[] array) {
		int n = array.length;
		int[] cantor = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[i]) {
					cantor[i]++;
				}
			}
		}
		return cantor;
	}

	public static void main(String[] args) {
		int[] array = { 2, 6, 4, 5, 3, 1 };
		int[] res = cantorString(array);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
