package second.secondlesson;

public class RainWater {
	public static int rainTake(int[] hespo) {
		int n = hespo.length;
		int left = 0;
		int right = n - 1;
		int trap = 0;
		int secHeight = 0;
		while (left < right) {
			if (hespo[left] < hespo[right]) {
				secHeight = Math.max(secHeight, hespo[left]);
				trap += secHeight - hespo[left];
				left++;
			} else {
				secHeight = Math.max(secHeight, hespo[right]);
				trap += secHeight - hespo[right];
				right--;
			}
		}
		return trap;
	}

	public static void main(String[] args) {
		int[] hespo = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] hespo1 = { 6, 3, 2, 0, 3, 2, 0, 1, 5, 6, 4, 3, 7, 5, 4, 0, 3, 2,
				5, 8, 2, 4 };
		int res = rainTake(hespo);
		int res1 = rainTake(hespo1);
		System.out.println(res);
		System.out.println(res1);
	}
}
