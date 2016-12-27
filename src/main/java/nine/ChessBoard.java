package nine;

import java.util.Random;

/*
 * the chessboard is m*n
 */
public class ChessBoard {
	static int minPath(int[][] chess, int m, int n) {
		int[] dp = new int[n];
		dp[0] = chess[0][0];
		for (int j = 1; j < n; j++) {
			dp[j] = dp[j - 1] + chess[0][j];
		}

		for (int i = 1; i < m; i++) {
			dp[0] += chess[i][0];
			for (int j = 1; j < n; j++) {
				dp[j] = Math.min(dp[j], dp[j - 1]) + chess[i][j];
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int m = 5;
		int n = 4;
		Random rand = new Random();
		int[][] chess = new int[10][8];
		// you can adjust the matrix value by yourself to test
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				chess[i][j] = rand.nextInt(10);
				// chess[i][j] = j + 1;
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		int res = minPath(chess, m, n);
		System.out.println(res);

	}
}
