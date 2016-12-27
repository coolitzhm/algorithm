package second;

public class FirstTwoBiggestNumber {
	public void findTwoBiggerstNumber(int[] nums) {
		int maxNum = nums[0];
		int secondNum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > maxNum) {
				secondNum = maxNum;
				maxNum = nums[i];
			} else {
				if (nums[i] > secondNum)
					secondNum = nums[i];
			}
		}
		System.out.println("maxNum: " + maxNum + " secondNum: " + secondNum);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		FirstTwoBiggestNumber ft = new FirstTwoBiggestNumber();
		ft.findTwoBiggerstNumber(nums);
	}

}
