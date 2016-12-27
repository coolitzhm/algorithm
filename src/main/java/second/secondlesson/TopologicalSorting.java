package second.secondlesson;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {

	public static int[] topologicalSorting(Graph g) {
		int[][] adj = g.graph;
		int n = g.num;
		int[] toposort = new int[n];
		int cnt = 0;
		int[] indegree = g.getIndegree();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		int cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			toposort[cnt++] = cur;
			for (int i = 0; i < n; i++) {
				if (adj[cur][i] == 1) {
					indegree[i]--;
					adj[cur][i] = 0;
					if (indegree[i] == 0)
						q.add(i);
				}	
			}
		}
		return toposort;
	}

	public static void main(String[] args) {
		int[][] graph = new int[8][8];
		graph[0][1] = 1;
		graph[0][6] = 1;
		graph[0][7] = 1;
		graph[7][3] = 1;
		graph[2][1] = 1;
		graph[2][3] = 1;
		graph[4][1] = 1;
		graph[5][2] = 1;
		Graph g = new Graph(graph);
		int[] topoSort = topologicalSorting(g);
		for (int i : topoSort) {
			System.out.print(i + " ");
		}
	}
}
