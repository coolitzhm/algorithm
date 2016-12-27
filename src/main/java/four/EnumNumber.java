package four;

public class EnumNumber {
	int[] array;
	int sum;
	int size;

	public EnumNumber(int[] array, int sum) {
		// TODO Auto-generated constructor stub
		this.array = array;
		this.sum = sum;
		this.size = array.length;
	}

	void enumNumber(int[] x, int i, int sumCurrent) {
		int n = x.length;
		if (i >= n)
			return;
		if (sumCurrent + i == sum) {
			x[i] = 1;
			print(x);
		}

	}

	static void print(int[] x) {
		for (int i : x) {
			System.out.print(i + " ");
		}
	}

}
