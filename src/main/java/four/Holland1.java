package four;

public class Holland1 {
	static void holland1(int[] array) {
		int n = array.length;
		int end = n - 1;
		int begin = 0;
		int tmp;
		for (int i = 0; i <= end;) {
			if (array[i] == 0) {
				if (begin == i) {
					begin++;
					i++;
				} else {
					tmp = array[begin];
					array[begin] = array[i];
					array[i] = tmp;
					begin++;
					// System.out.println("begin = " + begin);
				}

			} else if (array[i] == 1) {
				i++;
			} else if (array[i] == 2) {
				tmp = array[i];
				array[i] = array[end];
				array[end] = tmp;
				end--;
				// System.out.println("end = " + end);
			}
		}
	}

	static void hollandFinal(int[] array) {
		int n = array.length;
		int end = n - 1;
		int begin = 0;
		int tmp;
		for (int i = 0; i <= end;) {
			if (array[i] == 0) {

				tmp = array[begin];
				array[begin] = array[i];
				array[i] = tmp;

				begin++;
				i++;
			} else if (array[i] == 1) {
				i++;
			} else if (array[i] == 2) {
				tmp = array[i];
				array[i] = array[end];
				array[end] = tmp;
				end--;
				// System.out.println("end = " + end);
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 1, 0, 2, 0, 1, 1 };
		holland1(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
