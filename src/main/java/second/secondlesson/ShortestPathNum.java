package second.secondlesson;

import java.util.LinkedList;
import java.util.Queue;

/*
 * we know the start node
 */
public class ShortestPathNum {
	public static int shortestPathNum(int[][] g) {
		int n = g.length;
		int[] step = new int[n];
		int[] path = new int[n];
		path[0] = 1;
		Queue<Integer> q = new LinkedList<Integer>();// store the node who have
														// reached
														// the shortest path
		q.add(0);
		int cur, s;
		while (!q.isEmpty()) {
			cur = q.poll();
			// 0 is the start node ,don't need to be visited
			s = step[cur] + 1;
			for (int i = 1; i < n; i++) {
				if (g[cur][i] == 1) {
					// has not been visited or find shorter path(when and only
					// when weights are different)
					if (step[i] == 0 || step[i] > s) {
						step[i] = s;
						path[i] = path[cur];
						q.add(i);
					} else {
						// has been visited
						if (step[i] == s)
							path[i] += path[cur];
					}
				}
				if (i == n - 1)
					break;
			}
		}
		return path[n - 1];
	}

	public static void main(String[] args) {
		int[][] g = new int[10][10];
		g[0][1] = g[0][2] = 1;
		g[1][3] = g[2][3] = 1;
		g[3][4] = g[3][5] = 1;
		g[4][9] = g[5][9] = 1;
		g[9][7] = g[9][8] = 1;
		g[7][6] = g[8][6] = 1;
		int res = shortestPathNum(g);
		System.out.println(res);
	}
}
