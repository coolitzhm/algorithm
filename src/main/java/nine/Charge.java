package nine;

/*
 * scoll array
 */
public class Charge {
	static int charge(int value, int[] denomination, int size) {

		int[] dp = new int[value + 1];
		int[] last = new int[value + 1];
		int i, j;

		for (j = 0; j <= value; j++) {
			dp[j] = 1;
			last[j] = 1;
		}
		// 数组dp，是在当前面额下的不同数值的组成方式
		// 数组last，是在上一个面额下的不同数值的组成方式。
		// 当结束一个j的循环的时候，用dp来更新last，从而求下一个面值下的dp
		for (i = 1; i < size; i++) {
			for (j = 1; j <= value; j++) {
				if (j > denomination[i]) {
					dp[j] = dp[j - denomination[i]] + last[j];
					last[j] = dp[j];
				}
			}
		}
		int groups = dp[value];
		return groups;

	}
	public static void main(String[] args) {
		int[] denomination = { 1, 2, 5, 10, 50, 100 };
		int size = denomination.length;
		// int value = 5;
		int value = 10;
		int res = charge(value, denomination, size);
		System.out.println(res);
	}
}
