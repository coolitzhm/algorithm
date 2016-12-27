package second;

public class QuickSort {
	int[] array;

	public QuickSort(int[] array) {
		this.array = array;
	}

	public void quickSortALL() {
		quickSort(0, array.length - 1);
	}

	public void quickSort(int left, int right) {
		if (right <= left)
			return;
		int partition = partition(left, right);
		quickSort(left, partition - 1);
		quickSort(partition + 1, right);
	}

	public int partition(int left, int right) {
		int leftPtr = left - 1;
		int rightPtr = right;
		int pivot = array[right];
		while (leftPtr < rightPtr) {
			while (leftPtr < rightPtr && array[++leftPtr] < pivot)
				;
			array[rightPtr] = array[leftPtr];
			while (leftPtr < rightPtr && array[--rightPtr] > pivot)
				;
			array[leftPtr] = array[rightPtr];

		}
		array[leftPtr] = pivot;
		return leftPtr;
	}

	public static void main(String[] args) {
		int[] nums = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// int[] nums = { 2, 1, 5, 3, 6, 2, 2, 4, 8, 0, 9, 2 };
		// int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		QuickSort qs = new QuickSort(nums);
		qs.quickSortALL();
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}
